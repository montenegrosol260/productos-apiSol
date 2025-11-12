package com.utn.productos_api.dto;

import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.model.Producto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para enviar los detalles completos de un producto")
public record ProductoResponseDTO(
        @Schema(description = "ID único del producto en la base de datos", example = "1")
        Long id,
        @Schema(description = "Nombre del producto", example = "Monitor Gamer Curvo 27\"")
        String nombre,
        @Schema(description = "Descripción detallada del producto", example = "Monitor 144Hz 1ms...")
        String descripcion,
        @Schema(description = "Precio de venta del producto", example = "299.99")
        Double precio,
        @Schema(description = "Cantidad de unidades en inventario", example = "50")
        Integer stock,
        @Schema(description = "Categoría a la que pertenece el producto", example = "ELECTRONICA")
        Categoria categoria
) {

    // Método de fábrica estático para la conversión
    public static ProductoResponseDTO fromEntity(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria()
        );
    }
}
