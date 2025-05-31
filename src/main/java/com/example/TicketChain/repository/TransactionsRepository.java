package com.example.TicketChain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.entity.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}
