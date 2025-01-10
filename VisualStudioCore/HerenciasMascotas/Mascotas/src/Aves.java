import java.time.LocalDateTime;

public class Aves extends Mascotas{

    private boolean pico = false;
    private boolean vuela = false;

    public Aves(String Nombre, double Edad, boolean Estado, LocalDateTime FechaDeNacimiento, boolean pico, boolean vuela) {

        super(Nombre, Edad, Estado, FechaDeNacimiento);

        this.pico = pico;
        this.vuela = vuela;
    }

    public boolean isPico() {
        return pico;
    }

    public boolean isVuela() {
        return vuela;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAstro\n");
        sb.append("Nombre de la mascota= ").append(super.getNombre());
        sb.append(", Edad de la mascota= ").append(super.getEdad());
        sb.append(", Estado de la mascota= ").append(super.isEstado());
        sb.append(", Fecha de nacimiento de la mascota= ").append(super.getFechaDeNacimiento());
        sb.append("Nombre de la mascota= ").append(pico);
        sb.append(", Edad de la mascota= ").append(vuela);
        
        return sb.toString();
    }


    
}
