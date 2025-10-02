package com.decroly.demo;

import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {

    private static final long serialVersionUID = -8989710790032110655L;

    private LocalDate fecha;
    private int duracion;
    private String observaciones;
    private Mascota mascota;

    public Consulta(LocalDate fecha, int duracion, String observaciones, Mascota mascota) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.mascota = mascota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha=" + fecha +
                ", duracion=" + duracion +
                ", observaciones='" + observaciones + '\'' +
                ", mascota=" + mascota +
                '}';
    }
}
