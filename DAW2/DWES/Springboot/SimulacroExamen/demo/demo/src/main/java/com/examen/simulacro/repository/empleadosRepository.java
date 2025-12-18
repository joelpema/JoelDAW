package com.examen.simulacro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.simulacro.entity.empleados;

public interface empleadosRepository extends JpaRepository<empleados, String>{

    List<empleados> findByEmpresasId(String empresaId);// = SELECT * FROM empleados 
                                                        //WHERE empresa_id = [el valor de empresaId que se pasa]
}
