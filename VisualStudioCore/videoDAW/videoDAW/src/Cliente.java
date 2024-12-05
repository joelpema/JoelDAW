import java.time.format.DateTimeFormatter;

public class Cliente {

    private int contador = 0;

    private String id;
    private String nombre;
    private String DNI;
    private String direccion;
    private String fechaNacimiento;
    private int peliculasAlquiladas;
    private Pelicula [] peliculas;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    public Cliente(String id, String nombre, String DNI, String direccion, String fechaNacimiento) {

        this.id = "RE-" + this.contador;
        this.contador++;

        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasAlquiladas = 0;   
        this.peliculas = new Pelicula[100];
    }    

    public String getId() {
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

    public void anadirPelicula(Pelicula p) {
        if(p != null){
            this.peliculas[peliculasAlquiladas] = p;
            peliculasAlquiladas++;
        }
    }    

    public void eliminarPelicula(Pelicula p){
        if(p != null){
            this.peliculas[peliculasAlquiladas] = null;
            peliculasAlquiladas--;
        }
    }

    public void enseñarPeliculas(){
        System.out.println("las Peliculas que hay son: ");
        for (int i = 0; 1 < peliculasAlquiladas; i++){
            System.out.println(peliculas[i].mostrarInfoPelicula());
        }
    }
    
    
}