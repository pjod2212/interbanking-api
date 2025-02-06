package com.interbanking.api.domain.ports;

import com.interbanking.api.domain.model.Transfer;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferRepository {
    List<Transfer> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
