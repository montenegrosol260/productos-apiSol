package com.utn.productos_api.service;

import com.utn.productos_api.dto.ActualizarStockDTO;
import com.utn.productos_api.dto.ProductoDTO;
import com.utn.productos_api.dto.ProductoResponseDTO;


import com.utn.productos_api.exception.ProductoNotFoundException;
import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.model.Producto;
import com.utn.productos_api.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoResponseDTO crearProducto (ProductoDTO productoDTO) {
        Producto productoCreado = Producto.builder()
                .nombre(productoDTO.nombre())
                .descripcion(productoDTO.descripcion())
                .stock(productoDTO.stock())
                .precio(productoDTO.precio())
                .categoria(productoDTO.categoria())
                .build();
        return ProductoResponseDTO.fromEntity(productoRepository.save(productoCreado));
    }

    public List<ProductoResponseDTO> obtenerTodos(){
        return productoRepository.findAll()
                .stream()
                .map(ProductoResponseDTO::fromEntity)
                .toList();
    }

    public Optional<ProductoResponseDTO> obtenerPorId(Long id){
        return productoRepository.findById(id)
                .map(ProductoResponseDTO::fromEntity);
    }

    public List<ProductoResponseDTO> obtenerPorCategoria(Categoria categoria){
        List<Producto> productos = productoRepository.findByCategoria(categoria);
        return productos.stream()
                .map(ProductoResponseDTO::fromEntity)
                .toList();
    }

    public ProductoResponseDTO actualizarProducto(Long id, ProductoDTO requestDTO){
        Optional<Producto> productoBuscado = productoRepository.findById(id);

        if( productoBuscado.isPresent()){
            Producto producto = productoBuscado.get();

            producto.setNombre(requestDTO.nombre());
            producto.setDescripcion(requestDTO.descripcion());
            producto.setStock(requestDTO.stock());
            producto.setPrecio(requestDTO.precio());
            producto.setCategoria(requestDTO.categoria());

            Producto pactualizado = productoRepository.save(producto);
            return ProductoResponseDTO.fromEntity(pactualizado);

        } else {
            throw new ProductoNotFoundException("No existe el producto con el id: " + id);
        }
    }

    public ProductoResponseDTO actualizarStock(Long id, ActualizarStockDTO stockDTO){
        Optional<Producto> productoBuscado = productoRepository.findById(id);
        if( productoBuscado.isPresent()){
            Producto producto = productoBuscado.get();
            producto.setStock(stockDTO.stock());

            Producto productoGuardado =  productoRepository.save(producto);

            return ProductoResponseDTO.fromEntity(productoGuardado);
        }else {
            throw new ProductoNotFoundException("No existe el producto con el id: " + id);
        }
    }

    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException("No se puede eliminar. No existe el producto con el id: " + id);
        }
        productoRepository.deleteById(id);
    }
}