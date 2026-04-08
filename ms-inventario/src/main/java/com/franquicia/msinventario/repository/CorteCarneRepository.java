package com.franquicia.msinventario.repository;

import com.franquicia.msinventario.entity.CorteCarne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorteCarneRepository extends JpaRepository<CorteCarne, Long> {
    // Al heredar de JpaRepository, Spring Boot regala todos los métodos
    // save(), findAll(), findById(), deleteById() automáticamente. 
}
