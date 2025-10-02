import java.time.LocalDate;

public class Director extends Trabajador{

    private String numeroTelefono;
    private boolean estaReunido;
    private boolean fueraOficina;
    
    public Director(String nombre, LocalDate fechaNacimiento, String dni, String direccion, int numeroSS, String email,
            double salario, Enumerado departamento, boolean estaEnLaOficina, String numeroTelefono, boolean estaReunido,
            boolean fueraOficina) {
        super(nombre, fechaNacimiento, dni, direccion, email, salario, departamento, estaEnLaOficina);
        this.numeroTelefono = numeroTelefono;
        this.estaReunido = estaReunido;
        this.fueraOficina = fueraOficina;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isEstaReunido() {
        return estaReunido;
    }

    public void setEstaReunido(boolean estaReunido) {
        this.estaReunido = estaReunido;
    }

    public boolean isFueraOficina() {
        return fueraOficina;
    }

    public void setFueraOficina(boolean fueraOficina) {
        this.fueraOficina = fueraOficina;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Director{");
        sb.append("Nombre=").append(getNombre());
        sb.append("Fecha de Nacimiento=").append(getFechaNacimiento());
        sb.append("DNI=").append(getDni());
        sb.append("numeroSS=").append(getNumeroSS());
        sb.append(", email=").append(getEmail());
        sb.append(", salario=").append(getSalario());
        sb.append(", departamento=").append(getDepartamento());
        sb.append(", Esta en la oficina?=").append(isEstaEnLaOficina());
        sb.append("numeroTelefono=").append(numeroTelefono);
        sb.append(", estaReunido=").append(estaReunido);
        sb.append(", fueraOficina=").append(fueraOficina);
        sb.append('}');
        return sb.toString();
    }

    


}
