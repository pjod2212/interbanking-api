package com.interbanking.api.infrastructure.controllers;

import com.interbanking.api.application.service.CompanyService;
import com.interbanking.api.domain.model.Company;
import com.interbanking.api.infrastructure.controllers.dto.CompanyRequest;
import com.interbanking.api.infrastructure.controllers.dto.CompanyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse createCompany(@Valid @RequestBody CompanyRequest request) {
        Company company = companyService.createCompany(request.toDomain());
        return CompanyResponse.fromDomain(company);
    }

    @GetMapping("/adhered-last-month")
    public List<CompanyResponse> getAdheredLastMonth() {
        return companyService.getCompaniesAdheredLastMonth()
                .stream()
                .map(CompanyResponse::fromDomain)
                .toList();
    }

    @GetMapping("/with-transfers-last-month")
    public List<CompanyResponse> getWithTransfersLastMonth() {
        return companyService.getCompaniesWithTransfersLastMonth()
                .stream()
                .map(CompanyResponse::fromDomain)
                .toList();
    }
}
