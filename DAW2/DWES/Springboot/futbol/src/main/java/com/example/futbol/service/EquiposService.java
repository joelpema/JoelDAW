package com.example.futbol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.futbol.entity.Equipos;
import com.example.futbol.repository.EquiposRepository;

@Service
public class EquiposService {
    
    private final EquiposRepository equiposRepository;

    public EquiposService(EquiposRepository equiposRepository){
        this.equiposRepository = equiposRepository;
    }

    public List<Equipos> findAll(){
        return equiposRepository.findAll();
    }

    public Equipos save(Equipos equipos){
        return equiposRepository.save(equipos);
    }

    public boolean eliminarEquipo(Long id) {
        if (!equiposRepository.existsById(id)) {
            return false;
        }
        equiposRepository.deleteById(id);
        return true;
    }


}