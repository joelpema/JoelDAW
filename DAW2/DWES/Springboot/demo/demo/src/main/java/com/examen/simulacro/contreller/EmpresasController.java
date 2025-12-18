package com.examen.simulacro.contreller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.simulacro.entity.empresas;
import com.examen.simulacro.service.EmpresasService;

@RestController
@RequestMapping("/api")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @PostMapping("/empresas")
    public ResponseEntity<empresas> crearEmpresa(@RequestBody empresas empresas) {
        // La lógica de validación de negocio se ejecuta en el Service

        empresas empresaSave = empresasService.crearEmpresa(empresas);

        URI location = URI.create("/api/empresas/" + empresaSave.getId());
        return ResponseEntity.created(location).body(empresaSave);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<empresas> getEmpresaPorId(@PathVariable String id) {
        Optional<empresas> empresa = empresasService.obtenerEmpresaPorId(id);

        return empresa.map(ResponseEntity::ok) // Si existe, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no existe, devuelve 404 Not Found
    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable String id) {
        boolean eliminado = empresasService.eliminarEmpresa(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        // 204 No Content indica que la acción fue exitosa, pero no hay cuerpo de
        // respuesta
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity<empresas> actualizarEmpresa(@PathVariable String id,
            @RequestBody empresas empresaActualizada) {
        try {
            empresas empresaEditada = empresasService.editarEmpresa(id, empresaActualizada);

            if (empresaEditada == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(empresaEditada);
        } catch (IllegalStateException ex) {
            // Maneja la excepción de unicidad (nombre duplicado)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
