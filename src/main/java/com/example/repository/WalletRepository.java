package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

}
