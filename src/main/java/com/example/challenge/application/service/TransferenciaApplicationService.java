package com.example.challenge.application.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.service.TransferenciaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaApplicationService {

    private final TransferenciaService transferenciaService;

    public TransferenciaApplicationService(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    public List<Empresa> getEmpresasConTransferenciasUltimoMes() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        return transferenciaService.findEmpresasConTransferenciasEntre(lastMonth, now);
    }
}