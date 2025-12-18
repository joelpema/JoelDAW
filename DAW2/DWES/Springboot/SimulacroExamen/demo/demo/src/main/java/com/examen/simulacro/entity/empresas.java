package com.examen.simulacro.entity;

//import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class empresas {
    
    @Id
    @GeneratedValue(generator = "uuid") // Le dice a Hibernate que lo genere.
    @GenericGenerator(name = "uuid", strategy = "uuid2") // Le dice a Hibernate que use UUID.
    private String id ;//= UUID.randomUUID().toString();

    private String nombre;

    public empresas(){}

    public empresas(String nombre){
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
