
import java.time.LocalDate;

public class Persona {

    protected String Nombre;
    protected LocalDate fechaNacimiento;
    protected String dni;
    protected String direccion;


    public Persona(String nombre, LocalDate fechaNacimiento, String dni, String direccion) {
        Nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }


    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("Nombre=").append(Nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", dni=").append(dni);
        sb.append(", direccion=").append(direccion);
        sb.append('}');
        return sb.toString();
    }

}
