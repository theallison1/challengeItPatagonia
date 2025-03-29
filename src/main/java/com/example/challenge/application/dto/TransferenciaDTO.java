package com.example.challenge.application.dto;

import java.time.LocalDate;

public class TransferenciaDTO {
    private Double importe;
    private Long idEmpresa;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fechaTransferencia;

    // Constructor vacío (necesario para deserialización JSON)
    public TransferenciaDTO() {}

    // Constructor con parámetros
    public TransferenciaDTO(Double importe, Long idEmpresa, String cuentaDebito, String cuentaCredito, LocalDate fechaTransferencia) {
        this.importe = importe;
        this.idEmpresa = idEmpresa;
        this.cuentaDebito = cuentaDebito;
        this.cuentaCredito = cuentaCredito;
        this.fechaTransferencia = fechaTransferencia;
    }

    // Getters y Setters
    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    // Método toString (opcional, útil para logging)
    @Override
    public String toString() {
        return "TransferenciaDTO{" +
                "importe=" + importe +
                ", idEmpresa=" + idEmpresa +
                ", cuentaDebito='" + cuentaDebito + '\'' +
                ", cuentaCredito='" + cuentaCredito + '\'' +
                ", fechaTransferencia=" + fechaTransferencia +
                '}';
    }
}