package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.TransferenciaRepository;
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
public class TransferenciaServiceTest {

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaServiceImpl transferenciaService;

    @Test
    public void testFindEmpresasConTransferenciasEntre() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        Empresa empresa = new Empresa();

        when(transferenciaRepository.findEmpresasConTransferenciasEntre(lastMonth, now)).thenReturn(Collections.singletonList(empresa));

        List<Empresa> empresas = transferenciaService.findEmpresasConTransferenciasEntre(lastMonth, now);
        assertEquals(1, empresas.size());
    }
}