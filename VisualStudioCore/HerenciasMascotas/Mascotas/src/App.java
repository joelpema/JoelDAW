import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String options;

        Scanner sc = new Scanner(System.in);

        Mascotas [] astros = new Mascotas[100];

        System.out.println("\n Pon la informacion necesaria de la mascota\n");

        System.out.println("Nombre");
        String Nombre = sc.nextLine();

        System.out.println("Que edad Tiene?");
        double Edad = sc.nextDouble();

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
		Period AñoNacimiento = Period.between(fechaDeNacimiento, hoy);
        LocalDateTime fechaDeNacimientoDateTime = fechaDeNacimiento.atStartOfDay();

        Mascotas info = new Mascotas(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime);
        System.out.println(info + "\n");  

        sc = new Scanner(System.in);
        System.out.println("1) Perro");
        System.out.println("2) Gato");
        System.out.println("3) Es un pajaro");
        options = sc.nextLine();

        if (options.equals("1")) {

            Perro nuevaRaza = null;
        
            System.out.println("Pon los datos del Perro");
            System.out.println("Raza");
            String Raza = sc.nextLine();
            System.out.println("tiene pulgas?");
            System.out.println("escribe 'si' o 'no'");

            boolean Pulgas = false;
            String pulgas = sc.nextLine();
            
            if (pulgas.equalsIgnoreCase("si")){
                Pulgas = true;
                
            }else if (pulgas.equalsIgnoreCase("no")){
                Pulgas = false;
                
            }else System.out.println("tienes que escribir 'si' o 'no'");

            System.out.println("Quieres que hable?");

            String HablarPerro = sc.nextLine();

            if(estaVivo == true){
            if (HablarPerro.equalsIgnoreCase("si")){
                System.out.println("¡guau guau!");
            }
            }else {
                System.out.println("esta muerto");
            }
            
            

            Perro info2 = new Perro(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime, Raza, Pulgas);
            System.out.println(info2 + "\n");
        }        

        if (options.equals("2")) {

            sc = new Scanner(System.in);

            System.out.println("Pon los datos para el gato");
            System.out.println("De que color/colores es?");
            String color = sc.nextLine();
            System.out.println("Tiene el pelo largo?");
            System.out.println("escribe 'si' o 'no'");

            boolean PeloLargo = false;
            String Pelo = sc.nextLine();
            
            if (Pelo.equalsIgnoreCase("si")){
                PeloLargo = true;
                
            }else if (Pelo.equalsIgnoreCase("no")){
                PeloLargo = false;
                
            }else System.out.println("tienes que escribir 'si' o 'no'");

            System.out.println("Quieres que hable?");

            String HablarGato = sc.nextLine();
            
            if (HablarGato.equalsIgnoreCase("si")){
                System.out.println("¡miau miau!");
            }

            gato info3 = new gato(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime, color, PeloLargo);
            System.out.println(info3 + "\n");
        }

        String options2 = "";

        if (options.equals("3")) {
            sc = new Scanner(System.in);

            System.out.println("Como es el pico?");
            String pico = sc.nextLine();
            System.out.println("vuela?");
            String vuela = sc.nextLine();

            System.out.println("quieres que vuele?");

            String volar = sc.nextLine();
            
            if (vuela.equalsIgnoreCase("si")){
                System.out.println("Esta volando");
            }

            Aves info4 = new Aves(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime, pico, vuela);
            System.out.println(info4 + "\n");

            System.out.println("Que tipo de Ave es?");
            System.out.println("1) Loro");
            System.out.println("2) Canario");
            options2 = sc.nextLine();



        }    

        if (options2.equals("1")) {
            sc = new Scanner(System.in);

            System.out.println("Pon los datos para el loro");
            System.out.println("Cual es su origen");
            String Origen = sc.nextLine();
            System.out.println("Sabe hablar?");
            String Hablar = sc.nextLine();

            System.out.println("Quieres que hable?");
            String HablarPajaro = sc.nextLine();
            
            if (Hablar.equalsIgnoreCase("si")){
                System.out.println("¡Hola soy un loro!");
            }else {
                System.out.println("Pio Pio");
            }

            System.out.println("Quieres que vuele?");
            String volarLoro = sc.nextLine();

            if (volarLoro.equalsIgnoreCase("si")){
                System.out.println("Esta volando");
            }

            Loro info5 = new Loro(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime, HablarPajaro, volarLoro, Origen, Hablar);
            System.out.println(info5 + "\n");
        }    

        if (options2.equals("1")) {

            System.out.println("Que color es?");
            String Color = sc.nextLine();
            System.out.println("Sabe cantar?");
            String Canta = sc.nextLine();

            System.out.println("Quieres que cante?");
            String HablarPajaro = sc.nextLine();
            
            if (Canta.equalsIgnoreCase("si")){
                System.out.println("¡un elefante se balanceaba sobre la tela de una araña!");
            }else {
                System.out.println("no sabe cantar");
            }

            System.out.println("Quieres que hable?");
            String HablarPajaro2 = sc.nextLine();
            
            if (HablarPajaro2.equalsIgnoreCase("si")){
                System.out.println("¡Pio Pio!");
            }

            System.out.println("Quieres que vuele?");
            String volarLoro = sc.nextLine();

            if (volarLoro.equalsIgnoreCase("si")){
                System.out.println("Esta volando");
            }

            Canario info5 = new Canario(Nombre, Edad, estaVivo, fechaDeNacimientoDateTime, Color, Canta, Color, Canta);
            System.out.println(info5 + "\n");



        }

    }
}
