package com.example.TicketChain.dto.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class TicketTypeResponse {
    private BigInteger ticketTypeId;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private Integer remainingAmount;
    private String metadataURI;
    private List<String> benefits;

    public TicketTypeResponse(BigInteger ticketTypeId, String name, BigDecimal price,
            Integer amount, Integer remainingAmount,
            String metadataURI, List<String> benefits) {
        this.ticketTypeId = ticketTypeId;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.metadataURI = metadataURI;
        this.benefits = benefits;
    }

    public BigInteger getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(BigInteger ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
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

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
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

}
