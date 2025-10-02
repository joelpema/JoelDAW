import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    
            Scanner sc = new Scanner(System.in);

<<<<<<< Updated upstream
            // Ejercicio 1
            int valor = 0;


            try {
                System.out.println("introduce el valor que quieres darle a esta variable");
                valor = sc.nextInt();
                System.out.println("El valor introducido es " + valor);
            }catch (InputMismatchException e){ 
                System.out.println("valor introducido incorrecto");
            }
=======
        // Ejercicio 1
        int valor = 0;


        try {
            System.out.println("introduce el valor que quieres darle a esta variable");
            valor = sc.nextInt();
            System.out.println("El valor introducido es " + valor);
        }catch (InputMismatchException e){ 
            System.out.println("valor introducido incorrecto");
        }
>>>>>>> Stashed changes

            // Ejercicio 2

<<<<<<< Updated upstream
            sc = new Scanner(System.in);

            int valorA = 0;
            int valorB = 0;
            int resultado = 0;


            try {
                System.out.println("Introduce el numero del primero");
                valorA = sc.nextInt();
                System.out.println("Introduce el numero del segundo");
                valorB = sc.nextInt();
                resultado = valorA / valorB;
                System.out.println("el resultado de la operacion es " + resultado);
            }catch (InputMismatchException e){ 
                System.out.println("Valor introducido incorrecto");
            }catch (ArithmeticException e ){
                System.out.println("Pusiste el nuemro 0, no se puede dividir entre 0.");
            }
            
            // Ejercicio 3
=======
        sc = new Scanner(System.in);

        int valorA = 0;
        int valorB = 0;
        int resultado = 0;


        try {
            System.out.println("Introduce el numero del primero");
            valorA = sc.nextInt();
            System.out.println("Introduce el numero del segundo");
            valorB = sc.nextInt();
            resultado = valorA / valorB;
            System.out.println("el resultado de la operacion es " + resultado);
        }catch (InputMismatchException e){ 
            System.out.println("Valor introducido incorrecto");
        }catch (ArithmeticException e ){
            System.out.println("Pusiste el nuemro 0, no se puede dividir entre 0.");
        }
        
        // Ejercicio 3
>>>>>>> Stashed changes

            double [] nuemros = new double [5];
            int uno = 1; 
            int unos = 1;

            for (int i = 0; i < nuemros.length; i++) {
                try {
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el valor del numero " + uno++);
                    nuemros [i] = sc.nextDouble();
                    
                } catch (InputMismatchException e) {
                    do {
                    System.out.println("valor introducido incorrecto");
                    System.out.println("\nintroducelo nuevamente\n");
                    sc = new Scanner(System.in);
                    nuemros [i] = sc.nextDouble();
                    }while (nuemros[i] != nuemros[i]);
                    
                }
            } 
            for (int i = 0; i < nuemros.length; i++) {
                System.out.println("el valor del numero " + (unos++) + " es " + nuemros[i]);
            }

            //Ejercicio 4

            sc = new Scanner(System.in);
        String opcion = "";
        int numero = 0;

        do {
            try {
                // Mostrar el menú
                sc = new Scanner(System.in);
                System.out.println("\nIngrese una opcion del menu");
                System.out.println("1.- Probar número positivo");
                System.out.println("2.- Probar número negativo");
                System.out.println("3.- Salir");
                
                opcion = sc.nextLine();

                // Procesar la opción
                switch (opcion) {
                    case "1":
                        System.out.print("Introduce un número: ");
                        numero = sc.nextInt(); 
                        imprimePositivo(numero);
                        break;
                    case "2":
                        System.out.print("Introduce un número: ");
                        numero = sc.nextInt();
                        imprimeNegativo(numero);
                        break;
                    case "3":
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!opcion.equals("3"));

            // Ejercicio 5

            try {

                Gato gato1 = new Gato("gith", 7);
                
                System.out.println(gato1.toString());
                Gato gato2 = new Gato("happy", -1);
                System.out.println(gato2.toString()); 

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            try {
                Gato gato3 = new Gato("To", 3);
                System.out.println(gato3.toString());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        
            try {
                Gato gato4 = new Gato("Tomy", 3);
                System.out.println(gato4.toString());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            //ejercicio 6

            sc = new Scanner(System.in);
            ArrayList<Gato> listaGatos = new ArrayList<>();

            do {
                try {
                    System.out.println("Introduce el nombre del Gato " + (listaGatos.size()+1));
                    String nombre = sc.nextLine();

                    sc = new Scanner(System.in);
                    System.out.println("Introduce la edad del Gato " + (listaGatos.size()+1));
                    int edad = sc.nextInt();

                    Gato gato = new Gato(nombre, edad);

                    listaGatos.add(new Gato(nombre, edad));
                    
                    System.out.println("Gato añadido correctamente");
                } catch (NumberFormatException e) {
                    System.out.println("El valor introducido no es valido");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (listaGatos.size() < 5);

            System.out.println("Los gatos introducidos son:");
            for (Gato gato : listaGatos) {
                System.out.println(gato.toString());
            }
    }
    
    public static void imprimePositivo(int p) throws IllegalArgumentException{
        if(p<0){
            throw new IllegalArgumentException("El valor introducido es menor de 0");
         }
        System.out.println("El valor introducido es: " + p);
    }

    public static void imprimeNegativo(int n) throws IllegalArgumentException{
        if(n>=0){
            throw new IllegalArgumentException("El valor introducido es mayor de 0");
        }
        System.out.println("El valor introducido es: " + n);
    }
}   
