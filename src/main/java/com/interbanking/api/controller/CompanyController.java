package com.interbanking.api.controller;

import com.interbanking.api.service.CompanyService;
import com.interbanking.api.model.dto.CompanyTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyTO createCompany(@Valid @RequestBody CompanyTO request) {
        return companyService.createCompany(request);
    }

    @GetMapping("/adhered-last-month")
    public List<CompanyTO> getAdheredLastMonth() {
        return companyService.getCompaniesAdheredLastMonth();
    }

    @GetMapping("/with-transfers-last-month")
    public List<CompanyTO> getWithTransfersLastMonth() {
        return companyService.getCompaniesWithTransfersLastMonth();
    }

}