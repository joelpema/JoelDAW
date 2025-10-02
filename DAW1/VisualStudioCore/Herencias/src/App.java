
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        

        String options = "";

        Astro [] astros = new Astro[100]; 
    
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

        sc = new Scanner(System.in);
            System.out.println("1) Planeta");
            System.out.println("2) Satelite");
            System.out.println("3) Ninguna de las dos");
            options = sc.nextLine();

            sc = new Scanner(System.in);
            if (options.equals("1")){
                System.out.println("Pon los datos necesarios para los planetas\n");
                System.out.println("Distancia al Sol:");
                double distanciaSol = sc.nextDouble();

                System.out.println("Orbita al Sol:");
                double orbitaSol = sc.nextDouble();

                System.out.println("¿Tiene satelites?:");
                
                
                System.out.println("escribe 'si' o 'no'");

                sc = new Scanner(System.in);

                boolean tieneSatelites = false;

                String tieneSatelitesSi = sc.nextLine();
                    
                    if (tieneSatelitesSi.equalsIgnoreCase("si")){
                        tieneSatelites = true;
                    
                    }else if (tieneSatelitesSi.equalsIgnoreCase("no")){
                        tieneSatelites = false;
                    
                    }else System.out.println("tienes que escribir 'si' o 'no'");

                Planetas Info2 = new Planetas (masa, diametro, rotacion, translacion, distancia,distanciaSol,orbitaSol,tieneSatelites); 
                System.out.println(Info2);

            }if (options.equals("2")){

                System.out.println("Pon los datos necesarios para los Satelites\n");
                System.out.println("Distancia al Planeta:");
                double distanciaPlaneta = sc.nextDouble();

                System.out.println("Orbita al Planeta:");
                double orbitaPlaneta = sc.nextDouble();

                sc = new Scanner(System.in);
                System.out.println("planeta al que pertenece");
                String planetaPerteneciente = sc.nextLine();
                Satelites Info3 = new Satelites(masa, diametro, rotacion, translacion, distancia,distanciaPlaneta,orbitaPlaneta,planetaPerteneciente);
                System.out.println(Info3);

            }if (options.equals("3")){
            
            System.out.println("ya estaria terminado");

            }       
    }
}         