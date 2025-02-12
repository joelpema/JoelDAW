import java.util.Date;

public class Cliente extends Persona{

    private int telefono;
    private String email;
    private String direccion;

    public Cliente(String nombre, String dni, Date fechaNacimiento, int telefono, String email, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    //escribo el toString y lo corrijo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente");
        sb.append(", Nombre= ").append(getNombre());
        sb.append(", DNI= ").append(getDni());
        sb.append(", Fecha de nacimiento= ").append(getFechaNacimiento());
        sb.append(", telefono= ").append(telefono);
        sb.append(", email= ").append(email);
        sb.append("y direccion= ").append(direccion);
        return sb.toString();
    }
}
