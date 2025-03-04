
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Videojuego extends Articulo {
    
    private Genero_Videojuegos genero;
    private LocalDateTime fechaAlquiler;
    private boolean alquilada;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
    
    public Videojuego(String titulo, Genero_Videojuegos genero) {
        super(titulo);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.alquilada = alquilada;
    }

    public Genero_Videojuegos getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean alquilada() {
        return alquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.alquilada = isAlquilada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Videojuego: ");
        sb.append("cod: ").append(cod);
        sb.append(" ,titulo: ").append(titulo);
        sb.append(" ,genero: ").append(genero);
        sb.append('.' + "\n");
        return sb.toString();
    }
}