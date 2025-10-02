import java.time.LocalDateTime;

class Pelicula extends Articulo {
    private GeneroPelicula genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String cod, String titulo, GeneroPelicula genero) {
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
        return "Pelicula: " + titulo + " (" + genero + ")";
    }

}