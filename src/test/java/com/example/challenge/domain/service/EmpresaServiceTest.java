package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaServiceImpl empresaService;

    @Test
    public void testFindEmpresasAdheridasEntre() {
        // Configurar datos de prueba
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        Empresa empresa = new Empresa();
        empresa.setId(1L); // Asignar un ID
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Empresa de Prueba");
        empresa.setFechaAdhesion(now);

        // Configurar el mock
        when(empresaRepository.findByFechaAdhesionBetween(lastMonth, now))
                .thenReturn(Collections.singletonList(empresa));

        // Llamar al método del servicio
        List<Empresa> empresas = empresaService.findEmpresasAdheridasEntre(lastMonth, now);

        // Depuración: Imprimir el resultado
        System.out.println("Empresas encontradas: " + empresas.size());

        // Verificar que el servicio devuelve el valor esperado
        assertEquals(1, empresas.size());
        assertEquals("30-12345678-9", empresas.get(0).getCuit());

        // Verificar que el método del repositorio se llamó correctamente
        verify(empresaRepository).findByFechaAdhesionBetween(lastMonth, now);
    }
}