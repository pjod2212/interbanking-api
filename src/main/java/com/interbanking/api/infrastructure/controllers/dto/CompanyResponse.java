package com.interbanking.api.infrastructure.controllers.dto;

import com.interbanking.api.domain.model.Company;

import java.time.LocalDateTime;

public record CompanyResponse(String cuit,
                              String businessName,
                              LocalDateTime adhesionDate) {

    public static CompanyResponse fromDomain(Company company) {
        return new CompanyResponse(
                company.getCuit(),
                company.getBusinessName(),
                company.getAdhesionDate()
        );
    }
}