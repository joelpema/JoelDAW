package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejercicio 1

		Scanner sc = new Scanner(System.in);
//		
//		double [] numeros = new double [10];
//		
//				System.out.println("Escribe 10 numeros");
//		for ( int i = 0; i < numeros.length; i++) {
//			
//			numeros[i] = sc.nextInt(); 
//		} // for1
//		
//		System.out.println("los numeros que has puesto son: ");
//		for ( int i = 0; i < numeros.length; i++){
//			System.out.println(numeros[i]);
//		}// for2
//		
//		//Ejercicio2
//		
//		sc = new Scanner(System.in);
//		
//		double suma = 0;
//		
//		double [] numeros2 = new double [10];
//		
// 		System.out.println("Escribe un numero");
// 		
//		for ( int i = 0; i < numeros2.length; i++) {
//			
//			numeros2[i] = sc.nextInt(); 
//			suma = suma + numeros2[i];
//		} // for1
//		
//		 System.out.println("la suma es: " + suma);
//		
//				
//		
		//Ejercicio3
//		
//		sc = new Scanner(System.in);
//		
//		double [] numeros3 = new double [10];
//				
//			double max = Double.MIN_VALUE;
//	 		double min = Double.MAX_VALUE;
//	 		System.out.println("Escribe un 10 numeros");
//	 		
//		for ( int i = 0; i < numeros3.length; i++) {
//			
//			numeros3[i] = sc.nextInt(); 
//				max = Math.max(max, numeros3 [i]);
//			min = Math.min(min, numeros3 [i]);
//		} // for1
//		
//		System.out.println("El numero maximo es: " + max);
//		System.out.println("El numero minimo es: " + min);
//		
		//Ejercicio4
//		
//		sc = new Scanner(System.in);
//		
//		double [] numeros4 = new double [20];
//		
//		double positivos = 0;
//		double negativos = 0;
//		
//		for (int i = 0; i < numeros4.length; i++) {
//			System.out.println("Escribe un numero");
//			
//			numeros4[i] = sc.nextInt(); 
//			
//			if (numeros4[i] < 0) {
//				negativos += numeros4[i]; 
//				
//			}else if (numeros4[i] > 0){
//				positivos += numeros4[i];
//				
//			}
//			
//		}//for1
//			
//		
//		System.out.println("los numeros positivos son:" + positivos);
//		System.out.println("los numeros negativos son:" + negativos);
		
		//Ejercicio5
		
//		sc = new Scanner(System.in);
//		
//		double[] numeros5 = new double[20];
//		
//		double suma = 0;
//		double media = 0;
//		
//		for (int i = 0; i < numeros5.length; i++) {
//			
//			System.out.println("Escribe un numero");
//			
//			numeros5[i] = sc.nextInt();
//
//			suma += numeros5[i];
//			
//			media = suma / 20;
//		}
//		
//		System.out.println("la media de los valores es: " + media);
		
		
		//Ejercicio6 
		
//		sc = new Scanner(System.in);
//		
//		int N = 0;
//		int M= 0;
//		
//		System.out.println("Escribe el numero N");		
//		N = sc.nextInt();
//		
//		System.out.println("Escribe el numero M");		
//		M = sc.nextInt();
//		
//		double[] numeros6 = new double[N];
//		
//		for (int i = 0; i < N; i++){
//		
//			numeros6[i] = M;
//		
//			System.out.println("estos son los numeros " + numeros6[i]);
//		}
//		
//		
		//Ejercicio7
//		
//		sc = new Scanner(System.in);
//		
//		int P = 0;
//		int Q= 0;
//		int array = 0;
//		
//		System.out.println("Escribe el numero P");		
//		P = sc.nextInt();
//		
//		System.out.println("Escribe el numero Q");		
//		Q = sc.nextInt();
//		
//		if (P > Q) {
//			System.out.println("el valor de P tiene que ser menor o igual que el valor de Q");
//		}else {
//		
//			array = Q - P ;
//		
//			double[] numeros7 = new double[array];
//		
//			for (int i = 0; i <= array; i++){
//		
//				numeros7[i] = P + i;
//			
//				System.out.println("el array desde P hasta Q es:" + numeros6[i]);
//			}
//		}
//		
		//Ejercicio8
		
//		sc = new Scanner(System.in);
//		
//		double[] numeros8 = new double[100];
//		
//		
//		for (int i = 0; i < numeros8.length ; i++){
//			
//			numeros8[i] = Math.random();	
//		}
//		
//		System.out.println("dame un valor R: ");
//		double R = sc.nextDouble();
//		
//		int contador = 0;
//        for (double num : numeros8){
//            if (num >= R) {
//                contador++;
//            }
//        }
//		
//        System.out.println("hay " + contador +  " numeros iguales o mayores que " + R);
        
		// Ejercicio9
		
//		int [] numeros9 = new int [100];
//		int N = 0;
//		
//		System.out.println("Escribe la posicion N");
//	    	N = sc.nextInt(); 
//	    boolean esta = false;	
//	    	
//	    	
//	    for (int i = 0; i < numeros9.length; i++) {
//	    	numeros9[i] = (int) (Math.random() * 10 + 1);
//	    	
//	    	if (numeros9[i] == N) {
//	    		esta = true;
//	    		System.out.println("Esta en la posicion" + i);
//	    		
//	    	}
//	    }
 		
		// Ejercicio 10
//		
//		 System.out.print("Introduce el número de personas: ");
//	     int N = sc.nextInt();
//		
//	     double[] alturas = new double[N];
//		
//	     for (int i = 0; i < N; i++) {
//	    	 System.out.print("Introduce la altura de la persona: ");
//	     	 alturas[i] = sc.nextDouble();
//	     }
//	     
//	     double sAlturas = 0;
//	        double aMax = alturas[0];
//	        double aMin = alturas[0];
//	     
//	     for (int i = 0; i < N; i++) {
//	         sAlturas += alturas[i];
//	         if (alturas[i] > aMax) {
//	             aMax = alturas[i];
//	     }
//	         if (alturas[i] < aMin) {
//	             aMin = alturas[i];
//	         }
//	     }
//	     
//	     double aMedia = sAlturas / N;
//		
//	     int PEMedia = 0;
//	     int PDMedia = 0;
//		 
//	     for (int i = 0; i < N; i++) {
//	    	 if (alturas[i] > aMedia) {
//	             	PEMedia++;
//	     } else if (alturas[i] < aMedia) {
//	                PDMedia++;
//	        }
//	     }
//	     
//	     System.out.println("la altura media es:" + aMedia);
//	     System.out.printf("La altura Minima:", aMin);
//	     System.out.printf(" La altura máxima es: ", aMax);
//	     System.out.println("Personas por encima de la media: " + PEMedia);
//	     System.out.println("Personas por debajo de la media: " + PDMedia);
//	     
	     //Ejercicio 11
//	     
//	     int[] numeros11 = new int[100];
//	     int [] alreves = new int[100];
//	     
//	     for (int i = 0; i < numeros11.length; i++) {
//	    	 
//	    	 numeros11[i] = i + 1;
//	    	 //alreves[i] = 100 - i;
//	    	 
//	    	 System.out.println("los numeros son: " + numeros11[i]);
//	     }
//	     
//	     for(int i =0; i < numeros11.length;i++)
//	     {
//	    	 alreves[i] = numeros11[numeros11.length -1 - i];
//	    	 System.out.println("los numeros inversos son: " + alreves[i]);
//	     }
//	    
//	     
	     // Ejercicio 12
	     
	     String opciones = "";
	     
	     int[] numeros12 = new int[10];
	     

	     
	     
	     do {
	     	sc  = new Scanner(System.in);
			
			System.out.println("a. Mostrar valores");
			System.out.println("b. Introducir valor");
			System.out.println("c. salir");
			opciones = sc.nextLine();
			
			if(opciones.equals("a")){
				 
			     for (int i = 0; i < numeros12.length; i++) {
		    			 
			    	 System.out.println("El valor del numero "+(i+1) + " es "+ numeros12[i] );
			    	 
			     }
				
				 
	         }else if(opciones.equals("b"))
	         {
	        	 System.out.print("Introduce la posición (0-9): ");
                 int posicion = sc.nextInt();
                 System.out.print("Introduce el valor: ");
                 int valor = sc.nextInt();

                 
                 if (posicion >= 0 && posicion < numeros12.length) {
                     numeros12[posicion] = valor;
                     System.out.println("Valor " + valor + " introducido en la posición " + posicion);
                 }else {
                	 System.out.println("posicion no valida, debe estar entre 0 y 9,");
                 }
                 
                 
	        	 }else if(opciones.equals("c")){
	        	 System.out.println("Hasta pronto");
	        	 
	         }else { 
	        	 System.out.println("Añade una opcion que sea correcta en el menu");
	         }
			
	     }while(!opciones.equals("c"));			
	     
	}     
	     
}