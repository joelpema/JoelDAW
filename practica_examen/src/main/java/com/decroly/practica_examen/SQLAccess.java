package com.decroly.practica_examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLAccess {

    public static void insertarProfesor(Profesor profesor) {

        String sql = "INSERT INTO Profesor (Nombre, Apellido, Edad, Direccion, id_asignatura) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setInt(3, profesor.getEdad());
            stmt.setString(4, profesor.getDireccion());
            stmt.setInt(5, profesor.getId_asignatura().ordinal()+1);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el profesor: " + ex.getMessage());

        }

    }

    public static int eliminarProducto(Profesor profesor){
        int response = -1;
        String eliminarProducto = "DELETE FROM Profesor WHERE id = ?";

        try(Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(eliminarProducto);) {
            statement.setString(1, profesor.getNombre());
            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }
}
