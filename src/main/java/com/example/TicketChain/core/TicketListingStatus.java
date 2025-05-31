package com.example.TicketChain.core;

public enum TicketListingStatus {
    ACTIVE("active"),       // Đang được rao bán
    SOLD("sold"),         // Đã bán
    CANCELLED("cancelled");    // Đã gỡ hoặc hủy rao bán
    private final String value;

    TicketListingStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static TicketListingStatus fromString(String value) {
        for (TicketListingStatus ticketListingStatus : TicketListingStatus.values()) {
            if (ticketListingStatus.value.equalsIgnoreCase(value)) {
                return ticketListingStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
