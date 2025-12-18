package com.examen.simulacro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.simulacro.entity.empresas;

@Repository
public interface empresasRepository extends JpaRepository<empresas, String>{

    //No es necesario un findbyid pq ya me lo da elJPAREPOSITORY, solo necesito un metodo
    //si necesito buscar empresas basandome en algo q no sea el id
    boolean existsByNombre(String nombre);
}
