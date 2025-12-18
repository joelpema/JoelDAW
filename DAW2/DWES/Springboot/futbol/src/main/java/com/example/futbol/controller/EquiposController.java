package com.example.futbol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbol.entity.Equipos;
import com.example.futbol.repository.EquiposRepository;
import com.example.futbol.service.EquiposService;


@RestController
@RequestMapping("/equipos")
public class EquiposController {

    private final EquiposRepository equiposRepository;
    
    private final EquiposService equiposService;

    public EquiposController(EquiposService equiposService, EquiposRepository equiposRepository){
        this.equiposService = equiposService;
        this.equiposRepository = equiposRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Equipos>> getAll(){
        return ResponseEntity.ok(equiposService.findAll());
    }

    @PostMapping
    public ResponseEntity<Equipos> crearCiudad(@RequestBody Equipos equipos) {
        // process POST request
        return ResponseEntity.ok(equiposService.save(equipos));
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        boolean eliminado = equiposService.eliminarEquipo(id);

        if(!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


}
