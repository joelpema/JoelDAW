package com.decroly.pruebaexamenfinal;

import java.io.*;
import java.util.LinkedList;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {

    public static void WriteFile(String fileName, LinkedList<Doctor> doctores) {
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false)) {
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            for (Doctor doctor : doctores) {
                buffer.writeObject(doctor);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static LinkedList<Doctor> readFile(String fileName) {
        LinkedList<Doctor> productos = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName)) {
            ObjectInputStream reader = new ObjectInputStream(file);
            while(!eof) {
                Doctor d = (Doctor) reader.readObject();
                productos.add(d);
            }
        } catch (EOFException e) {
            eof = true;
            System.out.println("Se ha leido el fichero completo");
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        return productos;
    }
}
