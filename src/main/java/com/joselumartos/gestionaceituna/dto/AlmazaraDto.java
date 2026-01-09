package com.joselumartos.gestionaceituna.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.joselumartos.gestionaceituna.model.Almazara}
 */
public record AlmazaraDto(
        @Positive(message = "El ID debe ser un entero positivo")
        Long id,

        @NotBlank(message = "Debes introducir algún valor")
        @Size(message = "El nombre debe tener entre 0 y 100 carácteres", min = 0, max = 100)
        String nombre,

        @Size(message = "La dirección debe tener entre 0 y 100 carácteres", min = 0, max = 100)
        String direccion,

        @Pattern(message = "Debes introducir un formato válido para teléfono", regexp = "^[76][0-9]{8}$")
        @Size(message = "Teléfono debe tener 9 dígitos", min = 9, max = 9)
        String telefono,

        @PositiveOrZero(message = "El valor debe ser positivo o 0")
        @Range(message = "La capacidad debe estar entre 0 y 1000 toneladas", min = 0, max = 1000)
        Integer capacidadToneladasDiarias
) implements Serializable {
}