package com;

import java.time.LocalDate;

public class Pelicula extends Articulo{

    private int genero;
    private LocalDate fechaAlquiler;
    private boolean isAlquilada;

    
    public Pelicula(int cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, int genero,
            LocalDate fechaAlquiler, boolean isAlquilada) {
        super(cod, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }


    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("Cod=").append(getCod());
        sb.append(", titulo=").append(getTitulo());
        sb.append(", fechaRegistro=").append(getFechaRegistro());
        sb.append(", fechaBaja=").append(getFechaBaja());
        sb.append("genero=").append(genero);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", isAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }

    


 
}
