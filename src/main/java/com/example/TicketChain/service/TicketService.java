package com.example.TicketChain.service;

import com.example.TicketChain.dto.request.TicketDTO;
import com.example.TicketChain.dto.response.TicketResponse;
import com.example.TicketChain.entity.OrderDetail;
import com.example.TicketChain.entity.Tickets;
import com.example.TicketChain.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.web3j.model.TicketNFT;
import org.web3j.protocol.core.DefaultBlockParameterName;

import com.example.TicketChain.repository.TicketRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    private final TicketNFT ticketNFT;

    public TicketService(TicketNFT ticketNFT, TicketRepository ticketRepository) {
        this.ticketNFT = ticketNFT;
        this.ticketRepository = ticketRepository;
    }

    @PostConstruct
    public void listenToTransferEvents() {
        ticketNFT.transferEventFlowable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    BigInteger tokenId = event.tokenId;
                    String from = event.from;
                    String to = event.to;

                    System.out.println("Transfer Event detected: TokenId=" + tokenId + ", from=" + from + ", to=" + to);

                    ticketRepository.findByTokenId(tokenId)
                            .ifPresentOrElse(ticket -> {
                                ticket.setOwner_address(to);
                                ticketRepository.save(ticket);
                                System.out.println("NewOwner đã được cập nhật" + to);
                            }, () -> {
                                System.err.println("Không tìm thấy tokenId này" + tokenId);
                            });

                }, error -> {
                    System.err.println("Lỗi khi listener event" + error.getMessage());
                });
    }
    public List<TicketResponse> getTicketsByWalletAddress(String walletAddress) {
        List<Tickets> tickets = ticketRepository.findByOwner_address(walletAddress);

        return tickets.stream().map(ticket -> {
            TicketResponse response = new TicketResponse();
            response.setTicketId(ticket.getTicket_id());
            response.setEventId(ticket.getTicketType().getEvent().getEvent_id());
            response.setEventName(ticket.getTicketType().getEvent().getEvent_name());
            response.setTicketName(ticket.getTicketType().getName());
            response.setPrice(ticket.getTicketType().getPrice());
            response.setStatus(ticket.getStatus().toString());
            response.setLocation(ticket.getTicketType().getEvent().getLocation());
            response.setEventDate(ticket.getTicketType().getEvent().getDate_start());
            response.setWalletAddress(ticket.getOwner_address());
            response.setTokenId(ticket.getToken_id());
            response.setImageUrl(ticket.getTicketType().getEvent().getImage_url());
            response.setTxHash(ticket.getTransaction() != null ? ticket.getTransaction().getTx_hash() : null);

            // Get purchase date from OrderDetail
            if (ticket.getOrderDetails() != null && !ticket.getOrderDetails().isEmpty()) {
                OrderDetail orderDetail = ticket.getOrderDetails().get(0);
                response.setPurchaseDate(orderDetail.getOrder().getTransaction().getCreated_at());
            }

            return response;
        }).collect(Collectors.toList());
    }
    public List<TicketResponse> getAllTickets() {
        List<Tickets> tickets = ticketRepository.findAll();

        return tickets.stream().map(ticket -> {
            TicketResponse response = new TicketResponse();
            response.setTicketId(ticket.getTicket_id());
            response.setEventId(ticket.getTicketType().getEvent().getEvent_id());
            response.setEventName(ticket.getTicketType().getEvent().getEvent_name());
            response.setTicketName(ticket.getTicketType().getName());
            response.setPrice(ticket.getTicketType().getPrice());
            response.setStatus(ticket.getStatus().toString());
            response.setLocation(ticket.getTicketType().getEvent().getLocation());
            response.setEventDate(ticket.getTicketType().getEvent().getDate_start());
            response.setWalletAddress(ticket.getOwner_address());
            response.setTokenId(ticket.getToken_id());
            response.setImageUrl(ticket.getTicketType().getEvent().getImage_url());
            response.setTxHash(ticket.getTransaction() != null ? ticket.getTransaction().getTx_hash() : null);

            // Get purchase date from OrderDetail
            if (ticket.getOrderDetails() != null && !ticket.getOrderDetails().isEmpty()) {
                OrderDetail orderDetail = ticket.getOrderDetails().get(0);
                response.setPurchaseDate(orderDetail.getOrder().getTransaction().getCreated_at());
            }

            return response;
        }).collect(Collectors.toList());
    }
}
