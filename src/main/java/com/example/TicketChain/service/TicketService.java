package com.example.TicketChain.service;

import java.math.BigInteger;
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
    public void startListeningTicketTransferredEvents() {
        ticketNFT.ticketTransferredEventFlowable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    BigInteger tokenId = event.tokenId;
                    String newOwner = event.to;
                    String from = event.from;

                    System.out.println(
                            "TicketTransferred event: TokenID " + tokenId + ", From: " + from + ", To: " + newOwner);

                    // Cập nhật vào database
                    ticketRepository.findByTokenId(tokenId)
                            .ifPresentOrElse(ticket -> {
                                ticket.setOwner_address(newOwner);
                                ticketRepository.save(ticket);
                                System.out.println("DB updated: TokenID " + tokenId + " -> newOwner: " + newOwner);
                            }, () -> {
                                System.err.println("Ticket with TokenID " + tokenId + " not found in DB");
                            });

                }, error -> {
                    System.err.println("Error listening TicketTransferred: " + error.getMessage());
                });
    }
}
