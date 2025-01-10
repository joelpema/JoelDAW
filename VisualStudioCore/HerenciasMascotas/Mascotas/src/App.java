import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Mascotas [] astros = new Mascotas[100];

        System.out.println("\n Pon la informacion necesaria de la mascota\n");

        System.out.println("Nombre");
        String Nombre = sc.nextLine();

        System.out.println("Esta vivo?");
                
                
        System.out.println("escribe 'si' o 'no'");

        sc = new Scanner(System.in);

        boolean estaVivo = false;
        String estado = sc.nextLine();
        
            if (estado.equalsIgnoreCase("si")){
                estaVivo = true;
            
            }else if (estado.equalsIgnoreCase("no")){
                estaVivo = false;
            
            }else System.out.println("tienes que escribir 'si' o 'no'");
           
        LocalDate fechaDeNacimiento = MyUtils.leerFecha();
		LocalDate hoy = LocalDate.now();
		Period Edad = Period.between(fechaDeNacimiento, hoy);

        LocalDateTime ahora = LocalDateTime.now();

        System.out.println( );



        
    }
}
