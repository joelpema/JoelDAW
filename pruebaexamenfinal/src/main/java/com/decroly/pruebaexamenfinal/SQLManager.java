package com.decroly.pruebaexamenfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLManager {
    private static  String DRIVER;
    static String URL;
    private static String SCHEMA;
    static  String USUARIO;
    static String CLAVE;

    public static Connection getConnection() {
        Connection con = null;

        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL+SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de acceso al driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }

        return con;
    }

    //lectura archivo credentials.dat
    static {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/credentials.dat"))) {
            String line;
            // Leer cada línea del archivo
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en clave y valor
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    switch (parts[0].trim()) {
                        case "driver":
                            DRIVER = parts[1].trim();
                            break;
                        case "url":
                            URL = parts[1].trim();
                            break;
                        case "schema":
                            SCHEMA = parts[1].trim();
                            break;
                        case "usuario":
                            USUARIO = parts[1].trim();
                            break;
                        case "clave":
                            CLAVE = parts[1].trim();
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }
}
