package com.example.challenge.infrastructure.web;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.service.EmpresaApplicationService;
import com.example.challenge.domain.model.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaApplicationService empresaApplicationService;

    public EmpresaController(EmpresaApplicationService empresaApplicationService) {
        this.empresaApplicationService = empresaApplicationService;
    }

    @PostMapping
    public EmpresaDTO adherirEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaApplicationService.adherirEmpresa(empresaDTO);
    }
    @GetMapping("/adheridas-ultimo-mes")
    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        return empresaApplicationService.getEmpresasAdheridasUltimoMes();
    }
}