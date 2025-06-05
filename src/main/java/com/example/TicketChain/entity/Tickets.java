package com.example.TicketChain.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.example.TicketChain.core.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger ticket_id;
    private String owner_address;

    @Column(unique = true)
    private BigInteger token_id;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private Boolean is_listing = false;

    private Timestamp created_at;
    @ManyToOne
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @OneToMany(mappedBy = "ticket")
    private List<TicketListing> listings;

    @OneToMany(mappedBy = "ticket")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "trans_id")
    private Transactions transaction;

    // @OneToMany(mappedBy = "ticket")
    // private List<Transactions> transactions;

    public BigInteger getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(BigInteger ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getOwner_address() {
        return owner_address;
    }

    public void setOwner_address(String owner_address) {
        this.owner_address = owner_address;
    }

    public BigInteger getToken_id() {
        return token_id;
    }

    public void setToken_id(BigInteger token_id) {
        this.token_id = token_id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Boolean getIs_listing() {
        return is_listing;
    }

    public void setIs_listing(Boolean is_listing) {
        this.is_listing = is_listing;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public List<TicketListing> getListings() {
        return listings;
    }

    public void setListings(List<TicketListing> listings) {
        this.listings = listings;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    // public List<Transactions> getTransactions() {
    // return transactions;
    // }

    // public void setTransactions(List<Transactions> transactions) {
    // this.transactions = transactions;
    // }

}
