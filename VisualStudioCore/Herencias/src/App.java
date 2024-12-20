
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String options = "";

        Astro [] astros = new Astro[100]; 
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Pon las medidas necesarias del Astro\n");

        System.out.println("Masa del cuerpo");
        double masa = sc.nextDouble();

        System.out.println("Diámetro medio");
        double diametro = sc.nextDouble();

        System.out.println("Período de rotación sobre su propio eje");
        double rotacion = sc.nextDouble();

        System.out.println("Período de traslación alrededor del cuerpo que orbitan");
        double translacion = sc.nextDouble();

        System.out.println("Distancia media al cuerpo");
        double distancia = sc.nextDouble();

        Astro Info = new Astro(masa, diametro, rotacion, translacion, distancia);

        System.out.println(Info);

        System.out.println("¿que es tu astro?");
        
            System.out.println("1) Planeta");
            System.out.println("2) Satelite");
            System.out.println("3) Ninguna de las dos");
            options = sc.nextLine();

            if (options.equals("1")){
                System.out.println("Pon los datos necesarios para los planetas\n");
                System.out.println("Distancia al Sol:");
                double distanciaSol = sc.nextDouble();

                System.out.println("Orbita al Sol:");
                double orbitaSol = sc.nextDouble();

                System.out.println("¿Tiene satelites?:");
                boolean TieneSatelites = false;
                
                System.out.println("escribe 'si' o 'no'");
                String tieneSatelitesSi = sc.nextLine();
                {
                if (tieneSatelitesSi == "si"){
                    TieneSatelites = true;
                } else if (tieneSatelitesSi == "no"){
                    TieneSatelites = false;
                } else System.out.println("tienes que escribir 'si' o 'no'");
                }while (tieneSatelitesSi == "si" && tieneSatelitesSi == "no");
            }
            if (options.equals("2")){
                
            }
            if (options.equals("3")){
                
            }


       



    }
}         