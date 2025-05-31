package com.example.TicketChain.core;

public enum TicketStatus {
    OWNED("owned"),        // Đang thuộc sở hữu người dùng
    USED("used"),         // Đã sử dụng
    BURN("burn");   // Đã huỷ
    private final String value;

    TicketStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static TicketStatus fromString(String value) {
        for (TicketStatus ticketStatus : TicketStatus.values()) {
            if (ticketStatus.value.equalsIgnoreCase(value)) {
                return ticketStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
