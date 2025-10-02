package com.decroly.pruebaexamenfinal;

import java.io.Serializable;
import java.time.LocalDate;

public class Paciente extends Persona implements Serializable {

    private static final long serialVersionUID = -4401788530462482798L;

    private Consultas consultas;

    public Paciente(String nombre, String apellido, String dni, String telefono, String dereccion, String email, Consultas consultas) {
        super(nombre, apellido, dni, telefono, dereccion, email);
        this.consultas = consultas;
    }



    public Paciente(String nombre, String apellido, String dni, String telefono, String direccion, String email) {
        super(nombre, apellido, dni, telefono, direccion, email);
        this.consultas = new Consultas(LocalDate.now(), "", this, null, null);
    }

    public Consultas getConsultas() {
        return consultas;
    }

    public void setConsultas(Consultas consultas) {
        this.consultas = consultas;
    }
    public void addConsulta(Consultas consulta) {
        this.consultas = consulta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", dereccion='" + getDereccion() + '\'' +
                ", email='" + getEmail() + '\'' +
                "consultas=" + consultas +
                '}';
    }


}
