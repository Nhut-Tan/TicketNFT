package com.example.TicketChain.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketChain.config.JwtUtil;
import com.example.TicketChain.dto.request.ConnectWalletRequest;
import com.example.TicketChain.dto.response.WalletResponse;
import com.example.TicketChain.entity.Wallet;
import com.example.TicketChain.service.WalletService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class WalletController {
    @Autowired
    private WalletService walletService;

    // @PostMapping("/connect-wallet")
    // public ResponseEntity<?> connectWallet(@RequestBody ConnectWalletRequest
    // request, HttpSession session) {
    // String walletId = request.getWallet_id();

    // if (walletId == null || walletId.isEmpty()) {
    // return ResponseEntity.badRequest().body(Map.of("message", "walletId is
    // required"));
    // }

    // Wallet wallet = walletService.findOrCreateWallet(walletId);

    // session.setAttribute("walletId", walletId);

    // return ResponseEntity.ok(Map.of(
    // "message", "Wallet connected",
    // "wallet_address", wallet.getWalletId(),
    // "sessionId", session.getId()));
    // }
    @PostMapping("/connect-wallet")
    public ResponseEntity<?> connectWallet(@RequestBody ConnectWalletRequest request) {
        try {
            String address = walletService.findOrCreateWallet(request.getWalletId());
            String token = JwtUtil.generateToken(address);
            return ResponseEntity.ok(new WalletResponse(address, token, "Wallet connected successfully"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new WalletResponse(null, null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new WalletResponse(null, null, "An unexpected error occurred"));
        }
    }

}
