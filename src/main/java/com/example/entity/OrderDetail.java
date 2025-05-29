package com.example.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderdetail_id;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private TicketListing listing;

    public Long getOrderdetail_id() {
        return orderdetail_id;
    }

    public void setOrderdetail_id(Long orderdetail_id) {
        this.orderdetail_id = orderdetail_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public TicketListing getListing() {
        return listing;
    }

    public void setListing(TicketListing listing) {
        this.listing = listing;
    }

}
