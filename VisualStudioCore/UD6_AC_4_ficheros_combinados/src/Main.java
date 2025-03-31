import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Producto> productos = new LinkedList<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int opcion;

        try (FileReader file = new FileReader("resource\\productos.csv"); BufferedReader reader = new BufferedReader(file);) {
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

            
        

        // fichero binario
            int i = 0;
        boolean eof = false;
        try (FileInputStream fichero = new FileInputStream("resource\\almacen.dat"); DataInputStream lector = new DataInputStream(fichero)) {


            

            while(!eof){
                int cantidad = lector.readInt();
                double precio = lector.readDouble();
                int descuento = lector.readInt();
                int iva = lector.readInt();
                boolean aplicarDescuenta = lector.readBoolean();

                productos.get(i).setCantidad(cantidad);
                productos.get(i).setPrecio(precio);
                productos.get(i).setDescuento(descuento);
                productos.get(i).setIva(iva);
                productos.get(i).setAplicarDto(aplicarDescuenta);

                if(i < productos.size()){
                    i++;
                }

            }
            
        } catch (EOFException e) {

            eof = true;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Mostrar Productos en el Inventario");
            System.out.println("2. Eliminar Producto por referencia - Ejemplo(ref-001)");
            System.out.println("3. Guardar y Salir");
            System.out.print("\nSelecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:

                
                for (Producto linea : productos) {
                    System.out.println(linea);
                }
 
                    break;
                case 2:
                    System.out.print("\nIntroduce la referencia del producto que se va a reducir a cero");
                    String referencia = scanner.nextLine();

                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.getReferencia().equals(referencia)) {
                            encontrado = true;
                            producto.setCantidad(0);
                            System.out.println("Producto eliminado correctamente.");
                            break;
                        }
                    }



                    break;
                case 3:
                try (DataInputStream writer = new DataInputStream(new FileInputStream("resource\\almacen.dat"))) {
                    for (Producto p : productos) {
                        writer.write(p.getReferencia() + "/" + p.getNombre() + "/" + p.getDescripcion() + "/" + p.getTipo());
                        writer.newLine();
                    }
                    System.out.println("Productos guardados en productos.csv");
                } 
                catch (IOException e) {
                    System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
                }

                    break;
                default:
                    System.out.println("\nOpcion no valida, Intentalo de nuevo");
            }
        } 
        while (opcion != 3);

        
    }

}