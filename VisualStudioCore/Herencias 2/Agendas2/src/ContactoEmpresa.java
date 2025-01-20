public class ContactoEmpresa extends Contacto{
    private String paginaWeb;

    public ContactoEmpresa(String nombre, String telefono, String paginaWeb){
        this.nombre = nombre;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Agenda \n");
        sb.append("Nombre = ").append(super.getNombre());
        sb.append(", Numero de telefono = ").append(super.getTelefono());
        sb.append(", Pagina Web: ").append(paginaWeb);
        
        return sb.toString();
    }   
}