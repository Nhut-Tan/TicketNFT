package com.example.TicketChain.controller;

import com.example.TicketChain.dto.request.TicketDTO;
import com.example.TicketChain.dto.response.TicketResponse;
import com.example.TicketChain.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket/{walletAddress}")
    public ResponseEntity<List<TicketResponse>> getOwnedTickets(@PathVariable String walletAddress) {
        List<TicketResponse> tickets = ticketService.getTicketsByWalletAddress(walletAddress);
        return ResponseEntity.ok(tickets);
    }
    @GetMapping("/ticket")
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        List<TicketResponse> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
}