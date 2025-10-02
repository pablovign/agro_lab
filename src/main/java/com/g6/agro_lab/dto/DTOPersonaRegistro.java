package com.g6.agro_lab.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOPersonaRegistro(
        @NotBlank(message = "El DNI es obligatorio.")
        @Size(min = 7, max = 8)
        @Digits(integer = 8, fraction = 0)
        String dni,

        @NotBlank(message = "El nombre es obligatorio")
        String nombrePersona,

        @NotBlank(message = "El apellido es obligatorio")
        String apellido,

        @NotBlank
        @Digits(integer = 12, fraction = 0)
        String telefono,

        @Email
        String email,

        @NotBlank
        String contrasenia
){}
