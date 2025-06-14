package com.example.TicketChain.dto.response;

import java.math.BigInteger;
import java.sql.Timestamp;
import com.example.TicketChain.core.EventStatus; // Thêm import này

public class EventDetailResponse {
    private BigInteger eventId;
    private String eventName;
    private String location;
    private String description;
    private String imageUrl;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private String organizerName;
    private String logo;
    private EventStatus status; // Thêm trường status

    // Cập nhật constructor
    public EventDetailResponse(BigInteger eventId, String eventName, String location, String description,
                               String imageUrl, Timestamp dateStart, Timestamp dateEnd, String organizerName, String logo, EventStatus status) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.organizerName = organizerName;
        this.logo = logo;
        this.status = status; // Thêm status vào constructor
    }

    // Getter và Setter cho status
    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    // Các getter/setter khác giữ nguyên
    public BigInteger getEventId() {
        return eventId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}