package com.example.challenge.infrastructure.web;

import com.example.challenge.application.dto.EmpresaDTO;
import com.example.challenge.application.dto.TransferenciaDTO;
import com.example.challenge.application.service.TransferenciaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    private TransferenciaServiceImpl transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaServiceImpl transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<TransferenciaDTO> crearTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        TransferenciaDTO transferenciaGuardada = transferenciaService.guardarTransferencia(transferenciaDTO);
        return ResponseEntity.ok(transferenciaGuardada);
    }

    @GetMapping("/empresas-ultimo-mes")
    public ResponseEntity<List<EmpresaDTO>> getEmpresasConTransferenciasEnUltimoMes() {
        List<EmpresaDTO> empresas = transferenciaService.getEmpresasConTransferenciasEnUltimoMes();
        return ResponseEntity.ok(empresas);
    }

}