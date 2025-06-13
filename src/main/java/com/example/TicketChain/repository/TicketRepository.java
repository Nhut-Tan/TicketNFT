package com.example.TicketChain.repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TicketChain.entity.Tickets;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, BigInteger> {
    Optional<Tickets> findByTokenId(BigInteger tokenId);

    @Query("SELECT t FROM Tickets t WHERE t.owner_address = :ownerAddress")
    List<Tickets> findByOwner_address(@Param("ownerAddress") String ownerAddress);
}
