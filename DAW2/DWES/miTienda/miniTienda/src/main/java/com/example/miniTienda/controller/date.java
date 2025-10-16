package com.example.miniTienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// La anotación @Controller indica que esta clase es un controlador.
@Controller
public class date {

@GetMapping("/fecha")
@ResponseBody
public String mostrarFecha() {

return "Fecha actual: " + java.time.LocalDate.now();
}

}
