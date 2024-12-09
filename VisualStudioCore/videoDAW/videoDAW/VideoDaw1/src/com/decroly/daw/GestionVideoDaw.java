package com.decroly.daw;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class GestionVideoDaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc = new Scanner(System.in);
		String opcion; 
		
		VideoDaw Franquicia = null; 
		Pelicula nuevaPelicula = null; 
		Cliente nuevoCliente = null; 

	
		final String patronCif = "[A-Z][0-9]{8}"; 
		final String patronDNI = "[0-9]{8}[A-Z]"; 


		System.out.println("\nBienvenido a VideoDaw");
		
	do{

		sc = new Scanner(System.in);
		System.out.println("\n1. Crear y Registrar Videoclub");
		System.out.println("2. Registrar pelicula en videoclub");
		System.out.println("3. Crear y registrar cliente en videoclub");
		System.out.println("4. Alquilar pelicula");
		System.out.println("5. Devolver pelicula");
		System.out.println("6. Dar de baja cliente");
		System.out.println("7. Dar de baja pelicula");
		System.out.println("8. SALIR");
		opcion = sc.nextLine();

		
			switch (opcion) {

			
				case "1": 
				sc = new Scanner(System.in);
				System.out.println("\nCREAR NUEVA FRANQUICIA");

				
				String cif = myUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
				String direccion = myUtils.leerTextoPantalla("\nAhora añade la direccion");

				
				Franquicia = new VideoDaw(cif, direccion);
				System.out.println("\nFranqucia registrerada con exito");
				System.out.println(Franquicia.InfoVideoDaw());
					break;

			
				case "2": 
				if(Franquicia != null){
					sc = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVA PELICULA");	

					String titulo = myUtils.leerTextoPantalla("\nEscribe el titulo de la pelicula");
					
					for(int i = 0; i < 1; i++){
						System.out.println("\n¿Cual es el genero de la pelicula? ");
						System.out.println("1. ACCION"); 
						System.out.println("2. ANIME");
						System.out.println("3. COMEDIA");
						System.out.println("4. DRAMA");
						System.out.println("5. FANTASIA");
						System.out.println("6. TERROR ");
						System.out.println("7. DOCUMENTALES");
						sc = new Scanner(System.in);
						int nGenero = sc.nextInt();

						if (nGenero == 1){
							nuevaPelicula = new Pelicula(titulo, Generos.ACCION);	
						}
						if (nGenero == 2){
							nuevaPelicula = new Pelicula(titulo, Generos.ANIME);	
						}
						if (nGenero == 3){
							nuevaPelicula = new Pelicula(titulo, Generos.COMEDIA);
						}
						if (nGenero == 4){
							nuevaPelicula = new Pelicula(titulo, Generos.DRAMA);
						}
						if (nGenero == 5){
							nuevaPelicula = new Pelicula(titulo, Generos.FANTASIA);
						}
						if (nGenero == 6){
							nuevaPelicula = new Pelicula(titulo, Generos.TERROR);
						}
						if (nGenero == 7){
							nuevaPelicula = new Pelicula(titulo, Generos.DOCUMENTALES);
						}

						
						else if(nGenero > 6 && nGenero < 1){
							System.out.println("ERROR. El dato introducido es invalido");
							i -= 1;
						}
					}

					
					if (nuevaPelicula != null){
						System.out.println("Pelicula registrada correctamente");
						System.out.println(nuevaPelicula.InfoPelicula());
						Franquicia.nuevaPelicula(nuevaPelicula);
					}
				}
				else{
					System.out.println("Antes de añadir una pelicula, registre una franquicia por favor.");
				}				
					break;

			
				case "3":
				if (Franquicia != null){
					sc = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVO CLIENTE");	

				
					String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "\nIntroduce el DNI");
					String nombre = myUtils.leerTextoPantalla("\nEscribe el nombre");
					String direccionCliente = myUtils.leerTextoPantalla("\nEscribe una direccion");
					LocalDate fechaDeNacimiento = myUtils.leerFecha();

				
					LocalDate hoy = LocalDate.now();
					Period Edad = Period.between(fechaDeNacimiento, hoy);
					if (Edad.getYears() >= 18){
						
						nuevoCliente = new Cliente(dni, nombre, direccionCliente, fechaDeNacimiento);

						
						if (Franquicia.nuevoCliente(nuevoCliente) == true){
							
							System.out.println("Cliente registrado con exito");
							System.out.println(nuevoCliente.InfoCliente());
						}
						else{
							System.out.println("cliente ya registrado");
						}
					}
					else{
						System.out.println("El cliente debe ser mayor de edad");
					}
				
				}
				else {
					System.out.println("Antes de añadir un cliente, registre una franquicia por favor.");
				}
					break;
				case "4": 
				sc = new Scanner(System.in);

				
				if(Franquicia != null && Franquicia.getNpeliculas() > 0 &&
				 nuevaPelicula != null && nuevoCliente != null){

					
					System.out.println("Quien va a alquilar la pelicula. Introducir numero de codigo de socio");
					System.out.println(Franquicia.mostrarClientes());	 
					int cliente = sc.nextInt();
				
					
					System.out.println("¿Que pelicula quieres alquilar? Introducir numero de codigo de la pelicula");
					System.out.println(Franquicia.mostrarPeliculasNoAlquiladas());
					int pelicula = sc.nextInt();

					
					if(Franquicia.PeliculaPorPosicion(pelicula).isAlquilada() == false){

						Franquicia.alquilarPelicula(cliente, pelicula);
						Franquicia.ClientePorPosicion(cliente).addPelicula
						(Franquicia.PeliculaPorPosicion(pelicula));

						System.out.println(Franquicia.ClientePorPosicion(cliente).mostrarPeliculas());	
					} else if (Franquicia.PeliculaPorPosicion(pelicula).isAlquilada() == true){
						System.out.println("La pelicula seleccionada ya esta alquilada");
					}
				}else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas o Cliente en el Videoclub.");
					}
					break;

		
				case "5": 

				
				if(Franquicia != null && Franquicia.getNclientes() > 0 && 
				nuevaPelicula != null && nuevoCliente != null){

					
					System.out.println("Quien va a devolver la pelicula");
					System.out.println(Franquicia.mostrarClientes());	 
					int bajacliente = sc.nextInt();

					
					if(Franquicia.ClientePorPosicion(bajacliente).getNalquiladas() > 0){

						
						System.out.println("Selecciona pelicula a devolver");
						System.out.println(Franquicia.ClientePorPosicion(bajacliente).mostrarPeliculas());
						int bajapelicula = sc.nextInt();

						
						Franquicia.devolverPelicula(bajacliente, bajapelicula);
						Franquicia.ClientePorPosicion(bajacliente).elimPelicula
						(Franquicia.PeliculaPorPosicion(bajapelicula));

						
						System.out.println("Registro movimientos: ");
						Franquicia.ClientePorPosicion(bajacliente).mostrarPeliculas();
					} else{
						System.out.println("No hay peliculas alquiladas, alquila alguna pelicula.");
						}	
				} else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
					}
				break;

			
				case "6": 
				sc = new Scanner(System.in);

				
				if(Franquicia != null && Franquicia.getNclientes() > 0){

				
				System.out.println(Franquicia.mostrarClientes());
				System.out.println("Introduce la posicion del cliente a dar de baja");
		    	int numSocio = sc.nextInt();

				
				Franquicia.BajaCliente(nuevoCliente, numSocio);
				} else{
					System.out.println("No hay clientes registrados");
				}
					break;

			
				case "7": 
				sc = new Scanner(System.in);

				
				if(Franquicia != null && Franquicia.getNpeliculas() > 0){

			
				System.out.println("Introduce la posicion de la pelicula a dar de baja");
				System.out.println(Franquicia.mostrarPeliculas());
				int cod = sc.nextInt();
				
				
				Franquicia.BajaPelicula(nuevaPelicula, cod);
				} else {
					System.out.println("No hay peliculas registradas");
				}
					break;

			
				case "8":
					System.out.println("Saliendo de VideoDaw. CHAOOOO!!!");
					break;
			
				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("8"));
		sc.close();

		System.out.println("Hasta Pronto");
	}

}
