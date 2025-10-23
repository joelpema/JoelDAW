package com.example.GestionPistas.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

import com.example.GestionPistas.Pista;
// La anotación @Controller indica que esta clase es un controlador.

import ch.qos.logback.core.model.Model;
@Controller
public class nuevaPista {

    private List<Pista> pistas = new ArrayList<>(); 

@GetMapping("/")
@ResponseBody
public String mostrarPista(Model model) {

model.addAttribute("Pista", pistas);

return "index";

}

@PostMapping("/addPista")

}
