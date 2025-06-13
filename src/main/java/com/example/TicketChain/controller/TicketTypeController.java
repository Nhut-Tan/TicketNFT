package com.example.TicketChain.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TicketChain.dto.response.TicketTypeResponse;
import com.example.TicketChain.service.TicketTypeService;
@CrossOrigin(origins = "http://localhost:5173")
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
