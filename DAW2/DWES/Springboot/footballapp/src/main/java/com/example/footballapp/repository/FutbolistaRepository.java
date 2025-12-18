package com.example.footballapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.footballapp.model.Futbolista;



@Repository
public interface FutbolistaRepository extends JpaRepository<Futbolista, Long> {
}
  