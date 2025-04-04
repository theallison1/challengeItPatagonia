package com.example.challenge.adapter.out.mapper;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.dto.TransferenciaDTO;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;

public class Mapper {
    private Mapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Empresa toEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setCuit(empresaDTO.cuit());
        empresa.setRazonSocial(empresaDTO.razonSocial());
        empresa.setFechaAdhesion(empresaDTO.fechaAdhesion());
        return empresa;
    }

    public static Transferencia toTransferencia(TransferenciaDTO transferenciaDTO, Empresa empresa) {
        Transferencia transferencia = new Transferencia();
        transferencia.setImporte(transferenciaDTO.importe());
        transferencia.setCuentaDebito(transferenciaDTO.cuentaDebito());
        transferencia.setCuentaCredito(transferenciaDTO.cuentaCredito());
        transferencia.setFechaTransferencia(transferenciaDTO.fechaTransferencia());
        transferencia.setEmpresa(empresa);
        return transferencia;
    }

    public static EmpresaDTO toEmpresaDTO(Empresa empresa) {
        return new EmpresaDTO(
                empresa.getCuit(),
                empresa.getRazonSocial(),
                empresa.getFechaAdhesion()
        );
    }

    public static TransferenciaDTO toTransferenciaDTO(Transferencia transferencia) {
        return new TransferenciaDTO(
                transferencia.getImporte(),
                transferencia.getEmpresa().getId(),
                transferencia.getCuentaDebito(),
                transferencia.getCuentaCredito(),
                transferencia.getFechaTransferencia()
        );
    }
}

