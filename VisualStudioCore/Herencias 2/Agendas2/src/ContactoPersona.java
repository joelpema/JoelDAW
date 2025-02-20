import java.time.LocalDate;
public class ContactoPersona extends Contacto {
    private LocalDate cumpleaños;

    public ContactoPersona(String nombre, String telefono, LocalDate cumpleaños) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cumpleaños = cumpleaños;
    }

    
    /** 
     * @return LocalDate
     */
    public LocalDate getCumpleaños() {
        return cumpleaños;
    } 

    
    /** 
     * @return String
     */
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Contacto Persona \n");
        sb.append("Nombre = ").append(super.getNombre());
        sb.append(", Numero de telefono = ").append(super.getTelefono());
        sb.append(", Cumpleaños = ").append(cumpleaños);

        return sb.toString();
    }

}