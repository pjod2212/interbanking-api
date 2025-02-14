package com.interbanking.api.service;

import com.interbanking.api.model.dto.CompanyTO;
import com.interbanking.api.model.dto.TransferTO;
import com.interbanking.api.model.entity.Company;
import com.interbanking.api.model.entity.Transfer;
import com.interbanking.api.repository.CompanyRepository;
import com.interbanking.api.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CompanyService {

    final CompanyRepository companyRepository;
    final TransferRepository transferRepository;

    @Autowired
    public CompanyService(final CompanyRepository companyRepository,final TransferRepository transferRepository) {
        this.companyRepository = companyRepository;
        this.transferRepository = transferRepository;
    }

    public CompanyTO createCompany(final CompanyTO companyTO) {
        if(companyRepository.existsByCuit(companyTO.getCuit())) {
            throw new IllegalArgumentException("CUIT already exists");
        }
        return companyRepository.save(Company.builder()
                .adhesionDate(companyTO.getAdhesionDate())
                .cuit(companyTO.getCuit())
                .businessName(companyTO.getBusinessName())
                .build()).toDomain();
    }

    public List<CompanyTO> getCompaniesAdheredLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0);
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        return companyRepository.findByAdhesionDateBetween(start, end).stream().map(Company::toDomain).toList();
    }

    public List<CompanyTO> getCompaniesWithTransfersLastMonth() {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime start = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0);
        final LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        final List<Transfer> transfers = transferRepository.findByDateBetween(start, end);

        return transfers.stream().map(transfer -> transfer.getCompany().toDomain()).distinct().toList();
    }

}
