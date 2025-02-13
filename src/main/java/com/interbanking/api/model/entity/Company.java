package com.interbanking.api.model.entity;

import com.interbanking.api.model.dto.CompanyTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cuit;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private LocalDateTime adhesionDate;

    public CompanyTO toDomain() {
        return new CompanyTO(cuit, businessName, adhesionDate);
    }
}
