package com.example.TicketChain.dto.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TicketTypeDTO {
    private String name;
    private BigDecimal price;
    private BigInteger amount;
    private String metadataURI;

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

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getMetadataURI() {
        return metadataURI;
    }

    public void setMetadataURI(String metadataURI) {
        this.metadataURI = metadataURI;
    }

}
