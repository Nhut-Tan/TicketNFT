package com.example.entity;

import java.math.BigDecimal;
import java.util.List;

import com.example.core.TicketListingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_listing")
public class TicketListing {
    @Id
    private Long listing_id;
    private String seller_address;
    private BigDecimal price;
    private TicketListingStatus status;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

    @OneToMany(mappedBy = "listing")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "listing")
    private List<Transactions> transactions;

    public Long getListing_id() {
        return listing_id;
    }

    public void setListing_id(Long listing_id) {
        this.listing_id = listing_id;
    }

    public String getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(String seller_address) {
        this.seller_address = seller_address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TicketListingStatus getStatus() {
        return status;
    }

    public void setStatus(TicketListingStatus status) {
        this.status = status;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

}
