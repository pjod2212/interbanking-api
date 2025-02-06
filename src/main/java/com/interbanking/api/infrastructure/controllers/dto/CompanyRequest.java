package com.interbanking.api.infrastructure.controllers.dto;

import com.interbanking.api.domain.model.Company;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CompanyRequest(
        @NotBlank String cuit,
        @NotBlank String businessName) {

    public Company toDomain() {
        return new Company(cuit, businessName, LocalDateTime.now());
    }
}
