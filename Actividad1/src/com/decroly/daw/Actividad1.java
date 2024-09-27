package com.decroly.daw;

import java.util.Scanner;

public class Actividad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Buenos Dias"); //Ejercicio 1
		
		//Rjercicio 2
		
		double lado1 = 5;
		
		System.out.println(lado1 * lado1); 
		
		//Ejercicio 3
		
		Scanner reader = new Scanner (System.in);
		System.out.println("Escribe el lado:");
		double lado = reader.nextDouble();
		
		System.out.println("El area es " + lado * lado);
		
		//Ejercicio 4
		
		reader = new Scanner (System.in);
		
		System.out.println("Escribe el numero1: ");
		double numero1 = reader.nextDouble();
		
		System.out.println("Escribe el numero 2: ");
		double numero2 = reader.nextDouble();
		
		 System.out.println("valor de suma " + (numero1 + numero2));
		 System.out.println("valor de resta " + (numero1 - numero2));
		 System.out.println("valor de producto " + (numero1 % numero2));
		 System.out.println("valor de division " + (numero1 / numero2));
		 
		 //Ejercicio 5
		 
		 reader = new Scanner(System.in);
		 System.out.println("Escribe la longitud del radio");
		 double radio = reader.nextDouble(); 
		 
		 double ladocircunferencia = 2 * Math.PI * radio;
		 double areacirculo = Math.PI * Math.pow(radio,2);
		 double volumenesfera = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
		 
		 System.out.println("La longitud de la circunferencia es: " + ladocircunferencia);
		 System.out.println("El area del circulo es: " + areacirculo);
		 System.out.println("El volumen de la es: " + volumenesfera);
		
		 //Ejercicio 6
		 
		 reader = new Scanner(System.in);
		 System.out.println("Precio del articulo actual: ");
		 double articuloactual = reader.nextDouble();
		 
		 System.out.println("Precio del articulo inicial: ");
		 double articuloinicial = reader.nextDouble();
		 
		 double descuento = ((articuloinicial - articuloactual) / articuloinicial) * 100;
		 
		 System.out.println("El descuento realizado es de un " + descuento + "%" );
		 
		 //Ejercicio 7
		 
		 System.out.println("Distancia en millas marinas = ");
		 double millas = reader.nextDouble();
		 
		 double metros = millas * 1852;
		 System.out.println("La distancia en metros es: " + metros);
		 
		 //Ejercicio 8
		 
		 reader= new Scanner(System.in);
		 System.out.println("Escribe un numero: ");
		 double numero3 = reader.nextDouble();
		 
		 System.out.println("Escribe otro numero");
		 double numero4 = reader.nextDouble();
		 
		 
		 double menor = Math.min(numero3, numero4);
		 double mayor = Math.max(numero3, numero4);
		 
		 System.out.println("el orden de menor a mayor es " + menor + " " + mayor);
		 
		 //Ejercicio 9

		 reader= new Scanner(System.in);
		 System.out.println("Escribe un primer numero: ");
		 double primernum = reader.nextDouble();
		 
		 System.out.println("Escribe un segundo numero: ");
		 double segundonum = reader.nextDouble();
		 
		 double mayor1 = Math.max(primernum, segundonum);
		 boolean iguales = (primernum == segundonum);
		 
		 System.out.println(iguales + " los numeros son iguales" );
		 
		 System.out.println( "el numero mayor es " + mayor1);
		 
		 //ejercicio 10
		 
		 reader= new Scanner(System.in);
		 System.out.println("Escribe un numero: ");
		 double numero5 = reader.nextDouble();
		 System.out.println("Escribe un segundo numero: ");
		 double numero6 = reader.nextDouble();
		 System.out.println("Escribe un tercer numero: ");
		 double numero7 = reader.nextDouble();
		 
		 double mayor2 = Math.max(numero5,numero6);
		 double mayor3 = Math.max(mayor2,numero7);
		 
		 System.out.println("El numero mayor es: " + mayor3);
		 
		 //ejercicio 11
		 
		 reader= new Scanner(System.in);
		 System.out.println("Escribe un numero: ");
		 double x = reader.nextDouble();
		 System.out.println("Escribe un segundo numero: ");
		 double y =	reader.nextDouble();
		 boolean cero = (x == 0);
		 boolean zero = (y == 0);
		 
		 System.out.println(cero + " el primer numero que pusiste fue 0");
		 System.out.println(zero + " el segundo numero que pusiste fue 0");
		 System.out.println("valor de suma " + (numero1 + numero2));
		 System.out.println("valor de resta " + (numero1 - numero2));
		 System.out.println("valor de producto " + (numero1 % numero2));
		 System.out.println("valor de division " + (numero1 / numero2));
		
		 // ejercicio 12
		 
		 reader= new Scanner(System.in);
		 System.out.println("Escribe un numero: ");
		 double numero8 = reader.nextDouble();
		 
		 System.out.println("Escribe otro numero");
		 double numero9 = reader.nextDouble();
		 
		 double mayores = Math.max(numero8, numero9);
		 System.out.println("Escribe otro numero" + mayores);
		 
		 //ejercicio 13
		 
		 
		 
		 
		 
	} //main

}//actividad
