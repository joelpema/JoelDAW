
import java.util.Scanner;

public class ProgramaAgenda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do{
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Verificar existencia de contacto");
            System.out.println("5. Listar todos los contactos");
            System.out.println("6. Salir");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {




            } else if (opcion.equals("2")) {  
            
                
            } else if (opcion.equals("3")) {  
                
                
            } else if (opcion.equals("4")) {  
                
            } else if (opcion.equals("5")) {  


            } else if (opcion.equals("6")){
            
            }  else {
                System.out.println("pon una opcion que sea correcta en el menu");
            }

        } while (!opcion.equals("6"));
    }

}   

