package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.TransferenciaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferenciaServiceImplTest {

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaServiceImpl transferenciaService;

    @Test
    public void testFindEmpresasConTransferenciasEntre() {
        // Datos de prueba
        LocalDate start = LocalDate.now().minusMonths(1);
        LocalDate end = LocalDate.now();
        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Empresa de Prueba");

        // Configurar el mock
        when(transferenciaRepository.findEmpresasConTransferenciasEntre(start, end))
                .thenReturn(Collections.singletonList(empresa));

        // Ejecutar el método a probar
        List<Empresa> empresas = transferenciaService.findEmpresasConTransferenciasEntre(start, end);

        // Verificar el resultado
        assertEquals(1, empresas.size());
        assertEquals("30-12345678-9", empresas.get(0).getCuit());
        assertEquals("Empresa de Prueba", empresas.get(0).getRazonSocial());
    }
}