package com.interbanking.api.infrastructure.persistence.repositories;

import com.interbanking.api.domain.model.Transfer;
import com.interbanking.api.domain.ports.TransferRepository;
import com.interbanking.api.infrastructure.persistence.entities.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransferRepositroryImpl implements TransferRepository {

        private final TransferJpaRepository jpaRepository;

        @Override
        public List<Transfer> findByDateBetween(LocalDateTime start, LocalDateTime end) {
            return jpaRepository.findByDateBetween(start, end)
                    .stream()
                    .map(this::toDomain)
                    .toList();
        }

        private Transfer toDomain(TransferEntity entity) {
            return Transfer.builder()
                    .amount(entity.getAmount())
                    .companyId(entity.getCompanyId())
                    .creditAccount(entity.getCreditAccount())
                    .debitAccount(entity.getDebitAccount())
                    .date(entity.getDate()).build();
        }
}
