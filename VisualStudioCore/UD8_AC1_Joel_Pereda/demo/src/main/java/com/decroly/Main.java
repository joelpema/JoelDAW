package com.decroly;

import java.util.List;
import java.util.Scanner;

import com.TablaProductos;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        
        do {
            System.out.println("\nMenú de Inventario:");
            System.out.println("1. Mostrar todos los Productos en el Inventario.");
            System.out.println("2. Buscar producto por referencia.");
            System.out.println("3. Buscar productos por tipo.");
            System.out.println("4. Buscar producto por cantidad.");
            System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
            System.out.println("6. Eliminar Producto por referencia.");
            System.out.println("7. Actualizar producto.");
            System.out.println("8. Insertar un nuevo tipo de producto.");
            System.out.println("9. Salir");

            
            opcion = scanner.nextLine();
            scanner.nextLine();
            
            if (opcion.equals("1")) {
            

                 SQLAccessProgramacion miDcData = new SQLAccessProgramacion();

                List<TablaProductos> characters = miDcData.getCharacters();

                for(TablaProductos c : characters){
                    System.out.println(c);
                }


            } else if (opcion.equals("2")) {

            } else if (opcion.equals("3")) {

            } else if (opcion.equals("4")) {
               
            } else if (opcion.equals("5")) {

            } else if (opcion.equals("6")) {

            } else if (opcion.equals("7")) {
              
            } else if (opcion.equals("8")) {
               
            } else if (opcion.equals("9")) {
                
            } else {
                
            }
        } while (!opcion.equals("9"));


    }
}