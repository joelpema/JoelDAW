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
				if (edad < 18 )
				{
					System.out.println("eres menor de edad ");
					
				}
				
		
		
		
	} //Main

} //Actividad
