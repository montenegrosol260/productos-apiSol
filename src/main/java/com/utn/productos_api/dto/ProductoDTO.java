package com.utn.productos_api.dto;

import com.utn.productos_api.model.Categoria;
import jakarta.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear o actualizar un producto")
public record ProductoDTO(
        @Schema(description = "Nombre del producto", example = "Monitor Gamer Curvo 27\"")
        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
        String nombre,

        @Schema(description = "Descripción detallada del producto", example = "Monitor 144Hz 1ms...")
        @NotNull(message = "La descripción no puede ser nula")
        @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
        String descripcion,

        @Schema(description = "Precio de venta del producto", example = "299.99")
        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser como mínimo 0.01")
        Double precio,

        @Schema(description = "Cantidad de unidades en inventario", example = "50")
        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,

        @Schema(description = "Categoría a la que pertenece el producto", example = "ELECTRONICA")
        @NotNull(message = "La categoría es obligatoria")
        Categoria categoria
) {
}
