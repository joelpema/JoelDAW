import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyUtils {

        
        /** 
         * @param mensaje
         */
        public static void imprimir(String mensaje){
            System.out.println(mensaje);
        }

        
        /** 
         * @return LocalDate
         */
        public static LocalDate leerFecha(){
        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        MyUtils.imprimir("\nEscribe la fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = entrada.nextLine();

        
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
    }

}
