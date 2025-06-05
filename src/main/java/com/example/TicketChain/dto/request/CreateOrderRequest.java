package com.example.TicketChain.dto.request;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CreateOrderRequest {
    private String walletId;
    private BigInteger eventId;
    private BigDecimal totalPrice;
    private Boolean isResale;
    private List<OrderTicketDTO> tickets;
    private TransactionDTO transaction;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public BigInteger getEventId() {
        return eventId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIsResale() {
        return isResale;
    }

    public void setIsResale(Boolean isResale) {
        this.isResale = isResale;
    }

    public List<OrderTicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<OrderTicketDTO> tickets) {
        this.tickets = tickets;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
    }

}
