package com;

import java.time.LocalDate;

public class Videojuego extends Articulo{

    private int genero;
    private LocalDate fechaAlquilada;
    private boolean isAlquilada;

    
    public Videojuego(int cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, int genero,
            LocalDate fechaAlquilada, boolean isAlquilada) {
        super(cod, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquilada = fechaAlquilada;
        this.isAlquilada = isAlquilada;
    }


    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public LocalDate getFechaAlquilada() {
        return fechaAlquilada;
    }

    public void setFechaAlquilada(LocalDate fechaAlquilada) {
        this.fechaAlquilada = fechaAlquilada;
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
        sb.append("Videojuego{");
        sb.append("Cod=").append(getCod());
        sb.append(", titulo=").append(getTitulo());
        sb.append(", fechaRegistro=").append(getFechaRegistro());
        sb.append(", fechaBaja=").append(getFechaBaja());
        sb.append("genero=").append(genero);
        sb.append(", fechaAlquilada=").append(fechaAlquilada);
        sb.append(", isAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }

    
    
}
