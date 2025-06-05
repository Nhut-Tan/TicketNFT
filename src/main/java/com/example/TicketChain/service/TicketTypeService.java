package com.example.TicketChain.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.TicketChain.dto.response.TicketTypeResponse;
import com.example.TicketChain.entity.TicketType;
import com.example.TicketChain.repository.TicketTypeRepository;

@Service
public class TicketTypeService {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    public List<TicketTypeResponse> getTicketTypesByEventId(BigInteger eventId) {
        List<TicketType> ticketTypes = ticketTypeRepository.findByEvent_EventId(eventId);

        return ticketTypes.stream().map(ticketType -> new TicketTypeResponse(
                ticketType.getTicket_type_id(),
                ticketType.getName(),
                ticketType.getPrice(),
                ticketType.getAmount(),
                ticketType.getRemaining_amount(),
                ticketType.getMetadataURI(),
                ticketType.getBenefits())).toList();
    }
}
