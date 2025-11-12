package com.utn.productos_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para actualizar únicamente el stock de un producto")
public record ActualizarStockDTO(
        @Schema(description = "La nueva cantidad de unidades en inventario", example = "75")
        @NotNull(message = "El stock no puede ser nulo")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock
) {
}