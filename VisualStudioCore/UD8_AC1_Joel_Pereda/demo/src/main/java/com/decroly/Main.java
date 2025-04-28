package com.decroly;

import java.util.List;
import java.util.Scanner;

import com.TablaProductos;
import com.Tipo;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        
        System.out.println("¡¡Bienvenido a MercaDaw!!");
        SQLAccessProgramacion misDatos = new SQLAccessProgramacion();

        do {

            scanner = new Scanner(System.in);
            System.out.println("\nMenú");
            System.out.println("1. Mostrar todos los Productos en el Inventario.");
            System.out.println("2. Buscar producto por referencia.");
            System.out.println("3. Buscar productos por tipo.");
            System.out.println("4. Buscar producto por cantidad.");
            System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
            System.out.println("6. Eliminar Producto por referencia.");
            System.out.println("7. Actualizar producto.");
            System.out.println("8. Insertar un nuevo tipo de producto.");
            System.out.println("9. Salir");

            scanner = new Scanner(System.in);
            opcion = scanner.nextLine();
            scanner.nextLine();
            
            if (opcion.equals("1")) {
            
                List<TablaProductos> characters = misDatos.getProductos();

                for(TablaProductos c : characters){
                    System.out.println(c);
                }

            } else if (opcion.equals("2")) {

                System.out.println("\nInserta una referencia \n Ejemplo: 'PRD001'");
                String ref = scanner.nextLine();

                List<TablaProductos> referencia = misDatos.getByRef(ref);
                
                for(TablaProductos r : referencia){
                    System.out.println(r);
                }
        

            } else if (opcion.equals("3")) {

                System.out.println("\nInserta el id de tipo \n Ejemplo: '1'");
                String tip = scanner.nextLine();

                List<TablaProductos> tipos = misDatos.getByTipo(tip);
                
                for(TablaProductos t : tipos){
                    System.out.println(t);
                }


            } else if (opcion.equals("4")) {

                System.out.println("\nInserta la cantidad del producto que quieras buscar");
                int cant = scanner.nextInt();

                List<TablaProductos> tipos = misDatos.getProductoByCantidad(cant);
                
                for(TablaProductos t : tipos){
                    System.out.println(t);
                }
               
            } else if (opcion.equals("5")) {

                scanner = new Scanner(System.in);
                System.out.println("Inserta la referencia del nuevo producto");
                String referencia = scanner.nextLine();
                System.out.println("Inserta el nombre del nuevo producto");
                String nombre = scanner.nextLine();
                System.out.println("Inserta la descripcion del nuevo producto");
                String descripcion = scanner.nextLine();
                System.out.println("Inserta el id del tipo del nuevo producto");
                int tipo = scanner.nextInt();
                System.out.println("Inserta la cantidad del nuevo producto");
                int cantidad = scanner.nextInt();
                System.out.println("Inserta el precio del nuevo producto");
                double precio = scanner.nextDouble();
                System.out.println("Inserta el descuento del nuevo producto");
                int descuento = scanner.nextInt();
                System.out.println("Inserta el iva del nuevo producto");
                int iva = scanner.nextInt();
                boolean aplicarDto = false;
                
                scanner = new Scanner(System.in);
                System.out.println("aplicar descuento? s/n poner una letra que no sea ni 's' ni 'n' se dara por hecho que es que no");
                scanner = new Scanner(System.in);
                String apDescuento = scanner.nextLine();
                if (apDescuento.equalsIgnoreCase("s")){
                    aplicarDto = true;
                }else if (apDescuento.equalsIgnoreCase("n")){
                    aplicarDto = false;
                }else {
                    System.out.println("pon una opcion correcta, se dara por hecho que que es que no");
                }

                TablaProductos nuevoProducto = new TablaProductos(referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                

                int insertar = misDatos.getInsertarProducto(nuevoProducto);
                System.out.println("Se han insertado " + insertar + " elementos");


            } else if (opcion.equals("6")) {

                System.out.println("\nInserta una referencia a Eliminar\n Ejemplo: PRD001");
                String refre = scanner.nextLine();
                misDatos.deleteByReference(refre);
  
            } else if (opcion.equals("7")) {

                scanner = new Scanner(System.in);
                System.out.println("introduce el ID del producto que quieres actualizar");
                int id = scanner.nextInt();

                scanner = new Scanner(System.in);
                System.out.println("Inserta la descripcion del producto actualizado");
                String descripcions = scanner.nextLine();
                System.out.println("Inserta la cantidad del producto actualizado");
                int cantidads = scanner.nextInt();
                System.out.println("Inserta el precio del producto actualizado");
                double precios = scanner.nextDouble();
                System.out.println("Inserta el descuento del producto actualizado");
                int descuentos = scanner.nextInt();
                boolean aplicarDtos = false;
                
                scanner = new Scanner(System.in);
                System.out.println("aplicar descuento? s/n poner una letra que no sea ni 's' ni 'n' se dara por hecho que es que no");
                scanner = new Scanner(System.in);
                String apDescuento = scanner.nextLine();
                if (apDescuento.equalsIgnoreCase("s")){
                    aplicarDtos = true;
                }else if (apDescuento.equalsIgnoreCase("n")){
                    aplicarDtos = false;
                }else {
                    System.out.println("pon una opcion correcta, se dara por hecho que que es que no");
                }

                TablaProductos actualizarProducto = new TablaProductos( id, descripcions, cantidads, precios, descuentos, aplicarDtos);

                misDatos.getUpdateProductos(actualizarProducto);



            } else if (opcion.equals("8")) {
                scanner = new Scanner(System.in);
                System.out.println("introduce la ID del nuevo tipo");
                int ids = scanner.nextInt();
                scanner = new Scanner(System.in);
                System.out.println("introduce el Nombre del nuevo tipo");
                String nombreTipo = scanner.nextLine();
                Tipo nuevoTipo = new Tipo(ids, nombreTipo);
                
                misDatos.getIsertarTipos(nuevoTipo);


               
            } else if (opcion.equals("9")) {

                System.out.println("hasta la proxima!!");
                
            } else {

                System.out.println("Pon una opcion correcta en el menu!!");
                
            }
        } while (!opcion.equals("9"));


    }
}