
import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable{
    

    private static final long serialVersionUID = 1702410486215217110L;

    private String isbn;
    private String titulo;
    private String Autor;
    private LocalDate fechaPublicacion;

    public Libro(String isbn, String titulo, String autor, LocalDate fechaPublicacion) {
    
    
    this.isbn = isbn;
        this.titulo = titulo;
        Autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro{");
        sb.append("isbn=").append(isbn);
        sb.append(", titulo=").append(titulo);
        sb.append(", Autor=").append(Autor);
        sb.append(", fechaPublicacion=").append(fechaPublicacion);
        sb.append('}');
        return sb.toString();
    }

    


}
