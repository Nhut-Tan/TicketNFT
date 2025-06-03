package com.example.TicketChain.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketChain.dto.request.CreateEventRequest;
import com.example.TicketChain.dto.response.EventDetailResponse;
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

    @GetMapping("/events")
    public ResponseEntity<List<Events>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    // @GetMapping("/events/{id}")
    // public ResponseEntity<?> getEventDetail(@PathVariable("id") BigInteger id) {
    // try {
    // Events event = eventService.getEventById(id);
    // return ResponseEntity.ok(event);
    // } catch (RuntimeException e) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",
    // e.getMessage()));
    // }
    // }
    @GetMapping("/events/{id}")
    public ResponseEntity<EventDetailResponse> getEventDetail(@PathVariable("id") BigInteger eventId) {
        EventDetailResponse event = eventService.getEventDetail(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
