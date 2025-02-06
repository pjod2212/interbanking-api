package com.interbanking.api.infrastructure.persistence.repositories;

import com.interbanking.api.infrastructure.persistence.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
    List<CompanyEntity> findByAdhesionDateBetween(LocalDateTime start, LocalDateTime end);
    boolean existsByCuit(String cuit);
}
