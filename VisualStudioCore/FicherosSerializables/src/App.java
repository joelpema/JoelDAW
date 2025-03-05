
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opcion = "";

        System.out.println("Bienvenido a mi libreria, escoge una opcion correcta en el menu");
        do{

            System.out.println("1. Crear Libro y registrarlo en la Biblioteca (ISBN único)");
            System.out.println("2. Mostrar Libros existentes");
            System.out.println("3. Eliminar Libro por ISBN");
            System.out.println("4. Guardar Libros en el fichero");
            System.out.println("5. Guardar y Salir");
            opcion = sc.nextLine();

            if (opcion.equals("1")){
                System.out.println("Crear libro: ");
                System.out.println("Introduce el ISBN del libro");
                String isbn = sc.nextLine();
                System.out.println("Introduce el nombre del libro");
                String nombre = sc.nextLine();
                System.out.println("Introduce el autor del libro");
                String autor = sc.nextLine();
                System.out.println("Introduce la fecha de publicacion");
                LocalDate publicacion = MyUtils.leerFecha();

            }else if (opcion.equals("2")){

                



            }else if (opcion.equals("3")){

            }else if (opcion.equals("4")){

            }else if (opcion.equals("5")){

            }
        }while (!opcion.equals("5"));





    }
}
