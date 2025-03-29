package com.example.challenge.application.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String campo = error.getField();
            String mensaje = error.getDefaultMessage();

            // Personaliza el mensaje para campos vacíos o nulos
            if (mensaje.contains("no puede estar vacío") || mensaje.contains("no puede ser nulo")) {
                errores.put(campo, "El campo '" + campo + "' no puede estar vacío o nulo");
            } else {
                errores.put(campo, mensaje);
            }
        });
        return ResponseEntity.badRequest().body(errores);
    }

    // Maneja errores de deserialización (JSON no válido)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, String> respuesta = new HashMap<>();

        // Verifica si la causa es un JsonParseException (error de sintaxis en el JSON)
        if (ex.getCause() instanceof JsonParseException) {
            respuesta.put("mensaje", "Error en el formato de la solicitud");
            respuesta.put("detalle", "El JSON tiene un error de sintaxis");
        }
        // Verifica si la causa es un InvalidFormatException (error de tipo de dato)
        else if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause();
            String campo = invalidFormatException.getPath().get(0).getFieldName();
            respuesta.put("mensaje", "Error en el formato de la solicitud");
            respuesta.put("detalle", "El campo '" + campo + "' debe ser un valor válido");
        }
        // Verifica si la causa es un MismatchedInputException (campo vacío o nulo)
        else if (ex.getCause() instanceof MismatchedInputException) {
            MismatchedInputException mismatchedInputException = (MismatchedInputException) ex.getCause();
            String campo = mismatchedInputException.getPath().get(0).getFieldName();
            respuesta.put("mensaje", "Error en el formato de la solicitud");
            respuesta.put("detalle", "El campo '" + campo + "' no puede estar vacío o nulo");
        }
        // Si no se puede identificar el error, devuelve un mensaje genérico
        else {
            respuesta.put("mensaje", "Error en el formato de la solicitud");
            respuesta.put("detalle", "Revisar los valores de los campos");
        }

        return ResponseEntity.badRequest().body(respuesta);
    }
}