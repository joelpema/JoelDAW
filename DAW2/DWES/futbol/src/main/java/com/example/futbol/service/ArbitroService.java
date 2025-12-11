package com.example.futbol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.futbol.entity.Arbitro;
import com.example.futbol.repository.ArbitroRepository;

@Service
public class ArbitroService {
    
    private final ArbitroRepository arbitroRepository;

    public ArbitroService(ArbitroRepository arbitroRepository){
        this.arbitroRepository = arbitroRepository;
    }

    public List<Arbitro> findAll(){
        return arbitroRepository.findAll();
    }

    public Arbitro save(Arbitro arbitro){
        return arbitroRepository.save(arbitro);
    }

    public boolean eliminarEquipo(Long id) {
        if (!arbitroRepository.existsById(id)) {
            return false;
        }
        arbitroRepository.deleteById(id);
        return true;
    }

}
