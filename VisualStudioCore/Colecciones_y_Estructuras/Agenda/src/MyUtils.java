import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {



    public static boolean comprobarNombre(){
        String nombre;

        Pattern pat = Pattern.compile("[A-Z]{1} [a-z]{1,30}");
        Matcher matcher;

        do { 
        Scanner sc = new Scanner (System.in);

        nombre = sc.nextLine();
        }while (true);


    }

}
