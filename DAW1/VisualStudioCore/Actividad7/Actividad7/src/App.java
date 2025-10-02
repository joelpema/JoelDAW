
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bienvenido a mi piedra, papel o tijera \n ");

        System.out.println("Pon lo que quieras jugar");

        String jugador = "";

        int ganado = 0;
        int perdido = 0;

        do { 
            
            System.out.println("P = Piedra");
			System.out.println("L = Papel");
			System.out.println("T = Tijeras");
			System.out.println("S = Salir");
            jugador = sc.nextLine();
            jugador = jugador.toUpperCase();

            int bot = (int) (Math.random() * 3 + 1);
                String bot2 = "";
                
            if(!jugador.equals("S")){    
                if (bot == 1){
                    bot2 = "P"; 
                    System.out.println("\n La maquina a elegido Piedra \n");

                } else if (bot == 2){
                    bot2 = "L";
                    System.out.println("\n La maquina a elegido Papel \n");

                } else if (bot == 3){
                    bot2 = "T";
                    System.out.println("\n La maquina a elegido Tijeras \n");
                } 
            }    
            
                
            if(jugador.equals("P")){
                if (bot2 == "T"){
                    System.out.println("\n has ganado!!!");
                    ganado++;
                }else if (bot2 == "P"){
                    System.out.println("\n Has empatado");
                }else if (bot2 == "L"){
                    System.out.println("\n Has perdido :(");
                    perdido++;
                }

            }
            else if(jugador.equals("L")){
                if (bot2 == "T"){
                    System.out.println("\n has perdido :(");
                    perdido++;
                }else if (bot2 == "P"){
                    System.out.println("\n Has ganado!!!!");
                    ganado++;
                }else if (bot2 == "L"){
                    System.out.println("\n Has empatado");
                }  
            }  
            else if(jugador.equals("T")){
                if (bot2 == "T"){
                    System.out.println("\n has empatado");
                }else if (bot2 == "P"){
                    System.out.println("\n Has perdido :(");
                    perdido++;
                }else if (bot2 == "L"){
                    System.out.println("\n Has ganado!!!");
                    ganado++;
                }  
            }     

            else if(jugador.equals("S")){
                System.out.println("\n hasta luego...");
                System.out.println("Has ganado " + ganado + " veces \nHas perdido " + perdido + " veces");
            }    
            else {
                System.out.println("pon una opcion que sea valida en el menu");
            }   



        }while (!jugador.equals("S"));

    }
}
