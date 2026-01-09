package com.joselumartos.gestionaceituna.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.joselumartos.gestionaceituna.model.Cuadrilla}
 */
public record CuadrillaDto(
        @Positive(message = "El ID debe ser un entero positivo")
        Long id,

        @NotBlank(message = "Debes introducir un nombre")
        @Size(message = "El nombre debe tener entre 0 y 100 caracteres", min = 0, max = 100)
        String nombre,

        @NotBlank(message = "Debes introducir un responsable")
        @Size(message = "Responsable debe tener entre 0 y 100 caracteres", min = 0, max = 100)
        String responsable,

        @PositiveOrZero(message = "El número máximo de trabajadores debe ser 0 o superior")
        Integer numeroMaximoTrabajadores,

        Boolean activa
) implements Serializable {
}