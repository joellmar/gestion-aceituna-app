package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link ParteRecogida}
 */
public record ParteRecogidaDto(
        @Positive(message = "El ID debe ser un entero positivo")
        Long id,

        @NotNull(message = "Debes introducir una fecha")
        @PastOrPresent(message = "La fecha debe establecerse en el pasado o en el presente")
        LocalDate fecha,

        @Digits(message = "El valor debe estar dentro de los límites (<4 dígitos>.<2 dígitos>)", integer = 4, fraction = 2)
        @PositiveOrZero(message = "El valor debe ser positivo o 0")
        @Range(message = "Los kilos recogidos deben estar entre 0 y 9999.99", min = 0, max = 10000)
        Double kilosRecogidos,

        @Digits(message = "El valor debe estar dentro de los límites (<3 dígitos>.<2 dígitos>)", integer = 3, fraction = 2)
        @PositiveOrZero(message = "El valor debe ser positivo o 0")
        @Range(message = "Los kilos recogidos deben estar entre 0 y 100", min = 0, max = 100)
        Double rendimientoEstimado,

        @Size(message = "La descripción debe tener entre 0 y 500 caracteres", min = 0, max = 500)
        String observaciones,

        Long almazaraId,
        String almazaraNombre,

        Long fincaId,
        String fincaNombre,

        Long cuadrillaId,
        String cuadrillaNombre
) implements Serializable {
}