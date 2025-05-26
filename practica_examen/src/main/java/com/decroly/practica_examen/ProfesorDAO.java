package com.decroly.practica_examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {

    // Clase de utilidad para operaciones SQL
        public static void insertarProfesor(Profesor profesor) throws SQLException {
            String sql = "INSERT INTO Profesor (Nombre, Apellido, Edad, Direccion, Profesion) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = SQLManager.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, profesor.getNombre());
                stmt.setString(2, profesor.getApellido());
                stmt.setInt(3, profesor.getEdad());
                stmt.setString(4, profesor.getDireccion());
                stmt.setString(5, profesor.getProfesion().name());
                stmt.executeUpdate();
            }
        }
}
