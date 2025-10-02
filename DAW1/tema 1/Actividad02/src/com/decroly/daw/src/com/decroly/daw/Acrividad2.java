package com.decroly.daw;

import java.util.Scanner;

public class Acrividad2 {

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
		
		
		// Ejercicio 8
		
		
		sc = new Scanner (System.in);
		System.out.println("un numero N");
		int NN = sc.nextInt();
		
		int  factorial=1;
	
		if (NN < 0) {
			System.out.println("tiene que ser positivo");
		}
		for (int i = 1; i <= NN; i++) {
			 factorial *= i;
		}
		
		System.out.println("El factorial de " + NN + " es: " + factorial);
		
		
		
		// ejercicio 9
		
		sc = new Scanner(System.in);
        System.out.println("escribe la hora que es ");
        int horas = sc.nextInt();

        System.out.println("escribe los minutos que son ");
        int minutos = sc.nextInt();
        

        System.out.println("escribe los segundos que son ");
        int segundos = sc.nextInt();

        segundos = segundos + 1 ;

        if  (segundos == 60){
            segundos = 0;
            minutos ++;
        }
        if (minutos == 60){
            minutos = 0; 
            horas ++;
        }
        if (horas == 24){
            horas = 0;
        }
        
        System.out.println("la hora un segundo despues es: " + horas + ":" + minutos + ":" + segundos );

        
        //ejercicio 10	
		
		sc = new Scanner(System.in);
		 boolean Negativo = false;
		int contador = 0; 
        
        while (contador < 10) {
            System.out.print("Ingrese el número (no nulo): ");
            double num = sc.nextDouble();

            
            if (num == 0) {
                System.out.println("El número no puede ser nulo, intente de nuevo.");
                continue;  
            }

            if (num < 0) {
                Negativo = true;
            }

            contador++;
        }
        if (Negativo) {
        System.out.println("si hay algun numero negativo");
        }else {
        	System.out.println("no hay ningun numero negativo");
        }
        
        //ejercicio 11
        
        sc = new Scanner(System.in);
		int positivos = 0;
		int negativos = 0;
		int contador1 = 0;
		
        while (contador1 < 10) {
            System.out.print("Ingrese el número (no nulo): ");
            double num = sc.nextDouble();

            
            if (num == 0) {
                System.out.println("El número no puede ser nulo, intente de nuevo.");
                continue;  
            }

            if (num < 0) {
               positivos++;
            }else {
            	negativos++;
            }

            contador1++;
        }
        
        System.out.println("hay " + negativos + " numeros negativos");
        
        System.out.println("hay " + positivos +  " numeros positivos");
        
        // ejercicio 12
        
        
        sc = new Scanner(System.in);
		int positivo = 0;
		int negativo = 0;
		int num = 0;
		boolean hayNegativos = false;
		
		System.out.print("Ingrese el número. Cuando pongas 0 el ciclo se acabara");
		
        do {
        	
        	System.out.print("Ingrese el número");
            num = sc.nextInt();
            
            if (num > 0) {
               positivo++;
            }
            
            if  (num < 0){
            	hayNegativos = true;
            	negativo++;
            }	
            
        }while (num !=0);
        
         if (hayNegativos) {
            	System.out.println("si hay numeros negativos");
            }
        System.out.println("hay " + negativo + " numeros negativos");     
        System.out.println("hay " + positivo +  " numeros positivos");
        
        //ejercicio 13
        
        System.out.print("Numeros naturales del 1 al 10");
        int suma = 0;
        int producto = 1;

        
        for (int i = 1; i <= 10; i++) {
            suma += i;        
            producto *= i;    
        }

        System.out.println(" La suma es... " + suma);
        System.out.println(" El producto es... " + producto);
		
        // ejercicio 14
		
		System.out.println("escribe el nombre del trabajador");
		String nombre = sc.nextLine();
        
		System.out.println("escribe las horas trabajadas");
		double nHoras = sc.nextDouble();
		
		System.out.println("escribe las tarifa por horas");
		double nTarifa = sc.nextDouble();
		
		double salarioBruto;
	
		if (nHoras <= 35) {
			salarioBruto = nHoras * nTarifa;

		}else {
	
		double nExtras = nHoras - 35; 
		
		salarioBruto = (35 * nTarifa) + (nExtras * nTarifa * 1.5);
		
		}
		
		double impuestos = 0;
        if (salarioBruto > 900) {
        	
            impuestos += (salarioBruto - 900) * 0.45;   
            impuestos += 400 * 0.25;    
            
        } else if (salarioBruto > 500) {
            impuestos += (salarioBruto - 500) * 0.25;   
        }
		
        double salarioNeto = salarioBruto - impuestos;
        
        System.out.println("Salario bruto: " + salarioBruto + "€");
        System.out.println("Tasas de impuestos: " + impuestos + "€");
        System.out.println("Salario neto: " + salarioNeto + "€");
        	
				
	} //Main

} //Actividad