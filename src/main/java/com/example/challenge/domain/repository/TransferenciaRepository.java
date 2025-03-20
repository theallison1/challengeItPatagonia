package com.example.challenge.domain.repository;

import com.example.challenge.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository {
    List<Empresa> findEmpresasConTransferenciasEntre(LocalDate start, LocalDate end);
}