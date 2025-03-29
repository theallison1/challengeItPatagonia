package com.example.challenge.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public class EmpresaDTO {

    @NotBlank(message = "El campo 'cuit' no puede estar vacío")
    @Pattern(regexp = "\\d{11}", message = "El CUIT debe tener 11 dígitos")
    private String cuit;

    @NotBlank(message = "El campo 'razonSocial' no puede estar vacío")
    private String razonSocial;

    @NotNull(message = "El campo 'fechaAdhesion' no puede ser nulo")
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