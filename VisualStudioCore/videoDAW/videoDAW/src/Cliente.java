import java.time.format.DateTimeFormatter;

public class Cliente {

    private int contador = 0;

    private int id;
    private String nombre;
    private String DNI;
    private String direccion;
    private String fechaNacimiento;
    private int peliculasAlquiladas;
    private Pelicula [] peliculas;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    public Cliente(int id, String nombre, String DNI, String direccion, String fechaNacimiento) {

        this.id = id;
        this.contador++;

        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasAlquiladas = 0;   
        this.peliculas = new Pelicula[100];
    }    

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDNI() {
        return DNI;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public int getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public String mostrarInfoCliente(){
        String infoCliente = String.format("Cliente- ID_Cliente: %s, Nombre: %s, DNI: %s, Direccion %s, FechaNacimiento: %s, PeliculasAlquiladas %s",
        this.id, this.nombre, this.DNI, this.direccion, this.fechaNacimiento, this.peliculasAlquiladas);
        return infoCliente;
    }



}
