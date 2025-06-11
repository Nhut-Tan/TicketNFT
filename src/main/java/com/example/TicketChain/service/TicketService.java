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
}
