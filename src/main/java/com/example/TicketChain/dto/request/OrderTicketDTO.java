package com.example.TicketChain.dto.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderTicketDTO {
    private BigDecimal price;
    private BigInteger tokenId;
    private BigInteger ticketTypeId;

    public BigInteger getTokenId() {
        return tokenId;
    }

    public void setTokenId(BigInteger tokenId) {
        this.tokenId = tokenId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(BigInteger ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

}
