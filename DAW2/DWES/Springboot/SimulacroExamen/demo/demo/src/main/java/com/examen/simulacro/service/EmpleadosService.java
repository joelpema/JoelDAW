package com.examen.simulacro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examen.simulacro.entity.empleados;
import com.examen.simulacro.entity.empresas;
import com.examen.simulacro.repository.empleadosRepository;
import com.examen.simulacro.repository.empresasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpleadosService {

    private final empleadosRepository empleadoRepository;
    private final empresasRepository empresaRepository;

    public EmpleadosService(empleadosRepository empleadoRepository, empresasRepository empresaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<empleados> obtenerEmpleadosPorEmpresa(String empresaID) {
        if (!empresaRepository.existsById(empresaID)) {
            return null;
        }
        return empleadoRepository.findByEmpresasId(empresaID);
    }

    public Optional<empleados> obtenerEmpleadoPorId(String id) { // USO EL OPTIONAL PARA EVITARR EL NULLPOINTErException
        return empleadoRepository.findById(id); // Devuelve Optional.of(empleado) si existe
                                                // Devuelve Optional.empty() si no existe
    }

    // public empleados obtenerEmpleadoPorId(String id) {
    // empleados emp = empleadoRepository.findById(id);
    // return emp;
    // }

    public empleados crearEmpleado(empleados empleados) {
        // MIRO A VER PRIMERO SI EXISTE
        if (empleados.getEmpresas() == null || empleados.getEmpresas().getId() == null) {
            return null;
        }

        String empresaId = empleados.getEmpresas().getId();

        empresas empresas = empresaRepository.findById(empresaId).orElse(null); // BUSCO LA empresa completa

        if (empresas == null) {
            return null;
        }

        empleados.setEmpresas(empresas);

        return empleadoRepository.save(empleados);
    }

    public boolean eliminarEmpleado(String id) {
        if (!empleadoRepository.existsById(id)) {
            return false;
        }
        empleadoRepository.deleteById(id);
        return true;
    }

    //public empleados editarEmpleado(String id)
    public empleados editarEmpleado(String id, empleados empleadoActualizado) {
        // 1. Buscar el empleado existente por ID
        Optional<empleados> empleadoExistenteOpt = empleadoRepository.findById(id);

        if (empleadoExistenteOpt.isEmpty()) {
            // El empleado no existe
            return null; 
        }

        empleados empleadoExistente = empleadoExistenteOpt.get();

        // 2. Comprobar y cargar la Empresa si se intenta actualizar
        if (empleadoActualizado.getEmpresas() != null && empleadoActualizado.getEmpresas().getId() != null) {
            String nuevaEmpresaId = empleadoActualizado.getEmpresas().getId();
            
            // Buscar la empresa en la base de datos
            Optional<empresas> empresaOpt = empresaRepository.findById(nuevaEmpresaId);

            if (empresaOpt.isEmpty()) {
                // La nueva empresa no existe, no se puede actualizar
                return null;
            }
            // Asignar la entidad 'empresas' completa al empleado existente
            empleadoExistente.setEmpresas(empresaOpt.get());
        }
        
        // 3. Actualizar los campos del empleado existente con los nuevos valores (si no son null)
        if (empleadoActualizado.getNombre() != null) {
            empleadoExistente.setNombre(empleadoActualizado.getNombre());
        }
        if (empleadoActualizado.getApellido() != null) {
            empleadoExistente.setApellido(empleadoActualizado.getApellido());
        }
        if (empleadoActualizado.getEdad() != null) {
            empleadoExistente.setEdad(empleadoActualizado.getEdad());
        }

        // 4. Guardar y devolver el empleado actualizado
        return empleadoRepository.save(empleadoExistente);
    }
}
