import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Cliente extends Persona {
    private String numSocio;
    private LocalDate fechaBaja;
    private List<Articulo> articulosAlquilados = new ArrayList<>();

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.fechaBaja = null;
        this.articulosAlquilados = new ArrayList<>();
    }
    
    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public List<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }



    public void alquilarArticulo(Articulo articulo) {
        articulosAlquilados.add(articulo);
    }

    public void devolverArticulo(Articulo articulo) {
        articulosAlquilados.remove(articulo);
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (" + numSocio + ")";
    }
}