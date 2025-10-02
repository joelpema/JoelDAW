import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private List<Articulo> articulosRegistrados = new ArrayList<>();
    private List<Cliente> clientesRegistrados = new ArrayList<>();

    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public List<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void registrarArticulo(Articulo articulo) {
        articulosRegistrados.add(articulo);
    }

    
    public void registrarCliente(Cliente cliente) {
        for (Cliente c : clientesRegistrados) {
            if (c.dni.equals(cliente.dni)) {
                throw new IllegalArgumentException("Cliente ya registrado");
            }
        }
        clientesRegistrados.add(cliente);
    }

    public void alquilarArticulo(Cliente cliente, Articulo articulo) {
        if (articulo instanceof Pelicula) {
            ((Pelicula) articulo).alquilar();
        } else if (articulo instanceof Videojuego) {
            ((Videojuego) articulo).alquilar();
        }
        cliente.alquilarArticulo(articulo);
    }

    public void devolverArticulo(Cliente cliente, Articulo articulo) {
        if (articulo instanceof Pelicula) {
            ((Pelicula) articulo).devolver();
        } else if (articulo instanceof Videojuego) {
            ((Videojuego) articulo).devolver();
        }
        cliente.devolverArticulo(articulo);
    }

    public void mostrarInfoVideoClub() {
        System.out.println("VideoDaw: " + direccion + " (CIF: " + cif + ")");
    }
}
