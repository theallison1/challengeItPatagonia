package com.example.challenge.application.service;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpresaApplicationService {

    private final EmpresaService empresaService;

    public EmpresaApplicationService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public EmpresaDTO adherirEmpresa(EmpresaDTO empresaDTO) {
        // Convertir DTO a entidad de dominio
        Empresa empresa = new Empresa();
        empresa.setCuit(empresaDTO.getCuit());
        empresa.setRazonSocial(empresaDTO.getRazonSocial());
        empresa.setFechaAdhesion(LocalDate.now()); // Fecha de adhesión automática

        // Llamar al servicio de dominio
        Empresa empresaAdherida = empresaService.adherirEmpresa(empresa);

        // Convertir entidad a DTO
        EmpresaDTO responseDTO = new EmpresaDTO();
        responseDTO.setCuit(empresaAdherida.getCuit());
        responseDTO.setRazonSocial(empresaAdherida.getRazonSocial());
        responseDTO.setFechaAdhesion(empresaAdherida.getFechaAdhesion());

        return responseDTO;
    }

    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        return empresaService.findEmpresasAdheridasEntre(lastMonth, now);
    }
}