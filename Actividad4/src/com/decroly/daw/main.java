package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejercicio 1

		Scanner sc = new Scanner(System.in);
		
		double [] numeros = new double [10];
				
		for ( int i = 0; i < 10; i++) {
			System.out.println("Escribe un numero");
			numeros[i] = sc.nextInt(); 
		} // for1
		
		System.out.println("los numeros que has puesto son: ");
		for ( int i = 0; i < 10; i++){
			System.out.println(numeros[i]);
		}// for2
		
		//Ejercicio2
		
		
		double [] numeros2 = new double [10];
 		
		for ( int i = 0; i < 10; i++) {
			System.out.println("Escribe un numero");
			numeros2[i] = sc.nextInt(); 
		} // for1
		
		 
		double suma = 0;
				
		System.out.println("la suma de todo es: ");
		for ( int i = 0; i < 10; i++) {
			 suma += numeros2[i];
			System.out.println("la suma es " + suma);
		} // for2
		
		
		
		
		
	}

}
