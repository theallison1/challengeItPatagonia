package com.example.challenge.domain.service;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.dto.TransferenciaDTO;
import com.example.challenge.application.mapper.Mapper;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;
import com.example.challenge.domain.repository.EmpresaRepository;
import com.example.challenge.domain.repository.TransferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaServiceImpl {

    private final TransferenciaRepository transferenciaRepository;
    private final  EmpresaRepository empresaRepository;
@Autowired
    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository, EmpresaRepository empresaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.empresaRepository = empresaRepository;
    }


    public List<Empresa> findEmpresasConTransferenciasEntre(LocalDate start, LocalDate end) {
        // Delegar la consulta al repositorio
        return transferenciaRepository.findEmpresasConTransferenciasEntre(start, end);
    }


    public List<Empresa> obtenerEmpresasConTransferenciasEnElUltimoMes() {
        LocalDate start = LocalDate.now().minusMonths(1).withDayOfMonth(1); // Primer día del último mes
        LocalDate end = LocalDate.now().withDayOfMonth(1).minusDays(1); // Último día del último mes
        return transferenciaRepository.findEmpresasConTransferenciasEnElUltimoMes(start, end);
    }
    @Transactional
    public TransferenciaDTO guardarTransferencia(TransferenciaDTO transferenciaDTO) {
        // Busca la empresa asociada
        Empresa empresa = empresaRepository.findById(transferenciaDTO.idEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        // Convierte el DTO a entidad
        Transferencia transferencia = Mapper.toTransferencia(transferenciaDTO, empresa);

        // Guarda la transferencia
        Transferencia transferenciaGuardada = transferenciaRepository.save(transferencia);

        // Convierte la entidad guardada a DTO y la retorna
        return Mapper.toTransferenciaDTO(transferenciaGuardada);
    }

    public List<EmpresaDTO> getEmpresasConTransferenciasEnUltimoMes() {
        // Calcula las fechas para el último mes
        LocalDate fechaFin = LocalDate.now();
        LocalDate fechaInicio = fechaFin.minusMonths(1);

        // Busca las empresas que hicieron transferencias en el último mes
        List<Empresa> empresas = empresaRepository.findEmpresasConTransferenciasEnUltimoMes(fechaInicio, fechaFin);

        // Convierte las entidades a DTOs
        return empresas.stream()
                .map(Mapper::toEmpresaDTO)
                .toList();
    }
}