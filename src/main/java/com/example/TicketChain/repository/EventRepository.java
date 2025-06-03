package com.example.TicketChain.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.dto.response.EventDetailResponse;
import com.example.TicketChain.entity.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, BigInteger> {
    // @Query("""
    // SELECT new com.example.TicketChain.dto.response.EventDetailResponse(
    // e.eventId, e.eventName, e.location, e.description, e.imageUrl, e.dateStart,
    // e.dateEnd, o.name, o.logo)
    // FROM Events e JOIN e.organizer o
    // WHERE e.eventId = :eventId
    // """)
    // EventDetailResponse findEventDetailById(@Param("eventId") BigInteger
    // eventId);
    @Query("""
            SELECT new com.example.TicketChain.dto.response.EventDetailResponse(e.eventId, e.eventName, e.location, e.description,e.imageUrl, e.dateStart, e.dateEnd, o.name, o.logo)
            FROM Events e JOIN e.organizer o
            WHERE e.eventId = :eventId
            """)
    EventDetailResponse findSimpleEventDetailById(@Param("eventId") BigInteger eventId);

}
