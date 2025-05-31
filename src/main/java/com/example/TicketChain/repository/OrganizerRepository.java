package com.example.TicketChain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.entity.Organizers;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizers, Integer> {

}
