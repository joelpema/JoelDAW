
import java.time.LocalDate;

public class Trabajador {

    private static int contador = 0;

    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private int numeroSS;

    public Trabajador(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;

        this.numeroSS = this.contador;
        this.contador++;
    }
    
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getNumeroSS() {
        return numeroSS;
    }

    public String InfoTrabajador(){
        String InfoCliente = String.format( 
        "\n Informacion del Cliente\nNombre: %s, Fecha Nacimiento: %s, DNI: %s, Direccion: %s, Numero de Seguridad Social: %s",  
        this.nombre, this.fechaNacimiento, this.dni, this.direccion,this.numeroSS);
         return InfoCliente;
    }
}
