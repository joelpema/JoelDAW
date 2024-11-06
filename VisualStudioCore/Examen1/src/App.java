
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N = 0;
        System.out.println("Escribe la cantidad de numeros que quieras que se escriban en este programa:"); // hago el array y pido que me den el numero total de numeros a almacenar
	    N = sc.nextInt(); 
	    int[] numeros = new int[N];


	        String opciones = "";// creo el menu
             // hago mayusculas todas las letras para que si ponen minusculas lo lea igual
            
            sc = new Scanner(System.in);
			System.out.println("A. Modificar coleccion");
			System.out.println("B. Estadisticas de la coleccion");
			System.out.println("C. Ampliar el valor de la coleccion");
            System.out.println("D. Salir");
			opciones = sc.nextLine();
            opciones = opciones.toUpperCase();// hago mayusculas todas las letras para que si ponen minusculas lo lea igual

	     do {
            String opcionesA = "";
            String opcionesB = "";
            
			if(opciones.equals("A")){
                
                System.out.println("MODIFICAR COLECCION\n");
                System.out.println("a. Insertar numero (no nulo)");
			    System.out.println("b. borrar numero de una posicion especifica");
			    System.out.println("c. modificar un numero de una posicion especifica");
                System.out.println("d. Mostrar numeros");
                sc = new Scanner(System.in);
                opcionesA = sc.nextLine();
                opcionesA = opcionesA.toUpperCase();// hago mayusculas todas las letras para que si ponen minusculas lo lea igual

                if(opcionesA.equals("A")){

                    System.out.print("Introduce la posición del (0 - "+ (N-1) +") ");
                    int posicion = sc.nextInt();
                    System.out.print("Introduce el valor: ");
                    int valor = sc.nextInt();

                 if (posicion >= 0 && posicion < numeros.length) {
                     numeros[posicion] = valor;
                     System.out.println("Valor " + valor + " introducido en la posición " + posicion);
                 
                    }
                }

                }
                if(opcionesA.equals("B")){

                    System.out.println("introduce la posicion el numero que quieres eliminar: ");
                    int posicion2 = sc.nextInt();
                    
                    if (posicion2 >= 0 && posicion2 < numeros.length) {
                        numeros[posicion2] = 0;
                        System.out.println("el valor de la posicion " + posicion2 + " se a borrado");
                    }

                
                }
                if(opcionesA.equals("C")){
                    System.out.println("Modificar numero de la posicion especifica");

                    System.out.print("Introduce la posición del (0 - "+ N +") ");
                    int posicion3 = sc.nextInt();
                    System.out.print("Introduce el valor: ");
                    int valor2 = sc.nextInt();

                    if (posicion3 >= 0 && posicion3 < numeros.length) {
                        numeros[posicion3] = valor2;
                        System.out.println("Valor " + valor2 + " introducido en la posición " + posicion3);
                    }else {
                        System.out.println("posicion no valida, debe estar entre 0 y " + posicion3);
                    }
                
                }
                if(opcionesA.equals("D")){
                    System.out.println("Mostrar numeros");

                    for (int i = 0; i < numeros.length; i++) {
		    			 
                        System.out.println("El valor del numero "+(i+1) + " es "+ numeros[i] );
                        
                    }
                   
                    
                }



            else if (opciones.equals("B")){

                System.out.println("ESTADISTICAS DE COLECCION:\n");
                System.out.println("A. Media de todos los valores no nulos");
			    System.out.println("B. Suma de todos los valores");
			    System.out.println("C. Maximo de la coleccion");
                System.out.println("D. Minimo de la coleccion");
                sc = new Scanner(System.in);
                opcionesB = sc.nextLine();
                opcionesB = opcionesB.toUpperCase();

                if(opcionesB.equals("A")){
                    System.out.println("Media de todos los valores");
                    
                    double cNumeros = 0;
                    double aMax = numeros[0];
                    double aMin = numeros[0];

                    for (int i = 0; i < numeros.length; i++) {
                        cNumeros += numeros[i];
                        if (numeros[i] > aMax) {
                            aMax = numeros[i];
                        }
                        if (numeros[i] < aMin) {
                            aMin = numeros[i];
                        }
                    double aMedia = cNumeros / numeros.length;
                    }


                }
                if(opcionesB.equals("B")){
                    System.out.println("Suma de todos los valores");

                    int suma = 0;
		            for ( int i = 0; i < numeros.length; i++) {
			            suma = suma + numeros[i];
		            } 
		
		            System.out.println("la suma es: " + suma);
                }
                if(opcionesB.equals("C")){
                    System.out.println("Maximo de la coleccion");
                    
                    double cNumeros = 0;
                    double aMax = numeros[0];
                    double aMin = numeros[0];

                    for (int i = 0; i < numeros.length; i++) {
                        cNumeros += numeros[i];
                        if (numeros[i] > aMax) {
                            aMax = numeros[i];
                        }
                        if (numeros[i] < aMin) {
                            aMin = numeros[i];
                        }
                    }    

                    System.out.println("El numero maximo es... " + aMax);
                }
                if(opcionesB.equals("D")){
                    System.out.println("Minimo de la coleccion:");

                    double cNumeros = 0;
                    double aMax = numeros[0];
                    double aMin = numeros[0];

                    for (int i = 0; i < numeros.length; i++) {

                        cNumeros += numeros[i];
                        if (numeros[i] > aMax) {
                            aMax = numeros[i];
                        }
                        if (numeros[i] < aMin) {
                            aMin = numeros[i];
                        }
                    }    
                    System.out.println("El numero minimmo es... " + aMin);

                }



            }else if (opciones.equals("C")){

                System.out.println("AMPLIAR EL VALOR DE LA COLECCION");

                int n2 = sc.nextInt();
                N = n2;

            }else if (opciones.equals("D")){

                System.out.println("hasta luego!!");
            }else {
                System.out.println("escribe una letra que este disponible en el menu");
            }
        
			
	     }while(!opciones.equals("D"));	

    }
}

