import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ProgramaAgenda {

    
    /**
     * @param args
     */
    
    public static void main(String[] args) {

        Agenda array = new Agenda();

        Scanner sc = new Scanner(System.in);
        String opcion;
        
        
        do{
            System.out.println("\nMenú de opciones: recuerda puedes añadir hasta 30 contactos");
            System.out.println("1. Añadir contacto Persona");
            System.out.println("2. Añadir contacto Empresa");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Verificar existencia");
            System.out.println("6. Listar todos los contactos");
            System.out.println("7. Salir");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {

                System.out.print("Introduce el nombre de la persona: ");
                    String nombrePersona = sc.nextLine();
                    System.out.print("Introduce el teléfono de la persona: ");
                    String telefonoPersona = sc.nextLine();

                    LocalDate cumpleaños = MyUtils.leerFecha();

                    LocalDate hoy = LocalDate.now();
					Period Edad = Period.between(cumpleaños, hoy);

                    ContactoPersona nuevaPersona = new ContactoPersona(nombrePersona, telefonoPersona, cumpleaños);
                    if (array.añadirContacto(nuevaPersona)) {
                        System.out.println("Contacto de persona añadido correctamente.");
                    }

            } else if (opcion.equals("2")) {     
            
                System.out.print("Introduce el nombre de la Empresa: ");
                    String nombrePersonaE = sc.nextLine();
                    System.out.print("Introduce el teléfono de la Empresa: ");
                    String telefonoPersonaE = sc.nextLine();
                    System.out.println("Introduce la pagina web de la Empresa");
                    String paginaWeb = sc.nextLine();

                    ContactoEmpresa nuevaEmpresa = new ContactoEmpresa(nombrePersonaE, telefonoPersonaE, paginaWeb);
                    if (array.añadirContacto(nuevaEmpresa)) {
                        System.out.println("Contacto de persona añadido correctamente.");
                    }

            } else if (opcion.equals("3")) {  
                
                System.out.print("Introduce el nombre del contacto a eliminar: ");
                String nombreEliminar = sc.nextLine();
                if (array.eliminarContacto(nombreEliminar)) {
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el contacto.");
                }
                
            } else if (opcion.equals("4")) {  
                
                System.out.print("Introduce el nombre del contacto a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    int posicion = array.buscaContacto(nombreBuscar);
                    if (posicion != -1) {
                        System.out.println("Contacto encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                
            } else if (opcion.equals("5")) { 

                System.out.print("Introduce el nombre del contacto a verificar: ");
                    String nombreVerificar = sc.nextLine();
                    if (array.existeContacto(nombreVerificar)) {
                        System.out.println("El contacto existe.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                
            } else if (opcion.equals("6")) {  

                array.listaContactos();

            } else if (opcion.equals("7")){
            
                System.out.println("Hasta luego!! \nsaliendo del programa...");
                
            }  else {
                System.out.println("pon una opcion que sea correcta en el menu");
            }

        } while (!opcion.equals("7"));
    }

}   

