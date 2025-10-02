package com.decroly;

import java.util.LinkedList;
import java.util.List;

import com.Alquiler;
import com.Articulo;
import com.Cliente;
import com.Pelicula;

public class Main {
    public static void main(String[] args) {

         //conexion base
         if (SQLDatabaseManager.getConecction() != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }


        SQLAcessVideoDaw VideoDawData = new SQLAcessVideoDaw();
        Pelicula miPelicula;
        List<Alquiler> alquileres = new LinkedList<>();
        
        //MENU
        List<String> principal = new LinkedList<>();
        System.out.println("1 Mostrar todos los Articulos en el Inventario.");
        System.out.println("2 Mostrar articulos disponibles.");
        System.out.println("3 Buscar articulo por codigo.");
        System.out.println("4 Buscar cliente por codigo");
        System.out.println("5 Alquilar articulo.");
        System.out.println("6 Devolver articulo.");
        System.out.println("7 SALIR");
        String Principal = "";

        do {
            Principal = myUtils.generarMenu(principal);
            System.out.println("Opcion escogida: "+Principal);
            switch (Principal) {
                
                case "1": //MOSTRAMOS todos los articulos
                    System.out.println("\n" + "Articulos en el inventario: ");
                    List<Articulo> names = VideoDawData.getArticulos();

                    for(Articulo nm : names){
                        System.out.println(nm);
                    }
                    break;

                case "2": //Mostramos articulos disponibles
                    System.out.println("Peliculas disponibles: \n");
                        List<Articulo> pelisNA = VideoDawData.getPeliculasNoAlquiladas();

                        for(Articulo nm : pelisNA){
                            System.out.println(nm);
                        }

                    System.out.println("\nVideojuegos disponibles: \n");
                        List<Articulo> videojuegossNA = VideoDawData.getVideoJuegosNA();

                        for(Articulo nm : videojuegossNA){
                            System.out.println(nm);
                        }
                    break;
                
                case "3": //Buscamos articulo por codigo
                    System.out.println("Buscar articulo por codigo");
                    int cod = myUtils.leerNumeroPantalla("Introduce el codigo del articulo");

                    List<Articulo> artCod = VideoDawData.getArticuloCodigo(cod);

                    for(Articulo nm : artCod){
                        System.out.println(nm);
                    }
                    break;
                
                case "4": //Buscamos cliente por codigo
                    System.out.println("Buscar cliente por codigo");
                    int codCliente = myUtils.leerNumeroPantalla("Introduce el codigo del cliente");

                    List<Cliente> clienteCod = VideoDawData.getClienteCod(codCliente);

                    for(Cliente c : clienteCod){
                        System.out.println(c);
                    }
                    break;

                case "5": //Alquilar articulo
                    System.out.println("Alquilar articulo");
                    int Cliente = myUtils.leerNumeroPantalla("Introduce el codigo del cliente que va a alquilar");
                    int Art = myUtils.leerNumeroPantalla("Introduce el codigo del articulo a alquilar");

                    Alquiler alquiler = new Alquiler(Cliente, Art);
                    alquileres.add(alquiler);
                    int response = VideoDawData.insertAlquiler(alquiler);
                    int estado = VideoDawData.actEstadoTrue(Art);

                    System.out.println("Se ha insertado " + response + " elementos");
                    break;

                case "6": //Devolver articulo
                    int codAlquiler = myUtils.leerNumeroPantalla("Introduce el codigo del alquiler");
                    Alquiler alq = alquileres.get(codAlquiler);

                    int response2 = VideoDawData.insertDevolucion(alq);
                    int estado2 = VideoDawData.actEstadoFalse(alq.getCodArticulo());
                    System.out.println("Se ha insertado " + response2 + " elementos");
                    break;

                case "7"://Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default://Opcion por defecto
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida.");
                    break;
            }
        } while (!Principal.equals("7"));
    }

}