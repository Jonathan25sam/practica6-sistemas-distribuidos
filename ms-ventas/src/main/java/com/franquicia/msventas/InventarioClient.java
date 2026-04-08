package com.franquicia.msventas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// buscar a ms-inventarios
@FeignClient(name = "ms-inventario")
public interface InventarioClient {

    // ruta exacta de ms-inventario 
    @GetMapping("/api/inventario")
    String obtenerMenuDeCarnes(); 

}
