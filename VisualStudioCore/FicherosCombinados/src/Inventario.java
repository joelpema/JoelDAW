
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedList<Producto> productos = new LinkedList<>();
        String opcion;
        do { 
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir.");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    try (FileReader file = new FileReader(".\\resources\\productos.csv"); BufferedReader reader = new BufferedReader(file);) {
                    String linea = reader.readLine();
                    while(linea != null){
                        String[] productosEscrito = linea.split("/");
                        Producto p =  new Producto(productosEscrito[0], productosEscrito[1], productosEscrito[2], productosEscrito[3]);
                        productos.add(p);
                        linea = reader.readLine();
                    }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    for (Producto linea : productos) {
                        System.out.println(linea);
                    }
                break;

                case "2":
                    System.out.println("Introduce la referencia del producto a eliminar:");
                    String referencia = entrada.nextLine();
                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.getReferencia().equals(referencia)) {
                            productos.remove(producto);
                            encontrado = true;
                            System.out.println("Producto eliminado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún producto con esa referencia.");
                    }
                break;
                case "3":
                    try (FileWriter writer = new FileWriter("./Recursos/productos.csv"); BufferedWriter buffer = new BufferedWriter(writer)) {
                        for (Producto producto : productos) {
                            buffer.write(producto.toString());
                            buffer.newLine();
                        }
                        System.out.println("Cambios guardados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar los cambios: " + e.getMessage());
                    }
                break;

                default:
                    System.out.println("Introduce un valor valido");
            }

        } while (!opcion.equals("3"));
    }
}