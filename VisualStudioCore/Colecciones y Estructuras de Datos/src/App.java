
import java.util.InputMismatchException;
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

        double [] nuemros = new double [5];
        int uno = 1; 
        int unos = 1;

        try {

            for (int i = 0; i < nuemros.length; i++) {
            System.out.println("Introduce el valor del numero " + uno++);
            nuemros [i] = sc.nextDouble();
            }            
            for (int i = 0; i < nuemros.length; i++) {
                
                System.out.println("el valor del numero " + (unos++) + " es " + nuemros[i]);
            }

        } catch (InputMismatchException e) {
            System.out.println("valor introducido incorrecto");
            
        }
        







    
    }
}
