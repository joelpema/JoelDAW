import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception{

        Producto producto1 = new Producto( "Teclado, ", 50); 
        Producto producto2 = new Producto( "Pantalla, ", 20);
        Producto producto3 = new Producto( "Raton, ", 60);
        Producto producto4 = new Producto( "Ordenador, ", 100);
        Producto producto5 = new Producto( "Silla, ", 10);

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Iterator<Producto> itera = productos.iterator();   
        
        Producto cadaProducto;

        while (itera.hasNext()) {
            cadaProducto = itera.next();
            System.out.println(cadaProducto.getNombre() + cadaProducto.getCantidad());
            
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
    }                                           
}       
