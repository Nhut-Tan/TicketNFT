package com.example.TicketChain.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.dto.response.EventDetailResponse;
import com.example.TicketChain.entity.Events;

import jakarta.transaction.Transactional;

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
        EventDetailResponse findEventDetailById(@Param("eventId") BigInteger eventId);

        @Modifying
        @Transactional
        @Query("UPDATE Events e SET e.status = 'COMPLETED' " +
                        "WHERE e.dateEnd <= :now AND e.status NOT IN ('COMPLETED', 'CANCELLED')")
        void updateStatusToEnded(@Param("now") LocalDateTime now);
}
