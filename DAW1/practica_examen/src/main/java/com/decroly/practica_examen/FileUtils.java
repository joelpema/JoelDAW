package com.decroly.practica_examen;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {

    public static void writeFile(String fileName, LinkedList<Profesor> profesor) {
        try (ObjectOutputStream buffer = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/" + fileName))) {
            buffer.writeObject(profesor);
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    public static LinkedList<Profesor> readFile(String fileName) {
        LinkedList<Profesor> profesor = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/" + fileName))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Profesor) {
                        profesor.add((Profesor) obj);
                    }
                } catch (EOFException eof) {
                    break; // Fin del archivo
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer profesor: " + e.getMessage());
        }
        return profesor;
    }


}
