package com.interbanking.api.infrastructure.persistence.repositories;

import com.interbanking.api.domain.model.Company;
import com.interbanking.api.domain.ports.CompanyRepository;
import com.interbanking.api.infrastructure.persistence.entities.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final CompanyJpaRepository jpaRepository;

    @Override
    public Company save(Company company) {
        final CompanyEntity entity = CompanyEntity.builder()
                .adhesionDate(company.getAdhesionDate())
                .cuit(company.getCuit())
                .businessName(company.getBusinessName())
                .build();
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public List<Company> findByAdhesionDateBetween(LocalDateTime start, LocalDateTime end) {
        return jpaRepository.findByAdhesionDateBetween(start, end)
                .stream()
                .map(CompanyEntity::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCuit(String cuit) {
        return jpaRepository.existsByCuit(cuit);
    }

    @Override
    public Optional<Company> findById(Long companyId) {
        return jpaRepository.findById(companyId)
                .map(CompanyEntity::toDomain);
    }
}
