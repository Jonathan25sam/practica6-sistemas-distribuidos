package com.franquicia.msventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private InventarioClient telefonoInventario; // Inyectamos nuestro teléfono

    @GetMapping("/ver-disponibilidad")
    public String checarDisponibilidad() {
        // 1. El cliente entra a Ventas
        System.out.println("iniciando comunicación");
        
        // 2. Ventas usa el teléfono para llamar a Inventario
        String respuestaInventario = telefonoInventario.obtenerMenuDeCarnes();
        
        // 3. Ventas responde con lo que le dijo el Inventario
        return "respuesta desde inventario: <br><br>" + respuestaInventario;
    }
}