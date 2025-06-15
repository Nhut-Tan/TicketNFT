package com.example.TicketChain.repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import com.example.TicketChain.core.EventStatus;
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
        SELECT new com.example.TicketChain.dto.response.EventDetailResponse(
            e.eventId, e.eventName, e.location, e.description, e.imageUrl, 
            e.dateStart, e.dateEnd, o.name, o.logo, o.description, e.status)
        FROM Events e JOIN e.organizer o
        WHERE e.eventId = :eventId
        """)
        EventDetailResponse findEventDetailById(@Param("eventId") BigInteger eventId);

        @Modifying
        @Transactional
        @Query("UPDATE Events e SET e.status = 'COMPLETED' " +
                "WHERE e.dateEnd <= :now AND e.status NOT IN ('COMPLETED', 'CANCELLED')")
        void updateStatusToEnded(@Param("now") LocalDateTime now);
        @Query("""
        SELECT new com.example.TicketChain.dto.response.EventDetailResponse(
            e.eventId, e.eventName, e.location, e.description, e.imageUrl, 
            e.dateStart, e.dateEnd, o.name, o.logo, o.description, e.status)
        FROM Events e JOIN e.organizer o
        WHERE (:keyword IS NULL OR LOWER(e.eventName) LIKE LOWER(CONCAT('%', :keyword, '%')) 
            OR LOWER(e.description) LIKE LOWER(CONCAT('%', :keyword, '%')) 
            OR LOWER(e.location) LIKE LOWER(CONCAT('%', :keyword, '%')))
        AND (:dateStart IS NULL OR e.dateStart >= :dateStart)
        AND (:dateEnd IS NULL OR e.dateEnd <= :dateEnd)
        AND (:status IS NULL OR e.status = :status)
        AND (:organizerName IS NULL OR LOWER(o.name) LIKE LOWER(CONCAT('%', :organizerName, '%')))
        """)
        List<EventDetailResponse> searchEvents(
                @Param("keyword") String keyword,
                @Param("dateStart") Timestamp dateStart,
                @Param("dateEnd") Timestamp dateEnd,
                @Param("status") EventStatus status,
                @Param("organizerName") String organizerName);

        @Query("""
        SELECT DISTINCT e.eventName
        FROM Events e JOIN e.organizer o
        WHERE LOWER(e.eventName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.location) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(o.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(o.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
        ORDER BY e.eventName
        """)
        List<String> findSuggestions(@Param("keyword") String keyword);
}
