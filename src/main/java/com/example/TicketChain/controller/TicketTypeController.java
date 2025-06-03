package com.example.TicketChain.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketChain.dto.response.TicketTypeResponse;
import com.example.TicketChain.service.TicketTypeService;

@RestController
@RequestMapping("/api")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;

    @GetMapping("/ticket-types/event/{eventId}")
    public ResponseEntity<List<TicketTypeResponse>> getTicketTypesByEvent(@PathVariable BigInteger eventId) {
        List<TicketTypeResponse> result = ticketTypeService.getTicketTypesByEventId(eventId);
        return ResponseEntity.ok(result);
    }
}
