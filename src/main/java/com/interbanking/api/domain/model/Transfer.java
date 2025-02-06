package com.interbanking.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Transfer {
    private BigDecimal amount;
    private Long companyId;
    private String debitAccount;
    private String creditAccount;
    private LocalDateTime date;
}
