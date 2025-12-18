package com.example.footballapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.footballapp.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}