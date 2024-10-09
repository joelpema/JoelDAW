package com.decroly.daw;

import java.util.Scanner;

public class Actividad3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//Ejercicio 1
		
		
		
		
		
		
		
		// Ejercicio 2
		
		String opciones = "";
		double numero1 = 0;
		double numero2 = 0;
		
		
		System.out.println("Bienvenido a mi menu de ");
		
		do {
			sc  = new Scanner(System.in);
			
			System.out.println("(1) Sumar");
			System.out.println("(2) Restar");
			System.out.println("(3) Multiplicar");
			System.out.println("(4) Dividir");
			System.out.println("(5) Salir");
			opciones = sc.nextLine();
			
			
			 if(opciones.equals("1")){
				 
				 System.out.println("Suma \n");
				 System.out.println("introduce el primer numero");
				 numero1 = sc.nextDouble();
				 System.out.println("introduce el segundo numero");
				 numero2 = sc.nextDouble();
				 
				 System.out.println("La Suma es " + (numero1 + numero2));
				 
				 
				 
	         }else if(opciones.equals("2"))
	         {
	        	 System.out.println("Resta \n");
	        	 System.out.println("introduce el primer numero");
				 numero1 = sc.nextDouble();
				 System.out.println("introduce el segundo numero");
				 numero2 = sc.nextDouble();
				 
				 System.out.println("La Resta es " + (numero1 - numero2));
	        	 
	         }else if(opciones.equals("3"))
	         {
	        	 System.out.println("Multiplicacion \n");
	        	 System.out.println("introduce el primer numero");
				 numero1 = sc.nextDouble();
				 System.out.println("introduce el segundo numero");
				 numero2 = sc.nextDouble();
				 
				 System.out.println("La Multiplicacion es " + (numero1 * numero2));
	        	 
	         }else if(opciones.equals("4"))
	         {
	        	 System.out.println("Division \n");
	        	 System.out.println("introduce el primer numero");
				 numero1 = sc.nextDouble();
				 System.out.println("introduce el segundo numero");
				 numero2 = sc.nextDouble();
				 if (numero2 == 0) {
					 
					 System.out.println("el numero 0 no es valido en la division \n");
					 
				 }
				 
				 System.out.println("La Division es " + (numero1 / numero2));
				 
	         }	else if(opciones.equals("5"))
	         {
	        	 System.out.println("hasta pronto");
	        	 
	         }else {
	        	 
	        	 System.out.println("Añade una opcion que sea correcta en el menu");
	        	 
	         }
			
		}while (!opciones.equals("5"));
		
		
	}

}
