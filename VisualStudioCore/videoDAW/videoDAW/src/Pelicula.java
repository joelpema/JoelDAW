import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private static int contador = 0;

    private int id;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private String fechaAlquiler;
    private boolean isAlquilada;

    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    public Pelicula (int id, String titulo){

        this.id = id;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
        this.fechaAlquiler = fechaAlquiler;
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

    public LocalDate getFechaRegistro(){
        return this.fechaRegistro;
    }

    public LocalDate getFechaBaja(){
        return this.fechaBaja;
    }
    
    public String getFechaAlquiler(){
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
    public LocalDate PAlquilada(){
        this.fechaAlquiler = LocalDateTime.now().format(formatter);

    }
}

