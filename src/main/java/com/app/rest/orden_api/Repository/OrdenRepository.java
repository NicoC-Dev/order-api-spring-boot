package com.app.rest.orden_api.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rest.orden_api.Model.Orden;


@Repository
public interface OrdenRepository extends JpaRepository<Orden,Integer>{

    
}
