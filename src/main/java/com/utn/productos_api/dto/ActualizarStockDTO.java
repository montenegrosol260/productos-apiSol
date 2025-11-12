package com.utn.productos_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ActualizarStockDTO(

        @NotNull(message = "El stock no puede ser nulo")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock
) {
}