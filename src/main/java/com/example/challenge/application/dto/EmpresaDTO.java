package com.example.challenge.application.dto;

import java.time.LocalDate;

public class EmpresaDTO {
    private String cuit;
    private String razonSocial;
    private LocalDate fechaAdhesion;

    // Constructor vacío (necesario para deserialización JSON)
    public EmpresaDTO() {}

    // Constructor con parámetros
    public EmpresaDTO(String cuit, String razonSocial, LocalDate fechaAdhesion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaAdhesion = fechaAdhesion;
    }

    // Getters y Setters
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFechaAdhesion() {
        return fechaAdhesion;
    }

    public void setFechaAdhesion(LocalDate fechaAdhesion) {
        this.fechaAdhesion = fechaAdhesion;
    }

    // Método toString (opcional, útil para logging)
    @Override
    public String toString() {
        return "EmpresaDTO{" +
                "cuit='" + cuit + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", fechaAdhesion=" + fechaAdhesion +
                '}';
    }
}