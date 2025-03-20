package com.example.challenge.infrastructure.web;

import com.example.challenge.application.service.TransferenciaApplicationService;
import com.example.challenge.domain.model.Empresa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaApplicationService transferenciaApplicationService;

    public TransferenciaController(TransferenciaApplicationService transferenciaApplicationService) {
        this.transferenciaApplicationService = transferenciaApplicationService;
    }

    @GetMapping("/empresas-ultimo-mes")
    public List<Empresa> getEmpresasConTransferenciasUltimoMes() {
        return transferenciaApplicationService.getEmpresasConTransferenciasUltimoMes();
    }
}