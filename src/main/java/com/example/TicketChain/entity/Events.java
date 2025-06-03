package com.example.TicketChain.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import com.example.TicketChain.core.EventStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @Column(name = "event_id")
    private BigInteger eventId;
    @Column(name = "event_name")
    private String eventName;
    private String location;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "date_start")
    private Timestamp dateStart;
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonBackReference
    private Organizers organizer;

    public BigInteger getEvent_id() {
        return eventId;
    }

    public void setEvent_id(BigInteger event_id) {
        this.eventId = event_id;
    }

    public String getEvent_name() {
        return eventName;
    }

    public void setEvent_name(String event_name) {
        this.eventName = event_name;
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
        return imageUrl;
    }

    public void setImage_url(String image_url) {
        this.imageUrl = image_url;
    }

    public Timestamp getDate_start() {
        return dateStart;
    }

    public void setDate_start(Timestamp date_start) {
        this.dateStart = date_start;
    }

    public Timestamp getDate_end() {
        return dateEnd;
    }

    public void setDate_end(Timestamp date_end) {
        this.dateEnd = date_end;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

}
