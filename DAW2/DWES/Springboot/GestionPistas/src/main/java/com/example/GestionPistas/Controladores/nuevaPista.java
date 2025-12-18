package com.example.GestionPistas.Controladores;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.GestionPistas.Pista;


@Controller
public class nuevaPista {

    private static List<Pista> listapista = new ArrayList<>();

    @GetMapping("/")
    public String mostrarPistas(Model model) {

        model.addAttribute("pistas", listapista);
        return "index";

    }
    
    @PostMapping("/addPista")
    public RedirectView añadirPista(
        @RequestParam String nombrePista,
        @RequestParam String  horas){

            Pista pista = new Pista(nombrePista, horas);

            listapista.add(pista);

        return new RedirectView("/");
    }
    


}
