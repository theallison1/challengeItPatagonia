package com.example.challenge.application.dto;

import java.time.LocalDate;

public record EmpresaDTO(
        String cuit,
        String razonSocial,
        LocalDate fechaAdhesion
) {

}