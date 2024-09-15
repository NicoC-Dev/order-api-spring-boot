package com.app.rest.orden_api.Service;

import java.util.List;

import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.dto.CrudProductoDto;


public interface IProductoService {
    
    
    public List<CrudProductoDto> Listar();


    public Producto buscarPorId(Integer id);


    public Producto guardar(Producto producto);


    public CrudProductoDto guardar(CrudProductoDto dto);


    public Producto eliminar(Producto producto);    

    
}
