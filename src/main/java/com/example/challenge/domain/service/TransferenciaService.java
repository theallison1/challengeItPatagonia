package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaService {
    List<Empresa> findEmpresasConTransferenciasEntre(LocalDate start, LocalDate end);
}