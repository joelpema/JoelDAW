package com.decroly;


import java.util.Scanner;

import com.Cliente;
import com.Pelicula;
import com.VideoDaw;
import com.Videojuego;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion;
        
        Scanner entrada = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        VideoDaw videoclub = null;
        Cliente cliente = null;
        Pelicula pelicula = null;
        Videojuego videojuego = null;


        System.out.println("¡¡Bienvenido a VideoDaw!!");

        do {
            sc = new Scanner(System.in);
            System.out.println("\nMenú");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Crear y registrar cliente en videoclub");
            System.out.println("4. Alquilar. ");
            System.out.println("5. Devolver");
            System.out.println("6. Dar de baja cliente. ");
            System.out.println("7. Dar de baja articulo. ");
            System.out.println("8. Salir");

            sc = new Scanner(System.in);
            opcion = sc.nextLine();
            sc.nextLine();
            
            if (opcion.equals("1")) {

                
            
            } else if (opcion.equals("2")) {

                
            } else if (opcion.equals("3")) {


            } else if (opcion.equals("4")) {

                 
            } else if (opcion.equals("5")) {

                
            } else if (opcion.equals("6")) {


            } else if (opcion.equals("7")) {


            }else { 
                System.out.println("introduce una opcion correcta en el menu!");

            }

        } while (!opcion.equals("8"));
    }
}    

