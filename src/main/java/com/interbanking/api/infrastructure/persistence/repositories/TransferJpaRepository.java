package com.interbanking.api.infrastructure.persistence.repositories;

import com.interbanking.api.infrastructure.persistence.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferJpaRepository extends JpaRepository<TransferEntity, Long> {
    List<TransferEntity> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
