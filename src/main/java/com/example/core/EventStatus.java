package com.example.core;

public enum EventStatus {
    UPCOMING("upcoming"), // Sắp diễn ra
    COMPLETED("completed"), // Đã kết thúc
    CANCELLED("cancelled"); // Đã huỷ

    private final String value;

    EventStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static EventStatus fromString(String value) {
        for (EventStatus eventStatus : EventStatus.values()) {
            if (eventStatus.value.equalsIgnoreCase(value)) {
                return eventStatus;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}