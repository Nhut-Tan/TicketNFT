package com.example.TicketChain.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.entity.Tickets;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, BigInteger> {

}
