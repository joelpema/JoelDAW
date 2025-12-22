package com.example.empresaempleados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empresaempleados.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    // Spring Data construye la query automáticamente
    List<Empleado> findByEmpresaId(Long empresaId);
}
