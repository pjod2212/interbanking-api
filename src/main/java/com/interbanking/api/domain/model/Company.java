package com.interbanking.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Company {
    private String cuit;
    private String businessName;
    private LocalDateTime adhesionDate;
}
