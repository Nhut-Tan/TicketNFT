package com.example.TicketChain.dto.response;

import java.util.List;

public class OrganizerResponse {
    private Integer organizerId;
    private String name;
    private String logo;
    private String description;
//    private List<EventResponse> events; // Optional: Include if you want to return events

    // Constructor
    public OrganizerResponse(Integer organizerId, String name, String logo, String description) {
        this.organizerId = organizerId;
        this.name = name;
        this.logo = logo;
        this.description = description;
    }

    // Getters and Setters
    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<EventResponse> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<EventResponse> events) {
//        this.events = events;
//    }
}