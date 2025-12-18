package com.examen.simulacro.contreller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.simulacro.entity.empleados;
import com.examen.simulacro.entity.empresas;
import com.examen.simulacro.repository.empleadosRepository;
import com.examen.simulacro.repository.empresasRepository;
import com.examen.simulacro.service.EmpleadosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class empleadosController {
    
    @Autowired
    private EmpleadosService empleadosService;

    @Autowired
    private empresasRepository empresasRepository;

    @GetMapping("/empresas/{empresaId}/empleados")
    public ResponseEntity<List<empleados>> getEmpleadosPorEmpresa(@PathVariable String empresaId) {
        List<empleados> empleados = empleadosService.obtenerEmpleadosPorEmpresa(empresaId);

        if (empleados == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<empleados> getEmpleadoPorId(@PathVariable String id) {
    Optional<empleados> empleado = empleadosService.obtenerEmpleadoPorId(id);

    // Usamos el .map() de Optional para manejar si el empleado existe o no
    return empleado.map(ResponseEntity::ok) // Si existe, devuelve 200 OK con el cuerpo
                   .orElseGet(() -> ResponseEntity.notFound().build()); // Si no existe, devuelve 404 Not Found
}

    
    @PostMapping("/empleados")
    public ResponseEntity<empleados> crearEmpleado(@RequestBody empleados empleados) {
        empleados empleadoSave = empleadosService.crearEmpleado(empleados);

         if (empleadoSave == null) {
            return ResponseEntity.badRequest().build();
        }

        // Devolvemos 201 Created con la URL del nuevo recurso
        URI location = URI.create("/api/empleados/" + empleadoSave.getId());
        return ResponseEntity.created(location).body(empleadoSave);
    }
    
    @DeleteMapping({"/empleados/{id}"})
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String id) {
        boolean eliminado = empleadosService.eliminarEmpleado(id);

        if(!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<empleados> actualizarEmpleado(@PathVariable String id, @RequestBody empleados empleadoActualizado) {
        empleados empleadoEditado = empleadosService.editarEmpleado(id, empleadoActualizado);

        if (empleadoEditado == null) {
            // Esto sucede si el empleado no existe O si la nueva empresa no existe (ver Service)
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(empleadoEditado);
    }
}
