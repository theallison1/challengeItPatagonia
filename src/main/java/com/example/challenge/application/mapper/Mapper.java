package com.example.challenge.application.mapper;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.dto.TransferenciaDTO;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;

public class Mapper {
    private Mapper() {
        throw new IllegalStateException("Utility class");

    }

    // Convierte EmpresaDTO a Empresa (entidad)
    public static Empresa toEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setCuit(empresaDTO.getCuit());
        empresa.setRazonSocial(empresaDTO.getRazonSocial());
        empresa.setFechaAdhesion(empresaDTO.getFechaAdhesion());
        return empresa;
    }

    // Convierte TransferenciaDTO a Transferencia (entidad)
    public static Transferencia toTransferencia(TransferenciaDTO transferenciaDTO, Empresa empresa) {
        Transferencia transferencia = new Transferencia();
        transferencia.setImporte(transferenciaDTO.getImporte());
        transferencia.setCuentaDebito(transferenciaDTO.getCuentaDebito());
        transferencia.setCuentaCredito(transferenciaDTO.getCuentaCredito());
        transferencia.setFechaTransferencia(transferenciaDTO.getFechaTransferencia());
        transferencia.setEmpresa(empresa); // Asocia la empresa
        return transferencia;
    }

    // Convierte Empresa (entidad) a EmpresaDTO
    public static EmpresaDTO toEmpresaDTO(Empresa empresa) {
        return new EmpresaDTO(
                empresa.getCuit(),
                empresa.getRazonSocial(),
                empresa.getFechaAdhesion()
        );
    }

    // Convierte Transferencia (entidad) a TransferenciaDTO
    public static TransferenciaDTO toTransferenciaDTO(Transferencia transferencia) {
        return new TransferenciaDTO(
                transferencia.getImporte(),
                transferencia.getEmpresa().getId(), // Asume que la empresa está asociada
                transferencia.getCuentaDebito(),
                transferencia.getCuentaCredito(),
                transferencia.getFechaTransferencia()
        );
    }
}