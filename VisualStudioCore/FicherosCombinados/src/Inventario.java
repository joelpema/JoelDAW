
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        List<Producto> producto = new LinkedList<>();

        System.out.println("Bienvenido a tu tienda de confianza!!!");
        
        do { 
            sc = new Scanner(System.in);

            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir (inventario.dat).");
            System.out.println("4. Registrar producto en el Inventario");
            opcion = sc.nextLine();

            if (opcion.equals("1")){

                //fichero unicode

                System.out.println("Mostrando Productos en el inventario\n");

                try (FileReader file2 = new FileReader(".\\resources\\productos.csv"); BufferedReader reader = new BufferedReader(file2);) {
                    String linea = reader.readLine();
                    while(linea != null){
                
                String[] datos = linea.split("/");

                System.out.println(linea);

                linea = reader.readLine();

                }   

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                //Ficheros binarios

                int i = 0;
                boolean eof = false;
                try (FileInputStream fichero = new FileInputStream(".\\resources\\almacen.dat"); DataInputStream lector = new DataInputStream(fichero)) {

                
                    while(!eof){
                        int cantidad = lector.readInt();
                        double precio = lector.readDouble();
                        int descuento = lector.readInt();
                        int iva = lector.readInt();
                        boolean aplicarDto = lector.readBoolean();

                        

                        System.out.println(cantidad);
                        System.out.println(precio);
                        System.out.println(descuento);
                        System.out.println(iva);
                        System.out.println(aplicarDto);

                        if(i < producto.size()){
                            i++;
                        }
                        
                    }
                    
                } catch (EOFException e) {
                    eof = true;
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }

                for (Producto p : producto) {
                    System.out.println(p);
                }

            }else if (opcion.equals("2")){

                
                

            }else if (opcion.equals("3")){
                
                
                
                
            }else if (opcion.equals("4")){


                
            }else {
                System.out.println("Pon una opcion correcta en el menu");
            }

            
        } while (!opcion.equals("3"));
    }
}
