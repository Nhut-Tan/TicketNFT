package com.example.TicketChain.entity;

import java.sql.Timestamp;

import com.example.TicketChain.core.EventStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
    @Id
    private Long event_id;
    private String event_name;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizers organizer;
    private String location;
    private String description;
    private String image_url;
    private Timestamp date_start;
    private Timestamp date_end;
    private EventStatus status;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Organizers getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizers organizer) {
        this.organizer = organizer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Timestamp getDate_start() {
        return date_start;
    }

    public void setDate_start(Timestamp date_start) {
        this.date_start = date_start;
    }

    public Timestamp getDate_end() {
        return date_end;
    }

    public void setDate_end(Timestamp date_end) {
        this.date_end = date_end;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

}
