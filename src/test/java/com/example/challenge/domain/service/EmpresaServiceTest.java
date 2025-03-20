package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaServiceImpl empresaService;

    @Test
    public void testFindEmpresasAdheridasEntre() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        Empresa empresa = new Empresa();
        empresa.setFechaAdhesion(now);

        when(empresaRepository.findByFechaAdhesionBetween(lastMonth, now)).thenReturn(Collections.singletonList(empresa));

        List<Empresa> empresas = empresaService.findEmpresasAdheridasEntre(lastMonth, now);
        assertEquals(1, empresas.size());
    }
}