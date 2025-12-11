package com.example.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.futbol.entity.Equipos;
public interface EquiposRepository extends JpaRepository<Equipos, Long> {

    
}
