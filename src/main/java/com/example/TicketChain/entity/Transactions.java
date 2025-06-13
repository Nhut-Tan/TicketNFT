package com.example.TicketChain.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger trans_id;

    private String tx_hash;
    private String from_address;
    private String to_address;
    //private BigInteger token_id;
    private Timestamp transaction_date;

    // @ManyToOne
    // @JoinColumn(name = "ticket_id")
    // private Tickets ticket;
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Tickets> tickets;

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private TicketListing listing;

    public BigInteger getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(BigInteger trans_id) {
        this.trans_id = trans_id;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public String getFrom_address() {
        return from_address;
    }

    public void setFrom_address(String from_address) {
        this.from_address = from_address;
    }

    public String getTo_address() {
        return to_address;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    // public BigInteger getToken_id() {
    //     return token_id;
    // }

    // public void setToken_id(BigInteger token_id) {
    //     this.token_id = token_id;
    // }

    public Timestamp getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Timestamp transaction_date) {
        this.transaction_date = transaction_date;
    }

    // public Tickets getTicket() {
    // return ticket;
    // }

    // public void setTicket(Tickets ticket) {
    // this.ticket = ticket;
    // }

    public TicketListing getListing() {
        return listing;
    }

    public void setListing(TicketListing listing) {
        this.listing = listing;
    }

    public Timestamp getCreated_at() {
        return transaction_date;
    }
}
