package com.example.TicketChain.dto.response;

public class WalletResponse {
    private String address;
    private String token;
    private String message;

    public WalletResponse(String address, String token, String message) {
        this.address = address;
        this.token = token;
        this.message = message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
