
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String NombreEmpresa;
    private String cif;
    private LocalDate fechafundacion;
    private List <Trabajador> gestionTrabajadores;
    

    public Empresa(String nombreEmpresa, String cif, LocalDate fechafundacion, List<Trabajador> gestionTrabajadores) {
        this.NombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fechafundacion = fechafundacion;
        this.gestionTrabajadores = new LinkedList<>();

    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechafundacion() {
        return fechafundacion;
    }

    public List<Trabajador> getGestionTrabajadores() {
        return gestionTrabajadores;
    }

    public boolean registrarTrabajador(Trabajador trabajador) throws ClienteYaRegistradoException{
        for (Persona c : gestionTrabajadores) {
            if(trabajador.getDni().equals(c.getDni())){
                throw new ClienteYaRegistradoException("Ya existe un trabajador registrado con el dni: " + trabajador.getDni() + ".");
            }
        }
        gestionTrabajadores.add(trabajador);
        return true;
    }

    public String darBajaCliente(int numeroSS){  
        for (Trabajador trabaja : gestionTrabajadores) {
            if (trabaja.getNumeroSS() == numeroSS) {
                gestionTrabajadores.remove(trabaja);
                return trabaja.toString();
            }
        }
        return gestionTrabajadores.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{");
        sb.append("NombreEmpresa=").append(NombreEmpresa);
        sb.append(", cif=").append(cif);
        sb.append(", fechafundacion=").append(fechafundacion);
        sb.append(", gestionTrabajadores=").append(gestionTrabajadores);
        sb.append('}');
        return sb.toString();
    }

    

    

}
