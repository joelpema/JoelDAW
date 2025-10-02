import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private static int contador = 0;

    private int id;
    private String titulo;
    private Genero genero;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    public Pelicula (int id, String titulo, Genero genero){

        this.id = this.contador;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDateTime.now();
        this.isAlquilada = false;
    }

    public int getIdPelicula(){
        return this.id;
    }
    
    public String getTitulo(){
        return this.titulo;
    }

    public Genero getGenero(){
        return this.genero;
    }

    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public LocalDateTime getFechaBaja(){
        return this.fechaBaja;
    }
    
    public LocalDateTime setFechaAlquiler(){
        return this.fechaAlquiler;
    }
    public boolean isAlquilada(){
        return isAlquilada;
    }

    public String mostrarInfoPelicula(){
        String infoPelicula = String.format("Pelicula- ID: %s, Titulo %s, Genero %s, fechaRegistro %s, fechaBaja %s, fechaAlquiler %s"
            , this.id, this.titulo, this.genero, this.fechaRegistro, this.fechaBaja, this.fechaAlquiler);
        return infoPelicula;
    }
    public String PAlquilada(){
        String PAlquilada = String.format("El Codigo de la pelicula es %s", this.id);
        return PAlquilada;
    }

    public boolean Alquilado(){
        this.isAlquilada = true;
        return this.isAlquilada;
    }
    public boolean Devolucion(){
        this.isAlquilada = false;
        return this.isAlquilada;
    }

}

