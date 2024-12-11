
import java.time.LocalDate;

public class Empresa {

    private String NombreEmpresa;
    private String cif;
    private LocalDate fechaFundacion;
    private int MaximoTrabajadores;
    private Trabajador [] trabajadores;

    public Empresa(String NombreEmpresa, String cif, LocalDate fechaFundacion){

        this.NombreEmpresa = NombreEmpresa;
        this.cif = cif;
        this.fechaFundacion = fechaFundacion;
        this.MaximoTrabajadores = MaximoTrabajadores;
        this.trabajadores = new Trabajador[MaximoTrabajadores];
    }

    public String getNombreEmpresa(){
        return NombreEmpresa;
    } 
    public String getCif(){
        return cif;
    }
    public LocalDate getFechaFundacion(){
        return fechaFundacion;
    }
    public int getMaximoTrabajadores(){
        return MaximoTrabajadores;
    }

    public String InfoEmpresa(){
        String InfoEmpres = String.format( 
        "\n Informacion de la Empresa\nNombre: %s, CIF: %s, Fecha Fundacion: %s, Maximo de trabajadores=100: Llevas-%s",  
        this.NombreEmpresa, this.cif, this.fechaFundacion, this.MaximoTrabajadores);
         return InfoEmpres;
    }

    public boolean RegistrarTrabajador(Trabajador nuevo){//Registro Trabajador
        if (nuevo != null) {
            for (int i = 0; i < MaximoTrabajadores; i++) {
                if (trabajadores[i].getDni().equals(nuevo.getDni())) {
                    return false;
                }
            }
            this.trabajadores[MaximoTrabajadores] = nuevo;
            MaximoTrabajadores++;
            return true;
        }
        return false;
    }
    public boolean eliminarTrabajador(Trabajador t, int numeroSS){ // elimino trabajador
        boolean isEliminated = false;
        if(this.trabajadores != null){
            this.trabajadores [MaximoTrabajadores] = null;
            for(int i = numeroSS + 1; i < numeroSS; i++){
                this.trabajadores [i-1] = this.trabajadores[i];
            }
            this.trabajadores [MaximoTrabajadores-1] = null;
            MaximoTrabajadores--;
            isEliminated = true;
            System.out.println("Trabajador eliminado con exito!");
        }
        
    return isEliminated;
    }
    public String mostrarTrabajador(){ // Muestro la informacion del trabajador
        String mostrarTrabajadores = "";
        if(trabajadores != null){   
        for(int i = 0; i < MaximoTrabajadores; i++){
            System.out.println(i + "." + trabajadores[i].InfoTrabajador());
            }
        }
        return mostrarTrabajadores;
    }





}
