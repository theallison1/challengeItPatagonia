package com.example.challenge.infrastructure.web;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.service.EmpresaApplicationService;
import com.example.challenge.domain.model.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaApplicationService empresaApplicationService;

    public EmpresaController(EmpresaApplicationService empresaApplicationService) {
        this.empresaApplicationService = empresaApplicationService;
    }

    @Operation(summary = "Adherir una nueva empresa", description = "Registra una nueva empresa en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa adherida correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la empresa no válidos")
    })
    @PostMapping
    public ResponseEntity<?> adherirEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        try {
            EmpresaDTO empresaAdherida = empresaApplicationService.adherirEmpresa(empresaDTO);
            return ResponseEntity.ok(empresaAdherida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener empresas adheridas en el último mes", description = "Devuelve una lista de empresas adheridas en el último mes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de empresas obtenida correctamente")
    })
    @GetMapping("/adheridas-ultimo-mes")
    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        return empresaApplicationService.getEmpresasAdheridasUltimoMes();
    }
}