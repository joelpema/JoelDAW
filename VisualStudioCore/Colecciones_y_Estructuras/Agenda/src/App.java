
import java.util.Scanner;
import javax.xml.crypto.AlgorithmMethod;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenido a mi nueva agenda");
        Agenda agenda = new Agenda;
        Scanner sc = new Scanner(System.in);

        String options;

        do {
            
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Visualizar agenda");
            System.out.println("5. Número de contactos de mi agenda");
            System.out.println("6. Salir");
            options = sc.nextLine();

            if(options.equals("1")){

                System.out.println("AÑADIR CONTACTO");

                if(agenda.anadeContacto()()){

                    System.out.println("CONTACTO AGREGADO");
                }else{
                    System.out.println("CONTACTO NO AGREGADO. EL CONTACTO YA EXISTIA");
                }
                System.out.println();


            }else if(options.equals("2")){


            }else if(options.equals("3")){


            }else if(options.equals("4")){


            }else if(options.equals("5")){


            }else if(options.equals("6")){


            }

        }while (!options.equals("6"));
    }
}
