package com;

public class Tipo {

    private int id;
    private String nombre;

    public Tipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Tipo [id=" + id + ", nombre=" + nombre + "]";
    }

}
