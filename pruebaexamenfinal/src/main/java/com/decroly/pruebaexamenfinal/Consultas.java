package com.decroly.pruebaexamenfinal;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Consultas implements Serializable {

    private static final long serialVersionUID = 7094058709518453675L;

    private LocalDate fecha;
    private String Observaciones;
    private Paciente paciente;
    private Doctor doctor;
    private Tipo tipoConsulta;

    public Consultas(LocalDate fecha, String observaciones, Paciente paciente, Doctor doctor, Tipo tipoConsulta) {
        this.fecha = fecha;
        Observaciones = observaciones;
        this.paciente = paciente;
        this.doctor = doctor;
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Tipo getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(Tipo tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public String toString() {
        return "Consultas{" +
                "fecha=" + fecha +
                ", Observaciones='" + Observaciones + '\'' +
                ", paciente=" + paciente +
                ", doctor=" + doctor +
                ", tipoConsulta=" + tipoConsulta +
                '}';
    }


}
