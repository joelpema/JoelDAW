package com.example.futbol.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "arbitros")
public class Arbitro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String apellido1;
    @Column(nullable = false)
    String apellido2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Estado rol;


    public Arbitro(Long id, String nombre, String apellido1, String apellido2, Estado rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rol = rol;
    }

    public enum Estado {
        PRINCIPAL("PRINCIPAL"),
        ASISTENTE("ASISTENTE");
 
        private final String estado;
 
        Estado(String estado){
            this.estado = estado;
        }
 
        public String getEstado(){
            return estado;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Estado getRol() {
        return rol;
    }

    public void setRol(Estado rol) {
        this.rol = rol;
    }

}
