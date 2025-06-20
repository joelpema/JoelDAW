package com.decroly.demo;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {

    public static void WriteFile(String fileName, LinkedList<Mascota> mascotas) {
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false)) {
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            for (Mascota mascota : mascotas) {
                buffer.writeObject(mascota);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static LinkedList<Mascota> readFile(String fileName) {
        LinkedList<Mascota> productos = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName)) {
            ObjectInputStream reader = new ObjectInputStream(file);
            while(!eof) {
                Mascota p = (Mascota) reader.readObject();
                productos.add(p);
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