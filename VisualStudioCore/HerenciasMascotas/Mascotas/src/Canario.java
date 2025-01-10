import java.time.LocalDateTime;

public class Canario extends Aves{

    private String Color;
    private boolean Canta = false;

    public Canario(String Nombre, double Edad, boolean Estado, LocalDateTime FechaDeNacimiento, boolean pico, boolean vuela, String Color, boolean Canta) {

        super(Nombre, Edad, Estado, FechaDeNacimiento,pico,vuela);

        this.Color = Color;
        this.Canta = Canta;
    }

    public String getColor() {
        return Color;
    }

    public boolean isCanta() {
        return Canta;
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
        sb.append("Nombre de la mascota= ").append(Color);
        sb.append(", Edad de la mascota= ").append(Canta);
        
        return sb.toString();
    }

}
