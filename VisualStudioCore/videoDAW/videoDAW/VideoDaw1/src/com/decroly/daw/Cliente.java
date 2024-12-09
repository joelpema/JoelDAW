package com.decroly.daw;

import java.time.LocalDate;

public class Cliente {
    private static int contador = 0;

    
    private String dni;
    private String nombre;
    private int cod;
    private String direccion;
    private LocalDate FechaNacimiento;
    private LocalDate fechaBaja;
    private int nAlquiladas;

    private int nPelicula;
    private Pelicula [] peliculasCliente;

    
    public Cliente(String dni, String nombre, String direccion, LocalDate nacimiento){
        this.cod = this.contador;
        this.contador++;

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.FechaNacimiento = nacimiento;
        this.nAlquiladas = 0;
        this.peliculasCliente = new Pelicula[100];
        this.nPelicula = 0;
        this.fechaBaja = fechaBaja;
    }
    
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCod() {
        return cod;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }
    public LocalDate getBaja() {
        return fechaBaja;
    }
    public int getNAlquiladas() {
        return nAlquiladas;
    }

    public int getNpeliculas(){
        return nPelicula;
    }
    

    public String InfoCliente(){
        String getInfoCliente = String.format( 
        "\nDNI: %s, Nombre: %s, Codigo: Soc-%s, Direccion: %s, F.Nacimiento %s, Nº Alquiladas %s",  
        this.dni, this.nombre, this.cod, this.direccion, this.FechaNacimiento, this.nAlquiladas );
        return getInfoCliente + "\n";
    }

    public String mostrarPeliculas(){ 
        String peliculasAlquiladas = "";
        for(int i = 0; i < nPelicula; i++){
           peliculasAlquiladas += peliculasCliente[i].InfoPelicula();
           }
       return peliculasAlquiladas;
    }


    public boolean addPelicula(Pelicula p){
        boolean isAdd = false;
        if (p != null){
            this.peliculasCliente[nPelicula] = p;
            nAlquiladas++;
            nPelicula++;
        }
        return isAdd;
    }

    public boolean elimPelicula(Pelicula p){
        boolean isEliminated = false;
        if (p != null){
            nAlquiladas--;
        }
        return isEliminated;
    }

    public LocalDate baja(){
        LocalDate fechaBaja = LocalDate.now();
        return fechaBaja;
    }
}