package com.example.TicketChain.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.example.TicketChain.core.StringListConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    private BigInteger ticket_type_id;

    private String name;
    private BigDecimal price;
    private Integer amount;
    private Integer remaining_amount;
    private String metadataURI;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "json")
    private List<String> benefits;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;

    @OneToMany(mappedBy = "ticketType")
    private List<Tickets> tickets;

    public BigInteger getTicket_type_id() {
        return ticket_type_id;
    }

    public void setTicket_type_id(BigInteger ticket_type_id) {
        this.ticket_type_id = ticket_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRemaining_amount() {
        return remaining_amount;
    }

    public void setRemaining_amount(Integer remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    public String getMetadataURI() {
        return metadataURI;
    }

    public void setMetadataURI(String metadataURI) {
        this.metadataURI = metadataURI;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

}
