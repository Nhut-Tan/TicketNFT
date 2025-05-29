package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TicketType;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

}
