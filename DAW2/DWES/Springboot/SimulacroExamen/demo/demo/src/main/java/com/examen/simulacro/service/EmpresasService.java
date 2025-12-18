package com.examen.simulacro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.simulacro.entity.empresas;
import com.examen.simulacro.repository.empresasRepository;

@Service
public class EmpresasService {
    
    private final empresasRepository empresaRepository;

    // Inyección de Dependencias a través del constructor
    public EmpresasService(empresasRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    /*
     * Crea y guarda una nueva entidad 'empresas'.
     * @return La entidad 'empresas' guardada con el ID generado.
     */
    public empresas crearEmpresa(empresas empresa) {
    
    // 1. Validación de Nulidad/Vacío del Nombre
    if (empresa.getNombre() == null || empresa.getNombre().trim().isEmpty()) {
        // Podrías lanzar una excepción personalizada (ej: InvalidDataException)
        // Por simplicidad, aquí lanzamos una excepción estándar de Java
        throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
    }

    // 2. Validación de Unicidad (asumiendo que el nombre de la empresa debe ser único)
    if (empresaRepository.existsByNombre(empresa.getNombre())) {
        // En un entorno de producción, sería mejor lanzar una excepción específica
        throw new IllegalStateException("Ya existe una empresa con el nombre: " + empresa.getNombre());
    }

    // Aseguramos que no se intente pasar un ID en el cuerpo
    // Si se pasa un ID, JPA lo usaría para actualizar, no para crear.
    empresa.setId(null); 
    
    // 3. Guardar la entidad
    empresas empresaGuardada = empresaRepository.save(empresa);

    return empresaGuardada;
}
    public Optional<empresas> obtenerEmpresaPorId(String id) {
        // Usamos el método findById que JpaRepository nos da por defecto
        return empresaRepository.findById(id); 
    }

    public boolean eliminarEmpresa(String id) {
    if (!empresaRepository.existsById(id)) {
        return false;
    }
    // Si la empresa tiene empleados asociados, 
    // y tu DB tiene una restricción de clave foránea, esta operación fallará 
    // a menos que hayas configurado la cascada de eliminación (CASCADE) o las elimines primero.

    empresaRepository.deleteById(id);
    return true;
}

public empresas editarEmpresa(String id, empresas empresaActualizada) {
    // 1. Buscar la empresa existente
    Optional<empresas> empresaExistenteOpt = empresaRepository.findById(id);

    if (empresaExistenteOpt.isEmpty()) {
        // La empresa no existe
        return null; 
    }

    empresas empresaExistente = empresaExistenteOpt.get();

    // 2. Actualizar solo el campo 'nombre' si viene en el cuerpo
    if (empresaActualizada.getNombre() != null && !empresaActualizada.getNombre().trim().isEmpty()) {
        
        // **OPCIONAL: Volver a validar unicidad del NUEVO nombre**
        if (empresaRepository.existsByNombre(empresaActualizada.getNombre())) {
            throw new IllegalStateException("Ya existe otra empresa con el nombre: " + empresaActualizada.getNombre());
        }

        empresaExistente.setNombre(empresaActualizada.getNombre());
    } else {
        // Si la actualización es para PUT/PATCH y el nombre es null o vacío, 
        // y es el único campo, podríamos lanzar una excepción si fuera requerido.
        // Por simplicidad, aquí solo actualizamos si el nombre es válido.
    }

    // 3. Guardar y devolver
    return empresaRepository.save(empresaExistente);
}
}