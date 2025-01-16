
public class ContactoPersona extends Contacto {
    private String cumpleaños;

    public ContactoPersona(String nombre, String telefono, String cumpleaños) {
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    public String getCumpleaños() {
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