package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public List<Empresa> findEmpresasConTransferenciasEntre(LocalDate start, LocalDate end) {
        // Delegar la consulta al repositorio
        return transferenciaRepository.findEmpresasConTransferenciasEntre(start, end);
    }
}