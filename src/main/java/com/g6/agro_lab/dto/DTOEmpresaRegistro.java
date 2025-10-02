package com.g6.agro_lab.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOEmpresaRegistro(
        @NotBlank(message = "El CUIT es obligatorio.")
        @Size(min = 11, max = 11, message = "El CUIT debe tener 11 dígitos.")
        @Digits(integer = 11, fraction = 0, message = "El CUIT debe estar compuesto de números.")
        String cuit,

        @NotBlank(message = "La razón social es obligatoria.")
        String razonSocial
) {}
