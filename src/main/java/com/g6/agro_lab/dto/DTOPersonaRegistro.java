package com.g6.agro_lab.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOPersonaRegistro(
        @NotBlank(message = "El DNI es obligatorio.")
        @Size(min = 7, max = 8, message = "El DNI debe tener 7 u 8 dígitos.")
        @Digits(integer = 8, fraction = 0, message = "El DNI debe estar compuesto de números.")
        String dni,

        @NotBlank(message = "El nombre de la persona es obligatorio.")
        String nombrePersona,

        @NotBlank(message = "El apellido es obligatorio.")
        String apellido,

        @NotBlank(message = "El número de teléfono es obligatorio.")
        @Digits(integer = 12, fraction = 0, message = "El número de teléfono debe estar compuesto de números.")
        @Column(name = "telefono", nullable = false)
        String telefono,

        @Email(message = "El e-mail debe estar formado correctamente.")
        String email,

        //@NotBlank(message = "La contraseña es obligatoria.")
        //@Size(min = 6, max = 6, message = "La contraseña debe tener 6 caracteres.")
        String contrasenia
){}
