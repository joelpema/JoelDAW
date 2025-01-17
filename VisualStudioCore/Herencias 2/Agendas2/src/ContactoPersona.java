
import java.time.LocalDate;

public class ContactoPersona extends Contacto {
    private LocalDate cumpleaños;

    public ContactoPersona(String nombre, String telefono, LocalDate cumpleaños) {
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    public LocalDate getCumpleaños() {
        return cumpleaños;
    } 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Agenda \n");
        sb.append("Nombre = ").append(super.getNombre());
        sb.append(", Numero de telefono = ").append(super.getTelefono());
        sb.append(", Cumpleaños = ").append(cumpleaños);

        return sb.toString();
    }

}