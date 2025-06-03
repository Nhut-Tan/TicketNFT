package com.example.TicketChain.service;

import org.web3j.utils.Convert;
import java.math.BigInteger;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.web3j.model.EventManager;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.TicketChain.dto.request.CreateEventRequest;
import com.example.TicketChain.dto.request.TicketTypeDTO;
import com.example.TicketChain.dto.response.EventDetailResponse;
import com.example.TicketChain.entity.Events;
import com.example.TicketChain.entity.Organizers;
import com.example.TicketChain.entity.TicketType;
import com.example.TicketChain.repository.EventRepository;
import com.example.TicketChain.repository.OrganizerRepository;
import com.example.TicketChain.repository.TicketTypeRepository;
import com.example.TicketChain.core.EventStatus;

import jakarta.transaction.Transactional;

@Service
public class EventService {
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    // private final Web3j web3j;
    // private final Credentials credentials;
    // private final String eventcontractAddress;
    // private final EventManager eventContract;

    // @Autowired
    // public EventService(Web3j web3j, Credentials credentials,
    // @Value("${contract.event-address}") String eventcontractAddress) {
    // this.web3j = web3j;
    // this.credentials = credentials;
    // this.eventcontractAddress = eventcontractAddress;

    // // Load contract instance
    // this.eventContract = EventManager.load(
    // eventcontractAddress,
    // web3j,
    // credentials,
    // new DefaultGasProvider());
    // }
    private final EventManager eventContract;

    public EventService(EventManager eventContract) {
        this.eventContract = eventContract;
    }

    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    // public EventDetailResponse getEventDetail(BigInteger eventId) {
    // return eventRepository.findEventDetailById(eventId);
    // }

    public EventDetailResponse getEventDetail(BigInteger eventId) {
        return eventRepository.findSimpleEventDetailById(eventId);
    }

    @Transactional
    public Events createEvent(CreateEventRequest req) throws Exception {
        // 1. Organizer
        Organizers organizer = organizerRepository.findByName(req.getOrganizer().getName())
                .orElseGet(() -> {
                    Organizers newOrg = new Organizers();
                    newOrg.setName(req.getOrganizer().getName());
                    newOrg.setLogo(req.getOrganizer().getLogo());
                    newOrg.setDescription(req.getOrganizer().getDescription());
                    return organizerRepository.save(newOrg);
                });
        // 2. Gọi Smart Contract
        // Chuyển đổi List<TicketTypeDTO> thành List<BigInteger> cho giá vé
        List<BigInteger> ticketPrices = req.getTicketTypes().stream()
                .map(ticketType -> Convert.toWei(ticketType.getPrice(), Convert.Unit.ETHER).toBigIntegerExact())
                .collect(Collectors.toList());
        // Chuyển đổi List<TicketTypeDTO> thành List<BigInteger> cho số lượng vé
        List<BigInteger> ticketQuantities = req.getTicketTypes()
                .stream()
                .map(ticketType -> ticketType.getAmount())
                .collect(Collectors.toList());

        // Chuyển đổi List<TicketTypeDTO> thành List<String> cho metadata URI
        List<String> metadataURIs = req.getTicketTypes()
                .stream()
                .map(TicketTypeDTO::getMetadataURI)
                .collect(Collectors.toList());

        // Gọi hàm createEvent trong contract
        TransactionReceipt receipt = eventContract.createEvent(
                req.getOrganizer().getName(),
                ticketPrices,
                ticketQuantities,
                metadataURIs).send();
        // Bắt event trả về
        List<EventManager.EventCreatedEventResponse> events = eventContract.getEventCreatedEvents(receipt);
        List<EventManager.TicketTypeCreatedEventResponse> ticketEvents = eventContract
                .getTicketTypeCreatedEvents(receipt);

        if (events.isEmpty()) {
            throw new RuntimeException("Event creation failed on blockchain");
        }

        BigInteger eventId = events.get(0).eventId;
        // 3. Event
        Events event = new Events();
        event.setEvent_id(eventId); // id sự kiện lấy từ blockchain
        event.setEvent_name(req.getEvent().getName());
        event.setLocation(req.getEvent().getLocation());
        event.setDescription(req.getEvent().getDescription());
        event.setImage_url(req.getEvent().getImage_url());
        event.setDate_start(req.getEvent().getDateStart());
        event.setDate_end(req.getEvent().getDateEnd());
        event.setStatus(EventStatus.UPCOMING);
        event.setOrganizer(organizer);

        eventRepository.save(event);

        // 4. Lưu từng loại vé tương ứng với ticketTypeId từ event
        List<TicketTypeDTO> requestTicketTypes = req.getTicketTypes();

        if (ticketEvents.size() != requestTicketTypes.size()) {
            throw new RuntimeException("Mismatch between ticket types created on-chain and request data");
        }

        for (int i = 0; i < requestTicketTypes.size(); i++) {
            TicketTypeDTO t = requestTicketTypes.get(i);
            EventManager.TicketTypeCreatedEventResponse ev = ticketEvents.get(i);

            TicketType type = new TicketType();
            type.setTicket_type_id(ev.ticketTypeId); // ← Lấy từ contract
            type.setName(t.getName());
            type.setPrice(t.getPrice());
            type.setAmount(t.getAmount().intValue());
            type.setRemaining_amount(t.getAmount().intValue());
            type.setMetadataURI(t.getMetadataURI());
            type.setBenefits(t.getBenefits());
            type.setEvent(event);

            ticketTypeRepository.save(type);
        }

        return event;
    }

}
