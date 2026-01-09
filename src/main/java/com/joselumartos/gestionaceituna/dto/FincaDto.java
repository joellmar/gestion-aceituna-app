package com.joselumartos.gestionaceituna.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.joselumartos.gestionaceituna.model.Finca}
 */
public record FincaDto(
        @Positive(message = "El ID debe ser un entero positivo")
        Long id,

        @NotBlank(message = "Debes introducir un nombre")
        @Size(message = "El nombre debe tener entre 0 y 100 caracteres", min = 0, max = 100)
        String nombre,

        @NotBlank(message = "Debes introducir un propietario")
        @Size(message = "El nombre del propietario debe tener entre 0 y 100 caracteres", min = 0, max = 100)
        String propietario,

        @Digits(message = "El valor debe estar dentro de los límites (<5 dígitos>.<2 dígitos>)", integer = 5, fraction = 2)
        @PositiveOrZero(message = "El valor debe ser positivo o 0")
        @Range(message = "La extensión debe tener entre 0 y 99999.99 hectáreas", min = 0, max = 100000)
        Double extensionHectareas,

        @Size(message = "La variedad de aceituna debe tener entre y 20 caracteres", min = 0, max = 20)
        String variedadAceituna,

        Boolean activaCampaña
) implements Serializable {
}