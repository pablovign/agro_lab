package com.g6.agro_lab.dto;

import jakarta.validation.constraints.NotNull;

public record DTOPoint(
        @NotNull(message = "La latitud es obligatoria.")
        Double latitud,

        @NotNull(message = "La longitud es obligatoria.")
        Double longitud
) {}
