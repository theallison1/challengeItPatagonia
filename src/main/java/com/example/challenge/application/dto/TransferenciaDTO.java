package com.example.challenge.application.dto;

import java.time.LocalDate;

public record TransferenciaDTO(
        Double importe,
        Long idEmpresa,
        String cuentaDebito,
        String cuentaCredito,
        LocalDate fechaTransferencia
) {

}