package com.franquicia.msinventario.controller;

import com.franquicia.msinventario.entity.CorteCarne;
import com.franquicia.msinventario.repository.CorteCarneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario") // URL de la base de datos
public class CorteCarneController {

    @Autowired
    private CorteCarneRepository repository; 

    // 1. URL para ver toda la carne (Método GET)
    @GetMapping
    public List<CorteCarne> obtenerInventario() {
        
        return repository.findAll(); 
    }

    // 2. URL para registrar un nuevo lote de carne (Método POST)
    @PostMapping
    public CorteCarne agregarCorte(@RequestBody CorteCarne nuevoCorte) {
        // Recibimos los datos por internet
        return repository.save(nuevoCorte);
    }
}
