import java.time.LocalDateTime;

class Videojuego extends Articulo {
    private GeneroVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Videojuego(String cod, String titulo, GeneroVideojuego genero) {
        super(cod, titulo);
        this.genero = genero;
        this.isAlquilada = false;
    }

    public void alquilar() {
        this.isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        this.isAlquilada = false;
        this.fechaAlquiler = null;
    }

    @Override
    public String toString() {
        return "Videojuego: " + titulo + " (" + genero + ")";
    }
}