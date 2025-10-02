package com.g6.agro_lab.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTORegistro(
        @NotNull(message = "La empresa es obligatoria.")
        @Valid
        DTOEmpresaRegistro dtoEmpresaRegistro,

        @NotNull(message = "El establecimiento es obligatorio.")
        @Valid
        DTOEstablecimientoRegistro dtoEstablecimientoRegistro,

        @NotNull(message = "La persona que administra la empresa es obligatoria.")
        @Valid
        DTOPersonaRegistro dtoPersonaEmpresaRegistro,

        DTOPersonaRegistro dtoPersonaEstablecimientoRegistro
) { }
