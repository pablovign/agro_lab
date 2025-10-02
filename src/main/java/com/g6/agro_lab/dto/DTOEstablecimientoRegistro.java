package com.g6.agro_lab.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public record DTOEstablecimientoRegistro(
        @NotBlank
        @Size(min = 11, max = 11)
        @Digits(integer = 11, fraction = 0)
        String numeroRenspa,

        @NotBlank
        String nombreEstablecimiento,

        @NotBlank
        String calle,

        @NotBlank
        @Digits(integer = 5, fraction = 0)
        String numeracion,

        @NotBlank
        @Digits(integer = 5, fraction = 0)
        String codigoPostal,

        @NotNull(message = "La localización es obligatoria.")
        PointDTO localizacion,

        @NotNull(message = "El distrito es obligatorio.")
        Long idDistrito,

        @NotEmpty(message = "Debe seleccionarse al menos una especie.")
        List<@NotNull Long> idEspecies
) {}
