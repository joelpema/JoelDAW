import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        List<Producto> productos = new LinkedList<>();

        // Load data from files
        cargarDatos(productos);

        System.out.println("Bienvenido a tu tienda de confianza!!!");
        
        do {
            sc = new Scanner(System.in);

            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir (inventario.dat).");
            System.out.println("4. Registrar producto en el Inventario");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    mostrarProductos(productos);
                    break;
                case "2":
                    eliminarProducto(productos, sc);
                    break;
                case "3":
                    guardarYSalir(productos);
                    break;
                case "4":
                    registrarProducto(productos, sc);
                    break;
                default:
                    System.out.println("Pon una opcion correcta en el menu");
            }
        } while (!opcion.equals("3"));
    }

    @Override
    public String toString() {
        return "Inventario []";
    }

    // ... (implement the methods below)
}

private static void cargarDatos(List<Producto> productos) {
    cargarProductosCSV(productos);
    cargarAlmacenDAT(productos);
}

private static void cargarProductosCSV(List<Producto> productos) {
    try (BufferedReader reader = new BufferedReader(new FileReader(".\\resources\\productos.csv"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("/");
            if (datos.length >= 4) {
                Producto producto = new Producto(datos[0], datos[1], datos[2], datos[3]);
                productos.add(producto);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void cargarAlmacenDAT(List<Producto> productos) {
    try (DataInputStream lector = new DataInputStream(new FileInputStream(".\\resources\\almacen.dat"))) {
        for (Producto producto : productos) {
            producto.setCantidad(lector.readInt());
            producto.setPrecio(lector.readDouble());
            producto.setDescuento(lector.readInt());
            producto.setIva(lector.readInt());
            producto.setAplicarDto(lector.readBoolean());
        }
    } catch (EOFException e) {
        // End of file reached
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void mostrarProductos(List<Producto> productos) {
    System.out.println("Mostrando Productos en el inventario\n");
    for (Producto producto : productos) {
        System.out.println(producto);
    }
}

private static void eliminarProducto(List<Producto> productos, Scanner sc) {
    System.out.println("Introduce la referencia del producto que quieres eliminar");
    String ref = sc.nextLine();

    Producto eliminaProducto = null;
    for (Producto producto : productos) {
        if (Objects.equals(producto.getReferencia(), ref)) {
            eliminaProducto = producto;
            break;
        }
    }
    if (eliminaProducto != null) {
        productos.remove(eliminaProducto);
        System.out.println("El producto se eliminó");
    } else {
        System.out.println("No se encontró un producto con esa referencia");
    }
}

private static void guardarYSalir(List<Producto> productos) {
    try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream(".\\resources\\inventario.dat"))) {
        for (Producto producto : productos) {
            escritor.writeUTF(producto.getReferencia());
            escritor.writeUTF(producto.getDescripcion());
            escritor.writeUTF(producto.getTipo());
            escritor.writeInt(producto.getCantidad());
            escritor.writeDouble(producto.getPrecio());
            escritor.writeInt(producto.getDescuento());
            escritor.writeInt(producto.getIva());
            escritor.writeBoolean(producto.isAplicarDto());
        }
        System.out.println("Datos guardados. Saliendo del programa.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void registrarProducto(List<Producto> productos, Scanner sc) {
    System.out.println("Introduce la referencia del nuevo producto:");
    String ref = sc.nextLine();

    if (productos.stream().anyMatch(p -> p.getReferencia().equals(ref))) {
        System.out.println("Ya existe un producto con esa referencia.");
        return;
    }

    System.out.println("Introduce la descripción:");
    String descripcion = sc.nextLine();
    System.out.println("Introduce el tipo:");
    String tipo = sc.nextLine();
    System.out.println("Introduce la cantidad:");
    int cantidad = Integer.parseInt(sc.nextLine());
    System.out.println("Introduce el precio:");
    double precio = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce el descuento:");
    int descuento = Integer.parseInt(sc.nextLine());
    System.out.println("Introduce el IVA:");
    int iva = Integer.parseInt(sc.nextLine());
    System.out.println("¿Aplicar descuento? (true/false):");
    boolean aplicarDto = Boolean.parseBoolean(sc.nextLine());

    Producto nuevoProducto = new Producto(ref, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
    productos.add(nuevoProducto);
    System.out.println("Producto registrado con éxito.");
}
