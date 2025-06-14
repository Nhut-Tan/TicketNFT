package com.example.TicketChain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketChain.entity.Organizers;
import com.example.TicketChain.repository.OrganizerRepository;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public List<String> getAllOrganizerNames() {
        List<Organizers> organizers = organizerRepository.findAll();
        return organizers.stream()
                .map(Organizers::getName)
                .collect(Collectors.toList());
    }
}