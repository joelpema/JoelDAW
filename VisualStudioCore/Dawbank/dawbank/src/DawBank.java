
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DawBank {
    public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);

     Pattern pat = Pattern.compile("[A-Z]{2}[0-9]{22}");

    System.out.println("Introduzca un IBAN correcto: ");
    String iban = sc.nextLine();
   
    Matcher mat = pat.matcher(iban);

    while(!mat.matches()){

        System.out.println("El IBAN introducido es incorrecto, por favor introduzca un IBAN válido.");

        System.out.print("Introduce un IBAN correcto:");

        iban = sc.nextLine();

        mat = pat.matcher(iban);

    }

    System.out.println("Introduzca el titular");
    String titular = sc.nextLine();

    int movimientos = 100;
    
    CuentaBancaria cuentaBancaria = new CuentaBancaria(iban, titular, movimientos);

    String menu = ""; 

    do { 
        sc = new Scanner(System.in);
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos.");
        System.out.println("8. Salir");
        menu = sc.nextLine();

        if (menu.equals("1")) { 
            System.out.println("IBAN: " + cuentaBancaria.getIban());
            System.out.println("TITULAR: " + cuentaBancaria.getTitular());
            System.out.println("SALDO: " + cuentaBancaria.getSaldo()); 
        } else if (menu.equals("2")) {  
            System.out.println("IBAN: " + cuentaBancaria.getIban());
            
        } else if (menu.equals("3")) {  
            System.out.println("TITULAR: " + cuentaBancaria.getTitular());
            
        } else if (menu.equals("4")) {  
            System.out.println("SALDO: " + cuentaBancaria.getSaldo());
            
        } else if (menu.equals("5")) {  

            sc = new Scanner(System.in);
            System.out.println("INGRESAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A INGRESAR");
			double ingreso = sc.nextDouble();
            Movimiento m1 = new Movimiento("Ingreso", ingreso);
            cuentaBancaria.insertarMovimiento(m1);

        } else if (menu.equals("6")) {  

            sc = new Scanner(System.in);
            System.out.println("RETIRAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A RETIRAR");
			double retirar = sc.nextDouble();
            Movimiento m1 = new Movimiento("retirada", retirar);
            cuentaBancaria.insertarMovimiento(m1);

        } else if (menu.equals("7")) {  

            System.out.println(cuentaBancaria.mostrarMovimientos());

            
        } else if (menu.equals("8")) {  
            System.out.println("hasta pronto!!");
        }else {
            System.out.println("pon una opcion que sea correcta en el menu");
        }

    } while (!menu.equals("8"));
    } 
} 
