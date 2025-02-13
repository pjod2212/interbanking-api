package com.interbanking.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class TransferTO {
    private BigDecimal amount;
    private Long companyId;
    private String debitAccount;
    private String creditAccount;
    private LocalDateTime date;
}
