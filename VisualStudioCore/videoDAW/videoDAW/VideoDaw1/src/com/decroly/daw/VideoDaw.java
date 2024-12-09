package com.decroly.daw;
import java.time.LocalDate;

public class VideoDaw {
    
    private String cif;
    private String direccion;
    private LocalDate FechaAlta;
    private int nPeliculas;
    private int nClientes;
    
    private Cliente [] clientes;
    private Pelicula [] peliculas;

    
    public VideoDaw(String cif, String direccion){
        this.cif = cif;
        this.direccion = direccion;
        this.FechaAlta = LocalDate.now();
        this.peliculas = new Pelicula[100];
        this.nPeliculas = 0;
        this.clientes = new Cliente[100];
        this.nClientes = 0;
    }

    public String getCif() {
        return cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaAlta() {
        return FechaAlta;
    }
    public int getNpeliculas() {
        return nPeliculas;
    }
    public int getNclientes() {
        return nClientes;
    }


    public boolean nuevoCliente(Cliente nuevo){
        if (nuevo != null) {
            for (int i = 0; i < nClientes; i++) {
                if (clientes[i].getDni().equals(nuevo.getDni())) {
                    return false;
                }
            }
            this.clientes[nClientes] = nuevo;
            nClientes++;
            return true;
        }
        return false;
    }

    public boolean nuevaPelicula(Pelicula nueva){
        boolean isAdd = false;
        if (nueva != null){
            this.peliculas [nPeliculas] = nueva;
            nPeliculas++;
        }
        return isAdd;
    }

    public String InfoVideoDaw(){
        String getInfoVideoDaw = String.format("INFO DEL VIDEOCLUB" +
        "\nCif: %s, Direccion: %s, Fecha de alta: %s, Nº de Peliculas: %s, Nº de clientes %s", 
        this.cif, this.direccion, this.FechaAlta, this.nPeliculas, this.nClientes);
        return getInfoVideoDaw;
    }

    public String mostrarPeliculas(){
     String peliculasDisponibles = "";
     for(int i = 0; i < nPeliculas; i++){
        System.out.println(i + "." + peliculas[i].InfoPelicula());
        }
    return peliculasDisponibles;
    }

    public String mostrarPeliculasNoAlquiladas(){
        String peliculasNoAlquiladas = "";
        if(nPeliculas > 0){
        for(int i = 0; i < nPeliculas; i++){
            if (peliculas[i].isAlquilada() == false){
                peliculasNoAlquiladas += (peliculas[i].InfoPelicula());
            }
        }
        }else{
            peliculasNoAlquiladas = "No hay peliculas en el videoclub";
        }
    return peliculasNoAlquiladas;
    }

    public String mostrarClientes(){ 
        String mostrarClientes = "";
        if(clientes != null){   
        for(int i = 0; i < nClientes; i++){
            System.out.println(i + "." + clientes[i].InfoCliente());
            }
        }
        return mostrarClientes;
    }


    public Pelicula PeliculaPorPosicion(int i){
        return this.peliculas[i];
    } 

    public Cliente ClientePorPosicion(int i){
        return this.clientes[i];
    }

  

    public boolean alquilarPelicula(int c, int p){
        this.ClientePorPosicion(c);
        this.PeliculaPorPosicion(p).Alquiler();
        boolean isAdd = false;
        return isAdd;
    }

    public boolean devolverPelicula(int c, int p){
        this.ClientePorPosicion(c);
        this.PeliculaPorPosicion(p).devolver();
        boolean isEliminated = false;
        return isEliminated;
    }

    public boolean BajaCliente(Cliente c, int numSocio){
        boolean isEliminated = false;
        if(this.clientes != null){
            this.clientes [numSocio] = null;
            for(int i = numSocio + 1; i < nClientes; i++){
                this.clientes [i-1] = this.clientes[i];
            }
            this.clientes [nClientes-1] = null;
            nClientes--;
            isEliminated = true;
            System.out.println("Cliente eliminado");
        }
        
    return isEliminated;
    }

    public boolean BajaPelicula(Pelicula p, int cod){
        boolean isEliminated = false;
        if (cod >= 0 && cod < nPeliculas) {
            this.peliculas [cod] = null;
            
            for(int i = cod + 1; i < nPeliculas; i++){
                this.peliculas [i-1] = this.peliculas[i];
            }
            this.peliculas [nPeliculas-1] = null;
            nPeliculas--;
            isEliminated = true;
            System.out.println("Pelicula eliminada");
        }
    return isEliminated;
    }
}
