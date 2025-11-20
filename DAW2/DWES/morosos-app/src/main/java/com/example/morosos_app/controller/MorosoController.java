package com.example.morosos_app.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.morosos_app.model.Moroso;
import com.example.morosos_app.service.MorosoService;
@RestController
@RequestMapping("/morosos")
public class MorosoController {
private final MorosoService morosoService;
public MorosoController(MorosoService morosoService) {
this.morosoService = morosoService;
}
@GetMapping
public ResponseEntity<Object> getAll() {
return ResponseEntity.ok(morosoService.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<Moroso> getById(@PathVariable Long id) {
return (ResponseEntity<Moroso>) ResponseEntity.of(morosoService.findById(id));
}
@PostMapping
public ResponseEntity<Object> create(@RequestBody Moroso moroso) {
return ResponseEntity.ok(morosoService.save(moroso));
}
// PUT -> solo actualizar estado de pago
@PutMapping("/{id}/estado")
public ResponseEntity<Moroso> updateEstado(
@PathVariable Long id,
@RequestBody String nuevoEstado) {
return (ResponseEntity<Moroso>) ResponseEntity.of(morosoService.updateEstado(id, nuevoEstado));
}
}