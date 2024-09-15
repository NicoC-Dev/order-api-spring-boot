package com.app.rest.orden_api.Service;

import java.util.List;

import com.app.rest.orden_api.dto.OrdenDto;


public interface IOrdenService {
 
    public List<OrdenDto> Listar(); 

    public OrdenDto guardar(OrdenDto dto);

}
