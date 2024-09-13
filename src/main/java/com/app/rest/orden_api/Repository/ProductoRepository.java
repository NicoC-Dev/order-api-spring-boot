package com.app.rest.orden_api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rest.orden_api.Model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByEstaActivo(boolean estaActivo);
}