package com.interbanking.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CompanyTO {

    @Pattern(regexp = "\\d{2}-\\d{8}-\\d", message = "CUIT debe tener el formato ##-########-#")
    @NotBlank
    private String cuit;

    @NotBlank
    private String businessName;

    private LocalDateTime adhesionDate;
}
