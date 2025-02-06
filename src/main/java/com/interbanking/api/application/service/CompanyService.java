package com.interbanking.api.application.service;

import com.interbanking.api.domain.model.Company;
import com.interbanking.api.domain.model.Transfer;
import com.interbanking.api.domain.ports.CompanyRepository;
import com.interbanking.api.domain.ports.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final TransferRepository transferRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, TransferRepository transferRepository) {
        this.companyRepository = companyRepository;
        this.transferRepository = transferRepository;
    }

    public Company createCompany(Company company) {
        if(companyRepository.existsByCuit(company.getCuit())) {
            throw new IllegalArgumentException("CUIT already exists");
        }
        return companyRepository.save(company);
    }

    public List<Company> getCompaniesAdheredLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0);
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);
        return companyRepository.findByAdhesionDateBetween(start, end);
    }

    public List<Company> getCompaniesWithTransfersLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0);
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        List<Transfer> transfers = transferRepository.findByDateBetween(start, end);
        return transfers.stream()
                .map(transfer -> companyRepository.findById(transfer.getCompanyId()).get())
                .distinct()
                .toList();
    }
}
