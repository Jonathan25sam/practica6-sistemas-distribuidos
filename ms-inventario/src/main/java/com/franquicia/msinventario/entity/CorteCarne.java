package com.franquicia.msinventario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cortes_carne") // Así se llamará la tabla en la base de datos
public class CorteCarne {

    @Id // llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementable (1, 2, 3...)
    private Long id;

    private String nombreCorte; 
    private Double kilosDisponibles;
    private Double precioPorKilo;

    //encapsulamiento y constructor
    public CorteCarne() {
    }

    public CorteCarne(String nombreCorte, Double kilosDisponibles, Double precioPorKilo) {
        this.nombreCorte = nombreCorte;
        this.kilosDisponibles = kilosDisponibles;
        this.precioPorKilo = precioPorKilo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCorte() { return nombreCorte; }
    public void setNombreCorte(String nombreCorte) { this.nombreCorte = nombreCorte; }

    public Double getKilosDisponibles() { return kilosDisponibles; }
    public void setKilosDisponibles(Double kilosDisponibles) { this.kilosDisponibles = kilosDisponibles; }

    public Double getPrecioPorKilo() { return precioPorKilo; }
    public void setPrecioPorKilo(Double precioPorKilo) { this.precioPorKilo = precioPorKilo; }
}
