package com.example.TicketChain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.entity.TicketListing;

@Repository
public interface TicketListingRepository extends JpaRepository<TicketListing, Long> {

}
