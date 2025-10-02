import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        List<Producto> productos = new LinkedList<>();
        String opcion = "";
        
        System.out.println("Bienvenido a mi tienda!!");

        try (FileOutputStream fichero = new FileOutputStream("./resources/Almacen.dat", false)) {
            
        } catch (Exception e) {
            System.out.println("fichero no encontrado");
        }
        do {
                sc = new Scanner(System.in);
                System.out.println("1. Crear producto");
                System.out.println("2. Mostrar productos existentes\r");
                System.out.println("3. Eliminar producto por código");
                System.out.println("4. Guardar productos en el fichero");
                System.out.println("5. Salir");
                                
                opcion = sc.nextLine();
                
                switch (opcion) {
                    case "1":
                        
                        System.out.println("Creando producto\n");
                        System.out.println("Inserta el nombre del producto");
                        String nombre = sc.nextLine(); 
                        System.out.println("Inserta la cantidad de productos que hay");
                        int cantidad = sc.nextInt();
                        System.out.println("introduce el precio del producto");
                        double precio = sc.nextDouble();
                        Producto p = new Producto(nombre, cantidad, precio);
                        productos.add(p);

                        System.out.println(p.toString());

                        break;
                    case "2":
                    if (productos != null){
                        for(int i = 0; i<productos.size();i++){
                            System.out.println(productos.get(i).toString());
                        }
                    }

                        break;
                    case "3":
                        
                    System.out.println("intoduce el codigo del producto que quieres eliminar");
                    int cod = sc.nextInt();

                    Producto eliminaProducto = null;
                        for (Producto producto : productos) {
                            if(producto.getCodigo() == cod){
                                eliminaProducto = producto;
                            }
                        }
                        productos.remove(eliminaProducto);
                        System.out.println("el producto se elimino");

                        break;
                    case "4":
                        
                        try (PrintWriter writer = new PrintWriter(new FileWriter("./resources/Almacen.dat", false))) {
                        for (Producto prod : productos) {
                            String comando = "Producto= " + prod.getCodigo() + "," + prod.getNombre() + "," + prod.getCantidad() + "," + prod.getPrecio();

                            writer.println(comando);
                        }
                            System.out.println("Productos guardados en el fichero.");
                        } catch (IOException e) {
                            System.out.println("Error al guardar productos: " + e.getMessage());
                        }
                        break;

                    case "5":
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (!opcion.equals("5"));
    }
}
