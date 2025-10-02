package com.decroly.practica_examen;

public class Profesor {

    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private Asignatura id_asignatura;

    public Profesor(String nombre, String apellido, int edad, String direccion, Asignatura id_asignatura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.id_asignatura = id_asignatura;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Asignatura getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Asignatura id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", id_asignatura=" + id_asignatura;
    }
}
