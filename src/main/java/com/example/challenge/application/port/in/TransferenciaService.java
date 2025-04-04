package com.example.challenge.application.port.in;


import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.dto.TransferenciaDTO;
import com.example.challenge.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaService {

    List<Empresa> findEmpresasConTransferenciasEntre(LocalDate start, LocalDate end);
    List<Empresa> obtenerEmpresasConTransferenciasEnElUltimoMes();
    TransferenciaDTO guardarTransferencia(TransferenciaDTO transferenciaDTO);
    List<EmpresaDTO> getEmpresasConTransferenciasEnUltimoMes();
}