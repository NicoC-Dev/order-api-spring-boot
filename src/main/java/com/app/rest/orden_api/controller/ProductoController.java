package com.app.rest.orden_api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rest.orden_api.Service.IProductoService;
import com.app.rest.orden_api.dto.ProductoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/")
public class ProductoController {
    

    @Autowired
    private IProductoService productoService;

    @GetMapping({"productos"})
    public List<ProductoDto> getAll()
    {
        
        
        return productoService.Listar();
    }

    @PostMapping("registrar_producto")
    public ProductoDto guarardar(@RequestBody ProductoDto dto){
        return productoService.guardar(dto);
    }
    
    
    

}
