import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private static int contador = 0;

    private int id;
    private String titulo;
    private Enum genero;
    private String fechaRegistro;
    private String fechaBaja;
    private String fechaAlquiler;
    private boolean isAlquilada;

    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");


    public Pelicula (int id, String titulo){

        this.id = id;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDateTime.now().format(formatter);
        this.fechaBaja = LocalDateTime.now().format(formatter);
        this.isAlquilada = false;

    }

    public int getid(){
        return this.id;
    }
    
    public String getTitulo(){
        return this.titulo;
    }

    public Enum getGenero(){
        return this.genero;
    }

    public String getFechaRegistro(){
        return this.fechaRegistro;
    }

    public String getFechaBaja(){
        return this.fechaBaja;
    }
    
    public String getFechaAlquiler(){
        return this.fechaAlquiler;
    }

    public String mostrarInfoPelicula(){
        String infoPelicula = String.format("Pelicula- ID: %s, Titulo %s, Genero %s, fechaRegistro %s, fechaBaja %s, fechaAlquiler %s"
            , this.id, this.titulo, this.genero, this.fechaRegistro, this.fechaBaja, this.fechaAlquiler);
        return infoPelicula;
    }


}
