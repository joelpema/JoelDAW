package com.decroly.daw;

import java.util.Scanner;

public class Actividad3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//Ejercicio 1
		
		
		
		System.out.println("introduce los euros que vas a meter");
		int dinero = sc.nextInt();
		
		int billete500 = 0;
		int billete200 = 0;
		int billete100 = 0;
		int billete50 = 0;
		int billete20 = 0;
		int billete10 = 0;
		int billete5 = 0;
		int resto = dinero;
		
		
		if (dinero % 5 !=0) {
			System.out.println("el Dinero tiene que ser multiplo de 5");
	
		}
		
		if (dinero >= 500) {
			billete500 = resto / 500;
			 resto= resto % 500;
			
		}
		if (resto >= 200) {
			billete200 = resto / 200;
			resto= resto % 200;
			
		}
		if (resto >= 100) {
			billete100 = resto / 100;
			resto= resto % 100;
			
		}
		if (resto >= 50) {
			billete50 = resto / 50;
			resto= resto % 50;
			
		}
		if (resto >= 20) {
			billete20 = resto / 20;
			resto= resto % 20;
			
		}
		if (resto >= 10) {
			billete10 = resto / 10;
			resto= resto % 10;
			
		}
		if (resto >= 5) {
			billete5 = resto / 5;
			resto= resto % 5;
			
		}
		
		System.out.println("se necesitan " + billete500 + " billetes de 500");
		System.out.println("se necesitan " + billete200 + " billetes de 200");
		System.out.println("se necesitan " + billete100 + " billetes de 100");
		System.out.println("se necesitan " + billete50 + " billetes de 50");
		System.out.println("se necesitan " + billete20 + " billetes de 20");
		System.out.println("se necesitan " + billete10 + " billetes de 10");
		System.out.println("se necesitan " + billete5 + " billetes de 5");
		
		
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
