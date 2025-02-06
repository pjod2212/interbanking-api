package com.interbanking.api.domain.ports;

import com.interbanking.api.domain.model.Company;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    List<Company> findByAdhesionDateBetween(LocalDateTime start, LocalDateTime end);
    boolean existsByCuit(String cuit);
    Optional<Company> findById(Long companyId);
}
