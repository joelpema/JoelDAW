package com.decroly.pruebaexamenfinal;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Persona implements Serializable {

    private static final long serialVersionUID = 7187356594302461443L;

    private String numeroColegiado;
    private Tipo tipo;
    private LocalDate inicioValdecilla;

    public Doctor(String nombre, String apellido, String dni, String telefono, String dereccion, String email, String numeroColegiado, Tipo tipo, LocalDate inicioValdecilla) {
        super(nombre, apellido, dni, telefono, dereccion, email);
        this.numeroColegiado = numeroColegiado;
        this.tipo = tipo;
        this.inicioValdecilla = inicioValdecilla;
    }


    public Doctor(String numColegiado, String nombre, String apellido, String telefono, String direccion, String email, LocalDate fechaAlta, Tipo tipo) {
        super(nombre, apellido, "", telefono, direccion, email);
        this.numeroColegiado = numColegiado;
        this.tipo = tipo;
        this.inicioValdecilla = fechaAlta;
    }

    public Doctor(String doctorNumColegiado, int doctorTipoConsultaId) {
        super("", "", "", "", "", "");
        this.numeroColegiado = doctorNumColegiado;
        this.tipo = new Tipo("", doctorTipoConsultaId);
        this.inicioValdecilla = LocalDate.now(); // Default to current date
    }


    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getInicioValdecilla() {
        return inicioValdecilla;
    }

    public void setInicioValdecilla(LocalDate inicioValdecilla) {
        this.inicioValdecilla = inicioValdecilla;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "numeroColegiado='" + numeroColegiado + '\'' +
                ", tipo=" + tipo +
                ", inicioValdecilla=" + inicioValdecilla +
                '}';
    }
}
