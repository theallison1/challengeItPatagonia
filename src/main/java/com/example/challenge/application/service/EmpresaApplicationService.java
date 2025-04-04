package com.example.challenge.application.service;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.application.port.in.EmpresaService;
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
        empresa.setCuit(empresaDTO.cuit());  // Cambiado de getCuit() a cuit()
        empresa.setRazonSocial(empresaDTO.razonSocial());  // Cambiado de getRazonSocial() a razonSocial()
        empresa.setFechaAdhesion(LocalDate.now()); // Fecha de adhesión automática

        // Llamar al servicio de dominio
        Empresa empresaAdherida = empresaService.adherirEmpresa(empresa);

        // Convertir entidad a DTO (usando constructor del record)
        return new EmpresaDTO(
                empresaAdherida.getCuit(),
                empresaAdherida.getRazonSocial(),
                empresaAdherida.getFechaAdhesion()
        );
    }

    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        return empresaService.findEmpresasAdheridasEntre(lastMonth, now);
    }
}