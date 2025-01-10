import java.time.LocalDateTime;

public class gato extends Mascotas{

    private String Color;
    private boolean peloLargo = false;

    public gato(String Nombre, double Edad, boolean Estado, LocalDateTime FechaDeNacimiento, String Color, boolean peloLargo) {

        super(Nombre, Edad, Estado, FechaDeNacimiento);

        this.Color = Color;
        this.peloLargo = peloLargo;
    }

    public String getColor() {
        return Color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAstro\n");
        sb.append("Nombre de la mascota= ").append(super.getNombre());
        sb.append(", Edad de la mascota= ").append(super.getEdad());
        sb.append(", Estado de la mascota= ").append(super.isEstado());
        sb.append(", Fecha de nacimiento de la mascota= ").append(super.getFechaDeNacimiento());
        sb.append("Nombre de la mascota= ").append(Color);
        sb.append(", Edad de la mascota= ").append(peloLargo);
        
        return sb.toString();
    }


}
