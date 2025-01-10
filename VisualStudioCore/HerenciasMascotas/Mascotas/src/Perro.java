import java.time.LocalDateTime;

public class Perro extends Mascotas{

    private Razas perros;
    private boolean pulgas = false;
    
    public Perro(String Nombre, double Edad, boolean Estado, LocalDateTime FechaDeNacimiento, Razas perros, boolean pulgas) {

        super(Nombre, Edad, Estado, FechaDeNacimiento);

        this.perros = perros;
        this.pulgas = pulgas;
    }

    public Razas getPerros() {
        return perros;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAstro\n");
        sb.append("Nombre de la mascota= ").append(super.getNombre());
        sb.append(", Edad de la mascota= ").append(super.getEdad());
        sb.append(", Estado de la mascota= ").append(super.isEstado());
        sb.append(", Fecha de nacimiento de la mascota= ").append(super.getFechaDeNacimiento());
        sb.append("Nombre de la mascota= ").append(perros);
        sb.append(", Edad de la mascota= ").append(pulgas);
        
        return sb.toString();
    }

    


}
