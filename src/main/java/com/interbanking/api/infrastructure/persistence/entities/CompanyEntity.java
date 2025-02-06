package com.interbanking.api.infrastructure.persistence.entities;

import com.interbanking.api.domain.model.Company;
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
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cuit;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private LocalDateTime adhesionDate;

    public Company toDomain() {
        return new Company(cuit, businessName, adhesionDate);
    }
}
