package com.decroly;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myUtils extends Exception{

    Scanner reader = new Scanner(System.in);

    public static void imprimir(String mensaje){//MOSTRAMOS UN MENSAJE EN PANTALLA
        System.out.println(mensaje);
    }

    public static String leerTextoPantalla(String mensaje){//MOSTRAMOS MENSAJE Y LEEMOS TEXTO
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }

    public static boolean comprobarPatron(String patron, String texto)//COMPROBAMOS UN PATRON 1 VEZ
    {
        boolean isOk = false;
        Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
        Matcher mat = pat.matcher(texto);
        isOk = mat.matches();
        return isOk;
    }

    public static String comprobarPatronRepetidamente(String patron, String mensaje){//COMPROBAMOS UN PATRON HASTA QUE SE CUMPLA
        boolean isOk = false;
        String texto;
        do { 
            texto = myUtils.leerTextoPantalla(mensaje);
            isOk = myUtils.comprobarPatron(patron, texto);
            if(!isOk){
                myUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }

    public static LocalDate leerFecha() {//LEEMOS UNA FECHA
        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        myUtils.imprimir("Escribe la fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = entrada.nextLine();
        //convert String to LocalDate
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        
        return fechaLocalDate;
    }
    
    public static int leerNumeroPantalla(String mensaje){//LEEMOS UN NUMERO
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        int valor = reader.nextInt();
        return valor;
    }

    public static String generarMenu(List<String> opciones){
            System.out.println();
            for(String op : opciones){
                System.out.println(op+"\n");
            }
            return leerTextoPantalla("Escoja la opcion deseada del menu");
        }
}
