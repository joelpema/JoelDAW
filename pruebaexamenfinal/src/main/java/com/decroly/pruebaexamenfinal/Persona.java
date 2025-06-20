package com.decroly.pruebaexamenfinal;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = -2642145632018018721L;

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String dereccion;
    private String email;

    public Persona(String nombre, String apellido, String dni, String telefono, String dereccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.dereccion = dereccion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDereccion() {
        return dereccion;
    }

    public void setDereccion(String dereccion) {
        this.dereccion = dereccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dereccion='" + dereccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
