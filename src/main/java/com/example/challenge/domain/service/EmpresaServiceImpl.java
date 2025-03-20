package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa adherirEmpresa(Empresa empresa) {
        // Lógica de negocio (si es necesaria)
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> findEmpresasAdheridasEntre(LocalDate start, LocalDate end) {
        return List.of();
    }
}