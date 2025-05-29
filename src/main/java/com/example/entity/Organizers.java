package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizers {
    private Integer organizer_id;
    private String name;
    private String logo;
    private String description;

    @OneToMany(mappedBy = "organizer")
    private List<Events> events;
    @OneToMany(mappedBy = "event")
    private List<Orders> orders;

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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
