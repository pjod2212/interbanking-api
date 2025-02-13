package com.interbanking.api.repository;

import com.interbanking.api.model.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
