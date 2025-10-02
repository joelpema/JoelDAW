import java.time.LocalDate;

abstract class Articulo {
    protected String cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;

    public Articulo(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = null;
    }

    public String getCod() {
        return cod;
    }

    public abstract String toString();
}
