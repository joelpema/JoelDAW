package com;

import java.time.LocalDate;

public abstract class Articulo{

    protected int Cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;

    public Articulo(int cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja) {
        Cod = cod;
        this.titulo = titulo;
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
    }


    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Articulo{");
        sb.append("Cod=").append(Cod);
        sb.append(", titulo=").append(titulo);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append('}');
        return sb.toString();
    }

}
