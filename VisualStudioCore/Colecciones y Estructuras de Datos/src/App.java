import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        // Ejercicio 1
        // int valor = 0;


        // try {
        //     System.out.println("introduce el valor que quieres darle a esta variable");
        //     valor = sc.nextInt();
        //     System.out.println("El valor introducido es " + valor);
        // }catch (InputMismatchException e){ 
        //     System.out.println("valor introducido incorrecto");
        // }

        // Ejercicio 2

        // sc = new Scanner(System.in);

        // int valorA = 0;
        // int valorB = 0;
        // int resultado = 0;


        // try {
        //     System.out.println("Introduce el numero del primero");
        //     valorA = sc.nextInt();
        //     System.out.println("Introduce el numero del segundo");
        //     valorB = sc.nextInt();
        //     resultado = valorA / valorB;
        //     System.out.println("el resultado de la operacion es " + resultado);
        // }catch (InputMismatchException e){ 
        //     System.out.println("Valor introducido incorrecto");
        // }catch (ArithmeticException e ){
        //     System.out.println("Pusiste el nuemro 0, no se puede dividir entre 0.");
        // }
        
        // Ejercicio 3

        // double [] nuemros = new double [5];
        // int uno = 1; 
        // int unos = 1;

        // for (int i = 0; i < nuemros.length; i++) {
        //     try {
        //         sc = new Scanner(System.in);
        //         System.out.println("Introduce el valor del numero " + uno++);
        //         nuemros [i] = sc.nextDouble();
                
        //     } catch (InputMismatchException e) {
        //         do {
        //         System.out.println("valor introducido incorrecto");
        //         System.out.println("\nintroducelo nuevamente\n");
        //         sc = new Scanner(System.in);
        //         nuemros [i] = sc.nextDouble();
        //         }while (nuemros[i] != nuemros[i]);
                
        //     }
        // } 
        // for (int i = 0; i < nuemros.length; i++) {
        //         System.out.println("el valor del numero " + (unos++) + " es " + nuemros[i]);
        

        //Ejercicio 4

        int numero;
        String opcion = "3";

        sc = new Scanner(System.in);

        do { 
            try {
                System.out.println("<==MENU==>");
                System.out.println("1.- Probar numero positivo");
                System.out.println("2.- Probar numero negativo");
                System.out.println("3.- Salir");
                System.out.println("Elige una opcion:");
                opcion = sc.nextLine();

                System.out.println("Introduce un numero:");
                numero = sc.nextInt();
                switch (opcion) {
                    case "1":
                        imprimePositivo(numero);
                        sc.nextLine();
                        break;
                    case "2":
                        imprimeNegativo(numero);
                        sc.nextLine();
                        break;
                    case "3":
                        System.out.println("Saliendo del programa...");
                        break;  
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion.equals("3")); 
        // Ejercicio 5
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

