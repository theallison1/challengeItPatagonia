package com.example.challenge.domain.repository;

import com.example.challenge.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

public interface EmpresaRepository {
    List<Empresa> findByFechaAdhesionBetween(LocalDate start, LocalDate end);
    Empresa save(Empresa empresa);

}