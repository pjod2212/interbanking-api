package com.interbanking.api.repository;

import com.interbanking.api.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByAdhesionDateBetween(LocalDateTime start, LocalDateTime end);
    boolean existsByCuit(String cuit);
}
