package com.example.TicketChain.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizer_id;
    private String name;
    private String logo;
    private String description;

    @OneToMany(mappedBy = "organizer")
    private List<Events> events;

    public Integer getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(Integer organizer_id) {
        this.organizer_id = organizer_id;
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

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

}
