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
    public Wallet findOrCreateWallet(String address) throws IllegalArgumentException {
        Optional<Wallet> existingWallet = walletRepository.findByWalletId(address);
        if (existingWallet.isEmpty()) {
            Wallet newWallet = new Wallet();
            newWallet.setWalletId(address);
            newWallet.setRole(Role.CUSTOMER);
            newWallet.setCreated_at(new Timestamp(System.currentTimeMillis()));
            return walletRepository.save(newWallet);
        }
        return existingWallet.get();
    }

}
