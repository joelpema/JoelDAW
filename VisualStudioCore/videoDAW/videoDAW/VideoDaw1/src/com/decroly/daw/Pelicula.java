package com.decroly.daw;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    
    private int cod;
    private String titulo;
    private Generos genero;
    private LocalDateTime FechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    
    public Pelicula(String titulo, Generos genero){
        this.cod = this.contador;
        this.contador++;
        this.titulo = titulo;
        this.genero = genero;
        this.FechaRegistro = LocalDateTime.now();
        this.isAlquilada = false;
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getcodPelicula() {
        return cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public Generos getGenero() {
        return genero;
    }
    public LocalDateTime getfechaRegistro() {
        return FechaRegistro;
    }
    public LocalDate getfechaBaja() {
        return fechaBaja;
    }
    public LocalDateTime getfechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }


    public String InfoPelicula(){ 
        String getInfoPelicula = String.format("\nCod: Pel-%s, Titulo: %s, Genero: %s, Registro: %s, alquilada: %s",
        this.cod, this.titulo, this.genero, this.FechaRegistro.format(formatter), this.isAlquilada);
        return getInfoPelicula;
    }
    
    public String CodPelicula(){ 
        String codigoPelicula = String.format("Numero: %s", this.cod);
        return codigoPelicula;
    }


    public boolean Alquiler(){ 
        this.isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
        return isAlquilada;
    }

    public boolean devolver(){
        this.isAlquilada = false;
        LocalDateTime ahora = LocalDateTime.now();
        Duration duracion = Duration.between(this.fechaAlquiler, ahora);
        if (duracion.toHours() > 24) {
            System.out.println("Se ha excedido el tiempo de devolucion de 48h");
        }
        return isAlquilada;
    }
}
