package com.example.TicketChain.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import com.example.TicketChain.core.EventStatus;
import com.example.TicketChain.dto.request.CreateEventRequest;
import com.example.TicketChain.dto.request.EventSearchRequest;
import com.example.TicketChain.dto.response.EventDetailResponse;
import com.example.TicketChain.entity.Events;
import com.example.TicketChain.service.EventService;
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDetailResponse> getEventDetail(@PathVariable("id") BigInteger eventId) {
        EventDetailResponse event = eventService.getEventDetail(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/events/search")
    public ResponseEntity<List<EventDetailResponse>> searchEvents(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "dateStart", required = false) Timestamp dateStart,
            @RequestParam(value = "dateEnd", required = false) Timestamp dateEnd,
            @RequestParam(value = "status", required = false) EventStatus status,
            @RequestParam(value = "organizerName", required = false) String organizerName) {
        EventSearchRequest searchRequest = new EventSearchRequest();
        searchRequest.setKeyword(keyword);
        searchRequest.setDateStart(dateStart);
        searchRequest.setDateEnd(dateEnd);
        searchRequest.setStatus(status);
        searchRequest.setOrganizerName(organizerName);
        List<EventDetailResponse> events = eventService.searchEvents(searchRequest);
        return ResponseEntity.ok(events);
    }
    @GetMapping("/events/suggestions")
    public ResponseEntity<List<String>> getSuggestions(@RequestParam("keyword") String keyword) {
        List<String> suggestions = eventService.getSuggestions(keyword);
        return ResponseEntity.ok(suggestions);
    }

}
