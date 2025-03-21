package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;
import com.example.challenge.domain.repository.TransferenciaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TransferenciaRepositoryTest {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Test
    public void testFindEmpresasConTransferenciasEntre() {
        // Configurar datos de prueba
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Empresa de Prueba");

        Transferencia transferencia = new Transferencia();
        transferencia.setImporte(1000.0);
        transferencia.setCuentaDebito("Cuenta1");
        transferencia.setCuentaCredito("Cuenta2");
        transferencia.setFechaTransferencia(now);
        transferencia.setEmpresa(empresa);

        transferenciaRepository.save(transferencia);

        // Llamar al método del repositorio
        List<Empresa> empresas = transferenciaRepository.findEmpresasConTransferenciasEntre(lastMonth, now);

        // Verificar el resultado
        assertEquals(1, empresas.size());
        assertEquals("30-12345678-9", empresas.get(0).getCuit());
    }
}