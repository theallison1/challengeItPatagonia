package com.example.challenge.domain.repository;

import com.example.challenge.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByFechaAdhesionBetween(LocalDate start, LocalDate end);
    @Query("SELECT DISTINCT e FROM Empresa e " +
            "JOIN e.transferencias t " +
            "WHERE t.fechaTransferencia BETWEEN :fechaInicio AND :fechaFin")
            List<Empresa> findEmpresasConTransferenciasEnUltimoMes(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin
    );
}