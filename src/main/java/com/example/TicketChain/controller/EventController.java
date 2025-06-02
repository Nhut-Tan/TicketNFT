package com.example.TicketChain.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketChain.dto.request.CreateEventRequest;
import com.example.TicketChain.entity.Events;
import com.example.TicketChain.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create_event")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequest request) {
        try {
            Events createdEvent = eventService.createEvent(request);
            return ResponseEntity.ok(Map.of(
                    "message", "Tạo sự kiện thành công",
                    "event", createdEvent));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Tạo sự kiện thất bại: " + e.getMessage());
        }
    }
}
