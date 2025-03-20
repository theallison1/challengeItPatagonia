package com.example.challenge.infrastructure.persistence;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.EmpresaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepository {
}