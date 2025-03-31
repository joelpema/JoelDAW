package com.decroly;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLmaven {

    private final String CODIGO = "com.mysql.jdbc";
    private final String CADENA = "jdbc:mysql://localhost:3306/";
    private final String CONEXION = "DAW_PR4_1";
    private final String USER = "root";
    private final String PASS = "daw12";

    Connection com;

    public SQLmaven () {
        try {

            com = DriverManager.getConnection(CADENA + CODIGO, USER, PASS);
            System.out.println("Se a accedido correctamente");
        } catch (SQLException e) {

            System.out.println("No se ha podido establecer la conexión con la BD");
            System.out.println(e.getMessage());
            return;
        } 
            


    }





}

