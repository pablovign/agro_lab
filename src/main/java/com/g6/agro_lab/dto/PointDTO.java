package com.g6.agro_lab.dto;

import jakarta.validation.constraints.NotNull;

public record PointDTO(
        @NotNull(message = "La latitud es obligatoria.")
        Double latitud,

        @NotNull(message = "La longitud es obligatoria.")
        Double longitud
) {}
