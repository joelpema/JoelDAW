package com.decroly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseVideoDaw {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String SCHEMA = "VideoDAW";
    private static String USUARIO = "root";
    private static String CLAVE = "daw12";

    
      static {
        try (InputStream inputStream = SQLDataBaseVideoDaw.class.getClassLoader().getResourceAsStream("application.dat");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            DRIVER = br.readLine();
            URL = br.readLine();
            SCHEMA = br.readLine();
            USUARIO = br.readLine();
            CLAVE = br.readLine();

        } catch (IOException | NullPointerException e) {
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }


   public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL+SCHEMA, USUARIO, CLAVE);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error de acceso al driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }

        return connection;
    }


}