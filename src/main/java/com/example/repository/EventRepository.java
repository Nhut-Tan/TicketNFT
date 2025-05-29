package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {

}
