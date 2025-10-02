import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {


    public static void imprimir(String mensaje){
            System.out.println(mensaje);
        }
        public static LocalDate leerFecha(){
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        MyUtils.imprimir("\nEscribe la fecha de publicacion en formato DD/MM/AAAA");
        String dateString = entrada.nextLine();
        
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
    }

    public static String leerTexto(String mensaje){
        Scanner entrada = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = entrada.nextLine();
        return valor;
    }

    public static boolean comprobarPatron(String patron, String texto)
            {
                boolean isOk = false;
                Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
                Matcher mat = pat.matcher(texto);
                isOk = mat.matches();
                return isOk;
            }
    public static String comprobarPatronRepetidamente(String patron, String mensaje){
        boolean isOk = false;
        String texto;
        do { 
            texto = MyUtils.leerTexto(mensaje);
            isOk = MyUtils.comprobarPatron(patron, texto);
            if(!isOk){
                MyUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }
    
    public static Enumerado menuEnumerado(){
        Scanner entrada = new Scanner(System.in);

        Enumerado enumerado =  null;
        System.out.println("Seleccione el departamento del trabajador:");
        for (int i = 0; i < enumerado.values().length; i++) {
            System.out.println((i+1) + ". " + enumerado.values()[i]);
        }
        System.out.println("Introduce el numero relacionado con el nombre del departamento");
        int opcion = entrada.nextInt();
        if (opcion >= 1 && opcion <= enumerado.values().length){
            enumerado = enumerado.values()[opcion - 1];
            System.out.println("El departamento seleccionado es: " + enumerado);
        }
        return enumerado;
    }




}
