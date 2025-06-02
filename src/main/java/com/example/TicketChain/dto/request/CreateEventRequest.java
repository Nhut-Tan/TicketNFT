package com.example.TicketChain.dto.request;

import java.util.List;

public class CreateEventRequest {
    private OrganizerDTO organizer;
    private EventDTO event;
    private List<TicketTypeDTO> ticketTypes;

    public OrganizerDTO getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerDTO organizer) {
        this.organizer = organizer;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public List<TicketTypeDTO> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketTypeDTO> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

}
