package com.decroly.practica_examen;

public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private Profesion almacen;

    public Productos(String nombre, String descripcion, Profesion almacen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.almacen = almacen;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesion getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Profesion almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", almacen=" + almacen;
    }
}
