
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String NombreEmpresa;
    private String cif;
    private LocalDate fechafundacion;
    private List <Trabajador> gestionTrabajadores = new LinkedList<>();
    private List <GerenteDep> gestionGerentes = new LinkedList<>();
    private List <Director> gestionDirector = new LinkedList<>();

    public Empresa(String nombreEmpresa, String cif, LocalDate fechafundacion, List<Trabajador> gestionTrabajadores,List<GerenteDep> gestionGerentes, List<Director> gestionDirector) {
        this.NombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fechafundacion = fechafundacion;
        this.gestionTrabajadores = gestionTrabajadores;
        this.gestionGerentes = gestionGerentes;
        this.gestionDirector = gestionDirector;
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

    public List<GerenteDep> getGestionGerentes() {
        return gestionGerentes;
    }

    public List<Director> getGestionDirector() {
        return gestionDirector;
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

    public boolean registrarGerente(GerenteDep gerente) throws ClienteYaRegistradoException{
        for (Persona c : gestionGerentes) {
            if(gerente.getDni().equals(c.getDni())){
                throw new ClienteYaRegistradoException("Ya existe un trabajador registrado con el dni: " + gerente.getDni() + ".");
            }
        }
        gestionGerentes.add(gerente);
        return true;
    }
    public boolean registrarDirector(Director director) throws ClienteYaRegistradoException{
        for (Persona c : gestionDirector) {
            if(director.getDni().equals(c.getDni())){
                throw new ClienteYaRegistradoException("Ya existe un trabajador registrado con el dni: " + director.getDni() + ".");
            }
        }
        gestionDirector.add(director);
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

    

    

}
