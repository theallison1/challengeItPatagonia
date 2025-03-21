package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
@Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa adherirEmpresa(Empresa empresa) {
        // Asignar la fecha de adhesión actual si no está definida
        if (empresa.getFechaAdhesion() == null) {
            empresa.setFechaAdhesion(LocalDate.now());
        }

        // Guardar la empresa en la base de datos utilizando el repositorio
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> findEmpresasAdheridasEntre(LocalDate start, LocalDate end) {
        // Llama al método del repositorio para obtener las empresas en el rango de fechas
        return empresaRepository.findByFechaAdhesionBetween(start, end);
    }
}