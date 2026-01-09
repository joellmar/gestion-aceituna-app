package com.joselumartos.gestionaceituna.dto;

import com.joselumartos.gestionaceituna.model.Cuadrilla;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.joselumartos.gestionaceituna.model.Trabajador}
 */
public record TrabajadorDto(
        @Positive(message = "El ID debe ser un entero positivo")
        Long id,

        @NotBlank(message = "Debes introducir un valor para nombre")
        @Size(message = "EL nombre debe tener entre 0 y 100 caracteres", min = 0, max = 100)
        String nombre,

        @Pattern(message = "Debes introducir un formato válido para DNI", regexp = "(^[0-9]{8})(-?)([A-Za-z])$")
        @NotBlank(message = "Debes introducir un valor para DNI")
        @Size(message = "DNI debe tener 9 caracteres", min = 9, max = 9)
        String dni,

        @Pattern(message = "Debes introducir un formato válido para teléfono", regexp = "^[76][0-9]{8}$")
        @Size(message = "Teléfono debe tener 9 caracteres", min = 9, max = 9)
        String telefono,

        @Size(message = "Categoría profesional debe tener 9 caracteres", min = 0, max = 50)
        String categoriaProfesional,

        Boolean activo

) implements Serializable {
}