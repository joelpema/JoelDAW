package com.decroly.pruebaexamenfinal.model;


import java.io.Serializable;
import java.util.Date;

public class Mascota implements Serializable {

    private static final long serialVersionUID = -6005010233484090883L;

    private String pasaporte;
    protected String nombre;
    protected Double peso;
    private String propietarioDni;
    protected Tipo tipo;

    public Mascota(String pasaporte, String nombre, Double peso, String propietarioDni, Tipo tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.peso = peso;
        this.propietarioDni = propietarioDni;
        this.tipo = tipo;
    }

    public Mascota() {}

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPropietarioDni() {
        return propietarioDni;
    }

    public void setPropietarioDni(String propietarioDni) {
        this.propietarioDni = propietarioDni;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", propietarioDni='" + propietarioDni + '\'' +
                ", tipo=" + tipo;
    }
}
