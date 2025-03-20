package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

public interface EmpresaService {
    Empresa adherirEmpresa(Empresa empresa);
    List<Empresa> findEmpresasAdheridasEntre(LocalDate start, LocalDate end);
}