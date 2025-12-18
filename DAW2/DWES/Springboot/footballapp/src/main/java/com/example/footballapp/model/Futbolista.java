package com.example.footballapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Futbolista {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String nombre;
@Column
private String posicion;
@ManyToOne
@JoinColumn(name = "equipo_id")
private Equipo equipo;
public String getNombre() {
    return nombre;
}
public String getPosicion() {
    return posicion;
}
 
public Equipo getEquipo() {
    return equipo;
}
public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
}
}