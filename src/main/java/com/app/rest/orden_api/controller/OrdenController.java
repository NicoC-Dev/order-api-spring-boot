package com.app.rest.orden_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.rest.orden_api.Service.IOrdenService;

import com.app.rest.orden_api.dto.OrdenDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class OrdenController {
    @Autowired
    private IOrdenService ordenService;
    
    @GetMapping("ordenes")
    public List<OrdenDto> getAll() {
        
        return ordenService.Listar();
    }

    @PostMapping("registrar_orden")
    public ResponseEntity<OrdenDto> crearOrden(@RequestBody OrdenDto ordenDto) {
        OrdenDto nuevaOrden = ordenService.guardar(ordenDto);
        return new ResponseEntity<>(nuevaOrden, HttpStatus.CREATED);
    }
    
}
