package com.example.TicketChain.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketChain.core.Role;
import com.example.TicketChain.entity.Wallet;
import com.example.TicketChain.repository.WalletRepository;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    // public Wallet findOrCreateWallet(String walletId) {
    // Optional<Wallet> existingWallet = walletRepository.findByWalletId(walletId);
    // if (existingWallet.isPresent()) {
    // return existingWallet.get(); // Trả về ví đã tồn tại
    // }
    // Wallet newWallet = new Wallet();
    // newWallet.setWalletId(walletId);
    // newWallet.setRole(Role.CUSTOMER);
    // newWallet.setCreated_at(new Timestamp(System.currentTimeMillis()));
    // return walletRepository.save(newWallet);
    // }
    public String findOrCreateWallet(String address) throws IllegalArgumentException {

        // Kiểm tra và lưu ví
        Optional<Wallet> existingWallet = walletRepository.findByWalletId(address);
        if (existingWallet.isEmpty()) {
            Wallet newWallet = new Wallet();
            newWallet.setWalletId(address);
            newWallet.setRole(Role.CUSTOMER);
            newWallet.setCreated_at(new Timestamp(System.currentTimeMillis()));
            walletRepository.save(newWallet);
        }

        return address;
    }
}
