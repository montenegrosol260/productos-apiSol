package com.utn.productos_api.controller;

import com.utn.productos_api.dto.ActualizarStockDTO;
import com.utn.productos_api.dto.ProductoDTO;
import com.utn.productos_api.dto.ProductoResponseDTO;
import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@Tag(name = "API de Productos", description = "Controlador para la gestión de productos")
public class ProductoController {
    private final ProductoService productoService;

    @Operation(summary = "Listar todos los productos", description = "Retorna una lista de todos los productos en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> obtenerTodos(){
        List<ProductoResponseDTO> productos = productoService.obtenerTodos();

        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Obtener producto por ID", description = "Busca un producto por su ID único.")
    @ApiResponses(value = { // <-- Múltiples respuestas
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
        // .map() transforma el DTO si está presente, .orElse() maneja el 404
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Filtrar por categoría", description = "Retorna una lista de productos que pertenecen a una categoría específica.")
    @ApiResponse(responseCode = "200", description = "Productos filtrados exitosamente")
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerPorCategoria(
            @PathVariable Categoria categoria
    ) {
        List<ProductoResponseDTO> productos = productoService.obtenerPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Crear un nuevo producto", description = "Crea un producto y lo almacena en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos (Error de validación)")
    })
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(
            @Valid @RequestBody ProductoDTO productoDTO
    ) {
        ProductoResponseDTO nuevoProducto = productoService.crearProducto(productoDTO);

        // Creamos la URI para el encabezado "Location"
        URI location = URI.create("/api/productos/" + nuevoProducto.id());

        return ResponseEntity.created(location).body(nuevoProducto);
    }

    @Operation(summary = "Actualizar un producto completo", description = "Actualiza todos los campos de un producto existente basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO productoDTO
    ) {
        ProductoResponseDTO productoActualizado = productoService.actualizarProducto(id, productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @Operation(summary = "Actualizar solo el stock", description = "Actualiza únicamente el stock de un producto específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos (ej: stock negativo)"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductoResponseDTO> actualizarStock(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarStockDTO stockDTO
    ) {
        ProductoResponseDTO productoActualizado = productoService.actualizarStock(id, stockDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto de la base de datos por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

}
