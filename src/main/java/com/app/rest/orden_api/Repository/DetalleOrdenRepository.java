package com.app.rest.orden_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rest.orden_api.Model.DetalleOrden;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer>{

}