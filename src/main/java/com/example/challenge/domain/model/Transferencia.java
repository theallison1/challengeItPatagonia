package com.example.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fechaTransferencia;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference // Indica que esta es la parte "respaldada" de la relación
    private Empresa empresa;

    public Transferencia() {
    }

    public Transferencia(String cuentaDebito, Long id, Double importe, String cuentaCredito, LocalDate fechaTransferencia, Empresa empresa) {
        this.cuentaDebito = cuentaDebito;
        this.id = id;
        this.importe = importe;
        this.cuentaCredito = cuentaCredito;
        this.fechaTransferencia = fechaTransferencia;
        this.empresa = empresa;
    }
// Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getCuentaDebito() {
        return cuentaDebito;
    }

    public void setCuentaDebito(String cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public String getCuentaCredito() {
        return cuentaCredito;
    }

    public void setCuentaCredito(String cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public LocalDate getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(LocalDate fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}