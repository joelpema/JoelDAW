import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        Scanner sc = new Scanner(System.in);
        String opcion = "";
        String opcion2 = "";
        String opcion3 = "";

        final String patrondni = "[0-9]{8}[A-Z]{1}";
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patronTelefono = "[6,7,9]{1} [0-9]{8}";

        System.out.println("Crear una empresa");
        System.out.println("Escribe el nombre de la empresa");
        String nombreEmpresa = sc.nextLine();
        String cif = MiUtils.comprobarPatronRepetidamente(patroncif, "introduce el CIF de la empresa");
        System.out.println("Escribe la fecha de la fundacion");
        LocalDate fecha1 = MiUtils.leerFecha();




    do { 
        sc = new Scanner(System.in);

        System.out.println("1. Registrar trabajador en empresa: ");
        System.out.println("2. Mostrar información general de la empresa, con todos los trabajadores, gerentes y director.");
        System.out.println("3. Mostrar el número de trabajadores actuales y el organigrama de la empresa.");
        System.out.println("4. Mostrar información de un departamento");
        System.out.println("5. Eliminar trabajador de la empresa");
        System.out.println("6. Agenda Director");
        System.out.println("7. salir de la aplicacion");
        opcion = sc.nextLine();

        if(opcion.equals("1")){

            do {
                System.out.println("1. Registrar director");
                System.out.println("2. Registrar Gerente de Departamento");
                System.out.println("3. Registrar Trabajador normal");
                System.out.println("4. Salir");
                opcion2 = sc.nextLine();

                if(opcion2.equals("1")){
                    String nombre = MiUtils.leerTextoPantalla("escribe el nombre");
                    

                }else if(opcion2.equals("2")){
                    


                }else if(opcion2.equals("3")){
                    

                    
                }else {
                    System.out.println("Escribe una opcion correcta en el menu");
                }
            }while (!opcion2.equals("4"));

        }else if(opcion.equals("2")){


            
        }else if(opcion.equals("3")){



        }else if(opcion.equals("4")){



        }else if(opcion.equals("5")){



        }else if (opcion.equals("6")){

            do { 

                System.out.println("1. Reunion");
                System.out.println("2. Fuera de la oficina");
                System.out.println("3. Convocar a toda la empres");
                System.out.println("4. Salir");
                opcion3 = sc.nextLine();

                if (opcion3.equals("1")){

                }else if (opcion3.equals("2")){

                }else if (opcion3.equals("3")){

                } else {
                    System.out.println("Escribe una opcion correcta en el menu");
                }


            } while (opcion3.equals("4"));

        }else if (opcion.equals("7")){
            System.out.println("¡¡Hasta la proxima!!");
        }else {
            System.out.println("Escribe una opcion correcta en el menu");
        }


    } while (!opcion.equals("7"));


    }
}