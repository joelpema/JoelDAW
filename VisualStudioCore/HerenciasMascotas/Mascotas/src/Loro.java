import java.time.LocalDateTime;

public class Loro extends Aves{

    private String Origen;
    private boolean Habla = false;

    public Loro(String Nombre, double Edad, boolean Estado, LocalDateTime FechaDeNacimiento, boolean pico, boolean vuela, String Origen, boolean habla) {

        super(Nombre, Edad, Estado, FechaDeNacimiento,pico,vuela);

        this.Origen = Origen;
        this.Habla = habla;
    }

    public String getOrigen() {
        return Origen;
    }

    public boolean isHabla() {
        return Habla;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAstro\n");
        sb.append("Nombre de la mascota= ").append(super.getNombre());
        sb.append(", Edad de la mascota= ").append(super.getEdad());
        sb.append(", Estado de la mascota= ").append(super.isEstado());
        sb.append(", Fecha de nacimiento de la mascota= ").append(super.getFechaDeNacimiento());
        sb.append("Nombre de la mascota= ").append(super.isPico());
        sb.append(", Edad de la mascota= ").append(super.isVuela());
        sb.append("Nombre de la mascota= ").append(Origen);
        sb.append(", Edad de la mascota= ").append(Habla);
        
        return sb.toString();
    }

}
