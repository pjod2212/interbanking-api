package com.interbanking.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CompanyTO {

    @NotBlank
    private String cuit;

    @NotBlank
    private String businessName;

    private LocalDateTime adhesionDate;
}
