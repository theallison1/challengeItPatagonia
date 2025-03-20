package com.example.challenge.infrastructure.persistence;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.TransferenciaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaTransferenciaRepository extends JpaRepository<Empresa, Long>, TransferenciaRepository {

    @Query("SELECT DISTINCT t.empresa FROM Transferencia t WHERE t.fechaTransferencia BETWEEN :start AND :end")
    List<Empresa> findEmpresasConTransferenciasEntre(@Param("start") LocalDate start, @Param("end") LocalDate end);
}