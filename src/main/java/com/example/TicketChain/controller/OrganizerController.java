package com.example.TicketChain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TicketChain.dto.response.OrganizerResponse;
import com.example.TicketChain.service.OrganizerService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;
    @GetMapping("/list")
    public ResponseEntity<List<OrganizerResponse>> getAllOrganizers() {
        List<OrganizerResponse> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok(organizers);
    }
    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllOrganizerNames() {
        List<String> organizerNames = organizerService.getAllOrganizerNames();
        return ResponseEntity.ok(organizerNames);
    }
}