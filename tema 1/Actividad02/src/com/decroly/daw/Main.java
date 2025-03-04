package com.decroly.daw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ejercicio 1
		
		Scanner sc = new Scanner (System.in);
		System.out.println("escribe tu edad: ");
		int edad = sc.nextInt();
		
		if (edad >= 18 )
		{
			System.out.println("eres mayor de edad ");
			
		}
	
				
		// ejercicio 2
		
		sc = new Scanner (System.in);
		System.out.println("escribe tu edad: ");
		int edad1 = sc.nextInt();
		
		if (edad1 >= 18 )
		{
			System.out.println("eres mayor de edad ");
			
		}
		if (edad1 < 18 )
		{
			System.out.println("eres menor de edad ");
			
		}
		
		
		// ejercicio 3
		
		System.out.println("numeros narutales del 1 al 20");
		
		for (int i = 1; i <= 20 ; i++) {
			System.out.println(i);
		}// for
			
		// ejercicio 4
		
		System.out.println("numeros pares del 1 al 200 sumando de 2 en 2");
		for (int i = 0; i <= 200 ; i= i + 2) {
			System.out.println(i);
		}// for
			
	    //Ejercicio 5
		
		System.out.println("numeros pares del 1 al 200 sumando de 1 en 1");
		for (int i = 0; i <= 200 ; i= i + 1) {
			if (i % 2 == 0) {
			System.out.println(i);
			}// if
		}// for
		
		// ejercicio 6
		
		sc = new Scanner (System.in);
		System.out.println("escribe un numero N ");
		int N = sc.nextInt();
		
		for (int i = 1; i <= N ; i= i + 1) {
		
			System.out.println(i);
			
		}//for	
		
		// ejercicio 7
		
		sc = new Scanner (System.in);
		System.out.println("escribe una nota del 1 al 10 ");
		double Nota = sc.nextDouble();
		
		if (Nota < 3) {
			System.out.println("Muy Deficiente");
			
		} else if (Nota < 5) {
			System.out.println("Insuficiente");
			
		} else if (Nota < 6) {
			System.out.println("Bien");
			
		} else if (Nota < 9) {
			System.out.println("Notable");
		} else if (Nota < 10) {
			System.out.println("Sobresaliente");
		}
				
				
		
		
		
	} //Main

} //Actividad
