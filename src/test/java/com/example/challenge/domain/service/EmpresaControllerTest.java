package com.example.challenge.domain.service;


import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.service.EmpresaApplicationService;
import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;
import com.example.challenge.infrastructure.web.EmpresaController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTest {

    @Mock
    private EmpresaApplicationService empresaApplicationService;

    @InjectMocks
    private EmpresaController empresaController;

    private final LocalDate today = LocalDate.now();

    @Test
    void adherirEmpresa_shouldReturnCreatedEmpresa() {
        // Arrange
        EmpresaDTO requestDTO = new EmpresaDTO("30-12345678-9", "Mi Empresa SA", today);
        EmpresaDTO responseDTO = new EmpresaDTO("30-12345678-9", "Mi Empresa SA", today);

        when(empresaApplicationService.adherirEmpresa(requestDTO)).thenReturn(responseDTO);

        // Act
        EmpresaDTO result = empresaController.adherirEmpresa(requestDTO);

        // Assert
        assertNotNull(result);
        assertEquals("30-12345678-9", result.cuit());
        assertEquals("Mi Empresa SA", result.razonSocial());
        assertEquals(today, result.fechaAdhesion());
        verify(empresaApplicationService, times(1)).adherirEmpresa(requestDTO);
    }

    @Test
    void getEmpresasAdheridasUltimoMes_shouldReturnList() {
        // Arrange
        Empresa empresa1 = new Empresa(1L, "30-11111111-1", "Empresa A", today.minusDays(10), null);
        Empresa empresa2 = new Empresa(2L, "30-22222222-2", "Empresa B", today.minusDays(5), null);

        Transferencia transferencia1 = new Transferencia("CUENTA-001", 1L, 1000.0, "CUENTA-002", today.minusDays(5), empresa1);
        Transferencia transferencia2 = new Transferencia("CUENTA-003", 2L, 2000.0, "CUENTA-004", today.minusDays(3), empresa2);

        empresa1.setTransferencias(List.of(transferencia1));
        empresa2.setTransferencias(List.of(transferencia2));

        List<Empresa> expectedList = Arrays.asList(empresa1, empresa2);

        when(empresaApplicationService.getEmpresasAdheridasUltimoMes()).thenReturn(expectedList);

        // Act
        List<Empresa> result = empresaController.getEmpresasAdheridasUltimoMes();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Empresa A", result.get(0).getRazonSocial());
        assertEquals(1, result.get(0).getTransferencias().size());
        assertEquals("30-22222222-2", result.get(1).getCuit());
        assertEquals(2000.0, result.get(1).getTransferencias().get(0).getImporte());
        assertEquals("CUENTA-003", result.get(1).getTransferencias().get(0).getCuentaDebito());
        verify(empresaApplicationService, times(1)).getEmpresasAdheridasUltimoMes();
    }

    @Test
    void adherirEmpresa_shouldHandleNullInput() {
        // Arrange
        when(empresaApplicationService.adherirEmpresa(null)).thenThrow(new IllegalArgumentException());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            empresaController.adherirEmpresa(null);
        });
    }

    @Test
    void getEmpresasAdheridasUltimoMes_shouldReturnEmptyList() {
        // Arrange
        when(empresaApplicationService.getEmpresasAdheridasUltimoMes()).thenReturn(Collections.emptyList());

        // Act
        List<Empresa> result = empresaController.getEmpresasAdheridasUltimoMes();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getEmpresasAdheridasUltimoMes_shouldHandleEmptyTransferencias() {
        // Arrange
        Empresa empresa = new Empresa(1L, "30-11111111-1", "Empresa A", today.minusDays(10),
                Collections.emptyList());

        when(empresaApplicationService.getEmpresasAdheridasUltimoMes()).thenReturn(List.of(empresa));

        // Act
        List<Empresa> result = empresaController.getEmpresasAdheridasUltimoMes();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getTransferencias().isEmpty());
    }
}