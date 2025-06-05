package com.example.TicketChain.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.TicketChain.repository.EventRepository;

@Component
public class EventStatusScheduler {
    @Autowired
    private EventRepository eventRepository;

    @Scheduled(fixedRate = 300000)
    public void updateEventStatus() {
        LocalDateTime now = LocalDateTime.now();
        eventRepository.updateStatusToEnded(now);
    }
}
