package com.g6.agro_lab.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public record DTOEstablecimientoRegistro(
        @NotBlank(message = "El número de RENSPA es obligatorio.")
        @Size(min = 11, max = 11, message = "El número de RENSPA debe tener 11 dígitos.")
        @Digits(integer = 11, fraction = 0, message = "El número de RENSPA debe estar compuesto de números.")
        String numeroRenspa,

        @NotBlank(message = "El nombre del establecimiento es obligatorio.")
        String nombreEstablecimiento,

        @NotBlank(message = "La calle es obligatoria.")
        String calle,

        @NotBlank(message = "La numeración es obligatoria.")
        @Size(max = 5, message = "La numeración debe tener menos de 6 dígitos")
        @Digits(integer = 5, fraction = 0, message = "La numeración debe estar compuesta de números.")
        String numeracion,

        @NotBlank(message = "El código postal es obligatorio.")
        @Size(max = 4, message = "El código postal debe tener menos de 5 dígitos.")
        @Digits(integer = 5, fraction = 0, message = "El código postal debe estar compuesto de números.")
        String codigoPostal,

        @NotNull(message = "La localización geográfica es obligatoria.")
        DTOPoint localizacion,

        @NotNull(message = "El distrito es obligatorio.")
        Long idDistrito,

        @NotEmpty(message = "Debe seleccionarse al menos una especie.")
        List<@NotNull Long> idEspecies
) {}
