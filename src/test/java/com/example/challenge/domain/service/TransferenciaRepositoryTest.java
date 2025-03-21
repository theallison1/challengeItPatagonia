package com.example.challenge.domain.service;

import com.example.challenge.domain.model.Empresa;
import com.example.challenge.domain.model.Transferencia;
import com.example.challenge.domain.repository.EmpresaRepository;
import com.example.challenge.domain.repository.TransferenciaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TransferenciaRepositoryTest {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private TestEntityManager entityManager; // Para gestionar la persistencia en pruebas

    @Test
    public void testFindEmpresasConTransferenciasEntre() {
        // Configurar datos de prueba
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

        // Crear y persistir la empresa
        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Empresa de Prueba");
        empresa = empresaRepository.save(empresa);

        // Crear y persistir la transferencia
        Transferencia transferencia = new Transferencia();
        transferencia.setImporte(1000.0);
        transferencia.setCuentaDebito("Cuenta1");
        transferencia.setCuentaCredito("Cuenta2");
        transferencia.setFechaTransferencia(now);
        transferencia.setEmpresa(empresa); // Asignar la empresa a la transferencia
        transferenciaRepository.save(transferencia); // Persistir la transferencia

        // Forzar la sincronización con la base de datos
        entityManager.flush();
        entityManager.clear();

        List<Empresa> empresas = transferenciaRepository.findEmpresasConTransferenciasEntre(lastMonth, now);

        // Verificar el resultado
        assertEquals(1, empresas.size(), "Debería haber una empresa con transferencias en el último mes");
        assertEquals("30-12345678-9", empresas.get(0).getCuit(), "El CUIT de la empresa no coincide");
    }
}