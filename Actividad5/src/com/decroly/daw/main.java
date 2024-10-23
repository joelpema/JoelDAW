package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ejercicio 1
		
		Scanner sc = new Scanner(System.in);
//
//       
//        System.out.println("Introduce una cadena de texto:");
//        String cadena = sc.nextLine();
//
//        
//        String[] palabras = cadena.split(" ");
//
//        for (String palabra : palabras) {
//            System.out.println(palabra);
//        }
		
		//ejercicio 2
        
//        sc = new Scanner(System.in);
//		
//        System.out.println("Introduce una cadena de texto:");
//        String cadena2 = sc.nextLine();
//		
//        System.out.println("Introduce una segunda cadena de texto:");
//        String cadena3 = sc.nextLine();
//		
//        if (cadena2.equalsIgnoreCase(cadena3)) {
//        	
//        	System.out.println("Son iguales");
//        }else {
//        	System.out.println("No son iguales");
//        }
		
        // Ejercicio 3
//		sc = new Scanner(System.in);
//		
//		System.out.println("Introduce una cadena de texto:");
//	    String nombre = sc.nextLine();
//			
//	    System.out.println("Introduce una segunda cadena de texto:");
//	    String apellido = sc.nextLine();
//	    
//	    System.out.println("Introduce una segunda cadena de texto:");
//	    String apellido2 = sc.nextLine();
//	    
//	    
//	    String codigo = nombre.substring(0,3) + apellido.substring(0,3) + apellido2.substring(0,3);
//	    
//	    System.out.println(codigo.toUpperCase());
	    
	    //Ejercicio 4
        
//		sc = new Scanner(System.in);
//	    
//		System.out.println("Introduce una cadena de texto:");
//	    String palabras = sc.nextLine();
//		
//	    palabras = palabras.toLowerCase();
//	    
//	    int aes = 0;
//	    int ees = 0;
//	    int ies = 0;
//	    int oes = 0;
//	    int ues = 0;
//	    
//	    for (int i = 0; i < palabras.length(); i++) {
//            if (palabras.charAt(i) == 'a') {
//                aes++;
//            }
//        }
//	 
//
//       for (int i = 0; i < palabras.length(); i++) {
//             if (palabras.charAt(i) == 'e') {
//                 ees++;
//             }
//       }
//        
//       for (int i = 0; i < palabras.length(); i++) {
//           if (palabras.charAt(i) == 'i') {
//               ies++;
//           }
//       }
//        
//       for (int i = 0; i < palabras.length(); i++) {
//           if (palabras.charAt(i) == 'o') {
//               oes++;
//           }
//       }
//       
//       for (int i = 0; i < palabras.length(); i++) {
//           if (palabras.charAt(i) == 'u') {
//               ues++;
//           }
//       }
//       
//		
//        System.out.println("Nº de A's: " + aes + "\n" + "Nº de E's: " + ees + "\n" + "Nº de I's: " + ies + "\n" + "Nº de O's: " + oes + "\n" + "Nº de U's: " + ues + "\n");
        
        // Ejercicio 5
        
		sc = new Scanner(System.in);
		  
	    System.out.print("Introduce una frase: ");
	    String texto = sc.nextLine();
	    
	    texto = texto.replaceAll(" ","").toLowerCase();
        
        boolean palindromo = true;
        int longitud = texto.length();
        
        
      
		
		
		
		
		
		
		
		
        
		
	}

}
