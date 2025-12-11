package com.example.futbol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbol.repository.ArbitroRepository;
import com.example.futbol.service.ArbitroService;

@RestController
@RequestMapping("/arbitros")
public class ArbitroController {
    
    private final ArbitroRepository arbitroRepository;
    
    private final ArbitroService arbitroService;

    public ArbitroController(ArbitroService arbitroService, ArbitroRepository arbitroRepository){
        this.arbitroService = arbitroService;
        this.arbitroRepository = arbitroRepository;
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(arbitroService.findAll());
    } 

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        boolean eliminado = arbitroService.eliminarEquipo(id);

        if(!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}