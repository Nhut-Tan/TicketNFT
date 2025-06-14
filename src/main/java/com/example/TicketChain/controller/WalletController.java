package com.example.TicketChain.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TicketChain.config.JwtUtil;
import com.example.TicketChain.dto.request.ConnectWalletRequest;
import com.example.TicketChain.dto.response.WalletResponse;
import com.example.TicketChain.entity.Wallet;
import com.example.TicketChain.service.WalletService;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/connect-wallet")
    public ResponseEntity<WalletResponse> connectWallet(@RequestBody ConnectWalletRequest request) {
        try {
            Wallet address = walletService.findOrCreateWallet(request.getWalletId());
            String token = JwtUtil.generateToken(address.getWalletId(), address.getRole());
            return ResponseEntity.ok(new WalletResponse(address.getWalletId(), token, address.getRole().name(),
                    "Wallet connected successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new WalletResponse(null, null, null, "Lỗi:" + e.getMessage()));
        }
    }

}
