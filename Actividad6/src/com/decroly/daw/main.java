package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //Ejercicio 1

		Scanner sc = new Scanner (System.in);
		
	    int [][] numeros1 = new int[5][5];
	    int numero = 1;

	    for (int i = 0; i < numeros1.length; i++) {
	    	
	        for (int j = 0; j < numeros1.length; j++) {
	        	numeros1[i][j] = numero++;
	        }
	    }
	    
	    for (int i = 0; i < numeros1.length; i++) {
	        		System.out.println("Fila "+ (i + 1) + ": " );
	        		
	        for (int j = 0; j < numeros1.length; j++) {
	            	System.out.println(numeros1[i][j] + " ");
	        }
	    }

	    
	    //Ejercicio 2

	    int [][] numeros2 = new int [10][10];

	    System.out.println("\n");
	    
	    for (int i = 0; i < numeros2.length; i++) {
	        for (int j = 0; j < numeros2.length; j++) {
	        	numeros2[i][j] = (i + 1) * (j +1);
	        }
	    }

	    for (int i = 0; i < numeros2.length; i++) {
	        	System.out.println("Las multiflicaciones de "+ (i + 1) + " es: " );
	        for (int j = 0; j < numeros2.length; j++) {
	            	System.out.println(numeros2[i][j] + " ");
	        }
	    }
	    


	    //Ejericio 3


	     sc = new Scanner (System.in);
	     
	    System.out.println("\n Introduce el valor para N");
	    int N = sc.nextInt();
	    
	    System.out.println("Introduce un valor para M (pon un numero mayor que 0): ");
	    int M = sc.nextInt();
	    
	    int [][] numeros3 =  new int [N][M];
	    
	    if (M == 0 && N == 0) {
            System.out.println("El número debe ser mayor que 0 \n");
        } else {

	    	System.out.println("Introduce los valores de la matriz:");
	    	for (int i = 0; i < numeros3.length; i++) {

	        	for (int j = 0; j < M; j++){
	            	System.out.println("Valor en la posicion " + (j + 1) + ": " );
	            	numeros3[i][j] =  sc.nextInt();
	        	}
	    	}
		
	    	int cero = 0;
	    	int mayor = 0;
	    	int menor = 0;

	    
	    	for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < M; j++){
	    			if (numeros3[i][j] == 0){
	    				cero ++;
	    			}else if (numeros3[i][j] > 0) {
	    				mayor ++;
	    			}else if (numeros3[i][j] > 0){
	    				menor ++;
	            	}
	        	}
	    	}
        
	    	System.out.println("Hay " + cero + " valores iguales a cero.");
	    	System.out.println("Hay " + mayor + " valores mayores a cero.");
	    	System.out.println("Hay " + menor + " valores menores a cero.\n");
        }


	    //Ejercicio 4
		
	    System.out.println("\n");
	    int alumno = 4;
	    int asignatura = 5;
	    double [][] numeros4 = new double[alumno][asignatura];
	    for (int i = 0; i < numeros4.length; i++) {
	        System.out.println("Notas del alumno " + (i + 1) + " : ");
	        for (int j = 0; j < asignatura; j++) {
	            System.out.println("Asignatura " + (j + 1) + " : ");
	            numeros4[i][j] = sc.nextDouble();
	        }
	    }

	    for (int i = 0; i < alumno; i++) {
	        double notaMin = numeros4[i][0];
	        double notaMax = numeros4[i][0];
	        double suma = 0;
	        double media = 0;
	        for (int j = 0; j < asignatura; j++) {
	            notaMin = Math.min(notaMin, numeros4[i][j]);
	            notaMax = Math.max(notaMax, numeros4[i][j]);
	            suma += numeros4[i][j];
	            media = suma/ asignatura;
	        }
	        System.out.println("Resultados para alumno: " + (i + 1) + " : ");
	        System.out.println("La nota minima es: " + notaMin);
	        System.out.println("La nota maxima es: " + notaMax);
	        System.out.println("La nota media es: " + media + "\n");
	    }



	    //Ejercicio 5
		
	    System.out.println("\n Introduce el numero de trabajadores:");
	    
	    int N1 = sc.nextInt();
	    double[][] numeros5 = new double [N1][2];
	    
	    for (int i = 0; i < numeros5.length; i++) {
	        System.out.println("El trabajador " + (i + 1) + " :");
	        
	        System.out.println("Introduce tu genero 1 si eres mujer y 0 si eres hombre");
	        numeros5 [i][0] = sc.nextDouble();
	        
	        System.out.println("Sueldo: ");
	        numeros5 [i][1] = sc.nextDouble();     
	        
	    }

	    double sumaMasc = 0;
	    double sumaFem = 0;
	    int masculino = 0;
	    int femenino = 0;

	    for (int i = 0; i < numeros5.length; i++) {
	        if (numeros5[i][0] == 0){
	            masculino ++;
	            sumaMasc += numeros5[i][1];
	        } else{
	            femenino ++ ;
	            sumaFem += numeros5[i][1];
	        }
	    }
 
	    System.out.println("El sueldo medio de los hombres es: " + sumaMasc/masculino);
	    System.out.println("El sueldo medio de las mujeres es: " + sumaFem/femenino);

	    if(sumaMasc/masculino > sumaFem/femenino){
	        System.out.println("Hay una brecha salarial en Mujeres");
	        
	    }else{
	    	
	        System.out.println("Hay una brecha salarial en  Hombres");
	    }		
		
	}

}
