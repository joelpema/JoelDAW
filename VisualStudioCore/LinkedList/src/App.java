import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception{

        //Ejercicio 1

        Producto producto1 = new Producto( "Teclado, ", 50); 
        Producto producto2 = new Producto( "Pantalla, ", 20);
        Producto producto3 = new Producto( "Raton, ", 60);
        Producto producto4 = new Producto( "Ordenador, ", 100);
        Producto producto5 = new Producto( "Silla, ", 10);

        //Ejercicio 2

        LinkedList<Producto> productos = new LinkedList<Producto>();

        //Ejercicio 3

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Iterator<Producto> itera = productos.iterator();   
        
        Producto cadaProducto;

        //Ejercicio 4

        while (itera.hasNext()) {
            cadaProducto = itera.next();
            System.out.println(cadaProducto.getNombre() + cadaProducto.getCantidad());
            
            //Ejercicio 5
            
            if (cadaProducto.equals(producto4)) {
                itera.remove();
            }
            if (cadaProducto.equals(producto5)) {
                itera.remove();
            }

        }

        System.out.println("\n Recorrido despues de borrar 2 productos \n");

        for (Producto productoN : productos){
            System.out.println(productoN.getNombre() + productoN.getCantidad());
        }

        //Ejercicio 6

        Producto nuevoProducto = new Producto("Portatil ", 18);
        productos.add(productos.size() / 2, nuevoProducto);

        //Ejercicio 7

        System.out.println("\n Recorrido despues de anadir un producto en medio \n");

        for (Producto productoN : productos){
            System.out.println(productoN.getNombre() + productoN.getCantidad());
        }

        //Ejercicio 8

        System.out.println("\n Recorrido despues de ordenarlos \n");

        Collections.sort(productos, Comparator.comparing(Producto::getNombre));

        for (Producto productoN : productos){
            System.out.println(productoN.getNombre() + productoN.getCantidad());
        }

        //Ejercicio 9

        productos.clear();

        System.out.println("\n Recorrido despues de eliminar todo \n");

        for (Producto productoN : productos){
            System.out.println(productoN.getNombre() + productoN.getCantidad());
        }

    }                                           
}       
