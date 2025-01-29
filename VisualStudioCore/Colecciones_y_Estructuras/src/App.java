import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        Taller taller = new Taller();

        String option;

        do { 

            sc = new Scanner(System.in);

            System.out.println("Selecciona una opcion de el menu\n");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Salir");
            option = sc.nextLine();

            if (option.equals("1")){

                System.out.println("Añade la Matricula");
                String matricula = sc.nextLine();
                System.out.println("Añade el Color");
                String color = sc.nextLine();
                System.out.println("Añade la Marca");
                String marca = sc.nextLine();

                taller.aniadirElemento(color, marca, matricula);

            }else if (option.equals("2")){

                System.out.println("Añada la matricula del coche que quieras eliminar");
                String cocheEliminar = sc.nextLine();
                taller.eliminaElemento(cocheEliminar);

            }else if (option.equals("3")){   

                taller.visualizaMatriculas();
                taller.visualizaCoches();
                taller.visualizaTaller();

            }else {
                System.out.println("Ingrese una opcion correcta en el menu");
            }


        } while (!option.equals("3"));


    }
}
