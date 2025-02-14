package com.interbanking.api.controller;

import com.interbanking.api.service.CompanyService;
import com.interbanking.api.model.dto.CompanyTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @Operation(
            summary = "Crear una nueva compañía",
            description = "Este endpoint permite crear una nueva compañía, proporcionando los detalles de la misma."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Compañía creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, datos de entrada inválidos")
    })
    public ResponseEntity<CompanyTO> createCompany(@Valid @RequestBody final CompanyTO request) {
        final CompanyTO createdCompany = companyService.createCompany(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    @GetMapping("/adhered/last-month")
    @Operation(
            summary = "Obtener compañías adheridas el mes pasado",
            description = "Este endpoint devuelve una lista de las compañías que se han adherido el mes pasado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de compañías adheridas el mes pasado obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<CompanyTO>> getAdheredLastMonth() {
        return ResponseEntity.ok(companyService.getCompaniesAdheredLastMonth());
    }

    @GetMapping("/transfers/last-month")
    @Operation(
            summary = "Obtener compañías con transferencias el mes pasado",
            description = "Este endpoint devuelve una lista de compañías que han tenido transferencias el mes pasado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de compañías con transferencias obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<CompanyTO>> getWithTransfersLastMonth() {
        return ResponseEntity.ok(companyService.getCompaniesWithTransfersLastMonth());
    }

}