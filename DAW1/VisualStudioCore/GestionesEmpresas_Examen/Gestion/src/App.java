
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String opcion;
        int numero_de_trabajadores =0;

        Empresa misClientes = null;
        Trabajador nuevoTrabajador = null;

        final String patronCif = "[A-Z][0-9]{10}";
        final String patronDNI = "[0-9]{8}[A-Z]";

        Scanner sc = new Scanner(System.in);
		System.out.println("\nCREAR NUEVA FRANQUICIA");

		//Recogemos datos
		String cif = MyUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
		String direccion = MyUtils.leerTextoPantalla("\nAhora añade el Nombre de la empresa");
        LocalDate fechaFundacion = MyUtils.leerFecha();
        

		
		misClientes = new Empresa(direccion, cif, fechaFundacion);
		System.out.println(misClientes.InfoEmpresa());


        do { 
            sc = new Scanner(System.in);

            System.out.println("\n1-Crear Persona");
            System.out.println("2-Registrar Trabajador en empresa");
            System.out.println("3-Mostrar informacion general de la empresa");
            System.out.println("4-Mostrar el número de trabajadores actuales ");
            System.out.println("5-Mostrar informacion de todos los trabajadores");
            System.out.println("6-Eliminar trabajador de la empresa");
            System.out.println("7-Eliminar persona del programa");
            System.out.println("8-Salir de la aplicacion");
            opcion = sc.nextLine();
        switch (opcion) {

			//Crear Persona
				case "1": 
               
                String dni = MyUtils.comprobarPatronRepetidamente(patronDNI, "\nIntroduce el DNI");
				String nombre = MyUtils.leerTextoPantalla("\nEscribe el nombre");
				String direccionCliente = MyUtils.leerTextoPantalla("\nEscribe una direccion");
				LocalDate fechaNacimiento = MyUtils.leerFecha();

                nuevoTrabajador = new Trabajador(dni, nombre, direccionCliente, fechaNacimiento);
                System.out.println(misClientes.mostrarTrabajador());
                
					break;

			//REGISTRAR TRABAJADOR EN LA EMPRESA
				case "2": 
                if (misClientes != null){
                    System.out.println("que cliente va a ser registrado? pon la posicion");

					System.out.println(nuevoTrabajador.InfoTrabajador()); 
					int cliente = sc.nextInt();

                    System.out.println("Trabajador registrado con exito");
                    numero_de_trabajadores++;
                }		
					break;

			//Mostrar información general de la empresa
				case "3":

                System.out.println("LA INFORMACION DE LA EMPRESA ES...\n");
                
                misClientes = new Empresa(direccion, cif, fechaFundacion);
                System.out.println(misClientes.InfoEmpresa());	
				
					break;

			//Mostrar informacion de todos los trabajadores
				case "4": 

                System.out.println("EL NUMERO DE TRABAJADORES ACTUALES ES:\n");
                System.out.println(numero_de_trabajadores);
                

					break;

			//Eliminar trabajador de la empresa
				case "5": 

                System.out.println("LA INFORMACION DE CADA TRABAJADOR ES...\n");
                
                System.out.println(nuevoTrabajador.InfoTrabajador());	 
                
				
				break;

			//Eliminar persona del programa
				case "6": 

                if(misClientes != null && misClientes.getMaximoTrabajadores() >= 0){

                    //Seleccionamos cliente a dar de baja
                    System.out.println(misClientes.mostrarTrabajador());
                    System.out.println("Introduce la posicion del trabajador que vas a eliminar");
                    int numSocio = sc.nextInt();
                    System.out.println("Trabajador Eliminado con Exito");
    
                    //Damos de baja al cliente seleccionado
                    misClientes.eliminarTrabajador(nuevoTrabajador, numSocio);
                    numero_de_trabajadores--;
                    } else{
                        System.out.println("No hay clientes registrados");
                    }
                

				break;

                case "7":  
                
                System.out.println(misClientes.mostrarTrabajador());
                System.out.println("Introduce la posicion de la persona que borraras");
                int numPersona = sc.nextInt();
                
                break;

			//SALIR
				case "8":
					System.out.println("Saliendo de GestoresEmpresas. ¡Hasta pronto!");
					break;
			
				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("8"));
		
        
    }
}

