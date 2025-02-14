import java.time.LocalDate;
public class Persona {

    protected String nombre;
    protected String dni;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona");
        sb.append("nombre=").append(nombre);
        sb.append(", dni=").append(dni);
        sb.append("y fechaNacimiento=").append(fechaNacimiento);
        return sb.toString();
    }

    




}
