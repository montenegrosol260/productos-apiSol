package com.utn.productos_api.repository;

import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//a traves de esta interfaz spring me genera todas las operaciones CRUD
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    //Spring Data JPA lo interpreta e implementa
    List<Producto> findByCategoria(Categoria categoria);
}
