import java.time.LocalDate;

public class Trabajador extends  Persona{

    protected  double numeroSS;
    protected  String email;
    protected double salario;
    protected Enumerado departamento;
    protected boolean estaEnLaOficina;
    protected double nss = 1000000000;

    public Trabajador(String nombre, LocalDate fechaNacimiento, String dni, String direccion,
        String email, double salario, Enumerado departamento, boolean estaEnLaOficina) {
        super(nombre, fechaNacimiento, dni, direccion);
        this.numeroSS = nss++;
        this.email = email;
        this.salario = 1200.49;
        this.departamento = departamento;
        this.estaEnLaOficina = estaEnLaOficina;
    }

    public double getNumeroSS() {
        return numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public double getSalario() {
        return salario;
    }

    public Enumerado getDepartamento() {
        return departamento;
    }

    public boolean isEstaEnLaOficina() {
        return estaEnLaOficina;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Treabajador{");
        sb.append("Nombre=").append(getNombre());
        sb.append("Fecha de Nacimiento=").append(getFechaNacimiento());
        sb.append("DNI=").append(getDni());
        sb.append("numeroSS=").append(numeroSS);
        sb.append(", email=").append(email);
        sb.append(", salario=").append(salario);
        sb.append(", departamento=").append(departamento);
        sb.append(", Esta en la oficina?=").append(estaEnLaOficina);
        sb.append('}');
        return sb.toString();
    }

     


}
