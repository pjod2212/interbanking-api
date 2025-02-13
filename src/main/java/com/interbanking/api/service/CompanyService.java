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
import java.util.Optional;

@Service
public class CompanyService {

    final CompanyRepository companyRepository;
    final TransferRepository transferRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, TransferRepository transferRepository) {
        this.companyRepository = companyRepository;
        this.transferRepository = transferRepository;
    }

    public final CompanyTO createCompany(final CompanyTO companyTO) {
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
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0);
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        final List<Transfer> transfers = transferRepository.findByDateBetween(start, end);

        return transfers.stream()
                .map(transfer -> getCompanyById(transfer.getCompanyId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Company::toDomain)
                .distinct()
                .toList();
    }

    private Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }
}
