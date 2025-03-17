
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class GerenteDep extends Trabajador{

    private int numTrabajadoresDep;
    private String numeroTelefono;
    private List <Trabajador> trabajadoresDep = new LinkedList<>();

    public GerenteDep(String nombre, LocalDate fechaNacimiento, String dni, String direccion, int numeroSS,
            String email, double salario, Enumerado departamento, boolean estaEnLaOficina, int numTrabajadoresDep,
            String numeroTelefono, List<Trabajador> trabajadoresDep) {
        super(nombre, fechaNacimiento, dni, direccion, email, salario, departamento, estaEnLaOficina);
        this.numTrabajadoresDep = numTrabajadoresDep;
        this.numeroTelefono = numeroTelefono;
        this.trabajadoresDep = trabajadoresDep;
    }

    public int getNumTrabajadoresDep() {
        return numTrabajadoresDep;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public List<Trabajador> getTrabajadoresDep() {
        return trabajadoresDep;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GerenteDep{");
        sb.append("Nombre=").append(getNombre());
        sb.append("Fecha de Nacimiento=").append(getFechaNacimiento());
        sb.append("DNI=").append(getDni());
        sb.append("numeroSS=").append(getNumeroSS());
        sb.append(", email=").append(getEmail());
        sb.append(", salario=").append(getSalario());
        sb.append(", departamento=").append(getDepartamento());
        sb.append(", Esta en la oficina?=").append(isEstaEnLaOficina());
        sb.append("numTrabajadoresDep=").append(numTrabajadoresDep);
        sb.append(", numeroTelefono=").append(numeroTelefono);
        sb.append(", trabajadoresDep=").append(trabajadoresDep);
        sb.append('}');
        return sb.toString();
    }


    
    

}
