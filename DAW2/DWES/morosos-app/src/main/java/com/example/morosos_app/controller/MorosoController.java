package com.example.morosos_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.morosos_app.model.Moroso;



@RestController

public class MorosoController {

    public ArrayList<Moroso> lista = new ArrayList<>();

    @GetMapping("/api/morosos/lista")
    public ArrayList<Moroso> obtenerLista() {
        return lista;
    }

    @PostMapping("/api/morosos")
    public String addMoroso(@RequestBody  List<Moroso> moroso){
        lista.addAll(moroso);
        return "bien hecho";
    }
    @DeleteMapping("/api/morosos/remove/{id}")
    public void removeMoroso(@PathVariable String id){
        for (Moroso moroso : lista) {
            if(moroso.getId().equals(id)){
                lista.remove(moroso);
            }
        }
    }

}