
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
        Empresa empresa = null;
        Trabajador trabajadores = null;
        GerenteDep gerentes = null;
        Director director = null;

        boolean estaEnLaOficina = true;
        System.out.println("Crear una empresa");
        System.out.println("Escribe el nombre de la empresa");
        String nombreEmpresa = sc.nextLine();
        String cif = MyUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF de la empresa");
        System.out.println("Escribe la fecha de la fundacion");
        LocalDate fecha1 = MyUtils.leerFecha();

        Empresa e = new Empresa(nombreEmpresa, cif, fecha1, null);

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

                System.out.println("1. Registrar director");
                System.out.println("2. Registrar Gerente de Departamento");
                System.out.println("3. Registrar Trabajador normal");
                System.out.println("4. Salir");
                opcion2 = sc.nextLine();
                do {
                    if(opcion2.equals("1")){

                        int Ndirector = 0;
                        if (Ndirector != 0){
                            System.out.println("solo puedes registrar 1 director");
                        }else {
                            System.out.println("Escribe su Nombre");
                            String nombre = sc.nextLine();
                            System.out.println("Escribe su fecha de nacimiento");
                            LocalDate fecha = MyUtils.leerFecha();
                            String dni = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del Director");
                            System.out.println("Escribe la direccion");
                            String direccion = sc.nextLine();
                            System.out.println("Escribe el eMail");
                            String email = sc.nextLine();
                            Enumerado enumerado = MyUtils.menuEnumerado();
                            System.out.println("Escribe su numero de telefono");
                            String numeroTelefono = MyUtils.comprobarPatronRepetidamente(patronTelefono, "Introduce el telefono del trabajador");
                            estaEnLaOficina = true;
                            Ndirector++;

                            Director d = new Director(nombre, fecha, dni, direccion, 0000000001, email, 4000, enumerado, estaEnLaOficina, numeroTelefono, false, true);
                            director = d;
                        }



                    }else if(opcion2.equals("2")){
                        
                        int Ngerente = 0;
                        if (Ngerente != 2){
                            System.out.println("solo puedes registrar 1 director");
                        }else {
                        System.out.println("Escribe su Nombre");
                        String nombre = sc.nextLine();
                        System.out.println("Escribe su fecha de nacimiento");
                        LocalDate fecha = MyUtils.leerFecha();
                        String dni = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del trabajador");
                        System.out.println("Escribe la direccion");
                        String direccion = sc.nextLine();
                        System.out.println("Escribe el eMail");
                        String email = sc.nextLine();
                        Enumerado enumerado = MyUtils.menuEnumerado();
                        System.out.println("Escribe su numero de telefono");
                        String numeroTelefono = MyUtils.comprobarPatronRepetidamente(patronTelefono, "Introduce el telefono del trabajador");
                        Ngerente++;
                        }

                    }else if(opcion2.equals("3")){
                        
                        System.out.println("Escribe su Nombre");
                        String nombre = sc.nextLine();
                        System.out.println("Escribe su fecha de nacimiento");
                        LocalDate fecha = MyUtils.leerFecha();
                        String dni = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del trabajador");
                        System.out.println("Escribe la direccion");
                        String direccion = sc.nextLine();
                        System.out.println("Escribe el eMail");
                        String email = sc.nextLine();
                        Enumerado enumerado = MyUtils.menuEnumerado();

                        Trabajador t = new Trabajador(nombre, fecha, dni, direccion, email, 1200, enumerado, false);
                        trabajadores = t;
                        
                        System.out.println(trabajadores.toString());
                        
                    }else {
                        System.out.println("Escribe una opcion correcta en el menu");
                    }
                }while (!opcion2.equals("4"));

            }else if(opcion.equals("2")){

                empresa.toString();
                System.out.println("\nTrabajadores\n");
                trabajadores.toString();
                System.out.println("\nGerentes\n");
                gerentes.toString();
                System.out.println("\nDirector\n");
                director.toString();


                
            }else if(opcion.equals("3")){

                trabajadores.toString();

            }else if(opcion.equals("4")){



            }else if(opcion.equals("5")){

                if(empresa != null && trabajadores != null){
                    sc = new Scanner (System.in);
                    System.out.println("Selecciona el numero del trabajador que quieres hechar");
                    System.out.println(trabajadores.toString());
                    int Nss = sc.nextInt();
                    
                }


            }else if (opcion.equals("6")){

                do { 
                    System.out.println("Agenda director");

                    System.out.println("1. Reunion");
                    System.out.println("2. Fuera de la oficina");
                    System.out.println("3. Convocar a toda la empres");
                    System.out.println("4. Salir");
                    opcion3 = sc.nextLine();

                    if (opcion3.equals("1")){
                        System.out.println("han acudido a la reunion");
                        trabajadores.toString();
                        gerentes.toString();
                    }else if (opcion3.equals("2")){
                        System.out.println("¿esta fuera de la oficina? s/n");
                        String fuera = sc.nextLine();
                        if (fuera == "s"){
                            estaEnLaOficina = false;
                        }else if (fuera == "n"){
                            estaEnLaOficina = true;
                        }
                    }else if (opcion3.equals("3")){
                        if (estaEnLaOficina == true){
                            System.out.println("se llamara a todo el personal el dia...");
                            LocalDate fecha = MyUtils.leerFecha();

                        }

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



