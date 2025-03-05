
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Libro> libros = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        String opcion = "";
        Libro nuevoLibro = new Libro (" "," "," ", null);

        System.out.println("Bienvenido a mi libreria, escoge una opcion correcta en el menu");
        do{

            System.out.println("1. Crear Libro y registrarlo en la Biblioteca (ISBN único)");
            System.out.println("2. Mostrar Libros existentes");
            System.out.println("3. Eliminar Libro por ISBN");
            System.out.println("4. Guardar Libros en el fichero");
            System.out.println("5. Guardar y Salir");
            opcion = sc.nextLine();

            if (opcion.equals("1")){
                System.out.print("Introduce el ISBN: ");
                String isbn = sc.nextLine();

                boolean existe = false;
                for (Libro libro : libros) {
                    if (libro.getIsbn().equals(isbn)) {
                        existe = true;
                        break;
                    }
                }

                if (existe == true) {
                    System.out.println("Error: ISBN ya registrado.");
                } else {
                
                System.out.println("Introduce el nombre del libro");
                String nombre = sc.nextLine();
                System.out.println("Introduce el autor del libro");
                String autor = sc.nextLine();
                System.out.println("Introduce la fecha de publicacion");
                LocalDate publicacion = MyUtils.leerFecha();

                nuevoLibro = new Libro(isbn, nombre, autor, publicacion);
                libros.add(nuevoLibro);
                }
            }else if (opcion.equals("2")){

                if (libros != null){
                    for(int i = 0; i<libros.size();i++){
                        System.out.println(libros.get(i).toString());
                    }
                }
            }else if (opcion.equals("3")){

                System.out.println("intoduce el ISBN del libro que quieres eliminar");
                    String cod = sc.nextLine();

                    Libro eliminaProducto = null;
                        for (Libro librete : libros) {
                            if(Objects.equals(librete.getIsbn(), cod)){
                                eliminaProducto = librete;
                            }
                        }
                        libros.remove(eliminaProducto);
                        System.out.println("el producto se elimino");

            }else if (opcion.equals("4")){

                try (FileOutputStream file = new FileOutputStream("./Resources/libro.dat", true); ObjectOutputStream buffer = new ObjectOutputStream(file)){

                    buffer.writeObject(nuevoLibro);

                } catch (IOException e) {
                    System.out.println("Se ha producido un error: "+e.getMessage());
                }

            }else if (opcion.equals("5")){

                try (FileOutputStream file = new FileOutputStream("./Resources/libro.dat", true); ObjectOutputStream buffer = new ObjectOutputStream(file)){

                    buffer.writeObject(nuevoLibro);

                } catch (IOException e) {
                    System.out.println("Se ha producido un error: "+e.getMessage());
                }

                System.out.println("hasta la proxima!!");
            }
        }while (!opcion.equals("5"));





    }
}
