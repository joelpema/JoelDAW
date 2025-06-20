package com.decroly.demo;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class SQLAccess {

    // obtener todos los tipos de mascota

    public List<Tipo> getAllTipos() {
        List<Tipo> tipos = new LinkedList<>();
        String getTipos = "SELECT idTipo, Tipo FROM tipo";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getTipos)) {

            while (dataSet.next()) {
                Tipo t = (new Tipo(dataSet.getString(2),
                                   dataSet.getInt(1)));
                tipos.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tipos
    }

    // obtener todos los Propietarios

    public List<Propietario> getAllPropietario() {
        List<Propietario> propietarios = new LinkedList<>();
        String getPropietarios = "SELECT * FROM propietario";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getPropietarios)) {

            while (dataSet.next()) {
                Propietario p = new Propietario(
                        dataSet.getNString(1),
                        dataSet.getNString(2),
                        dataSet.getNString(3),
                        dataSet.getNString(4),
                        dataSet.getNString(5),
                        dataSet.getNString(6));
                propietarios.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return propietarios;
    }

    public List<Mascota> getAllMascota() {
        List<Mascota> mascotas = new LinkedList<>();
        String getMascotas = "SELECT  m.*, t.tipo, p.* FROM mascota m " +
                "JOIN propietario p ON p.dni = m.Propietario_dni " +
                "JOIN tipo t ON m.Tipo_idTipo = t.idTipo";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getMascotas)) {

            while (dataSet.next()) {
                Mascota m = new Mascota(
                                        dataSet.getNString(2), // nombre
                                        dataSet.getNString(1), // pasaporte
                        dataSet.getDouble(3), // fechaNacimiento
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // peso
                                        new Propietario(
                                                dataSet.getNString(8), // dni
                                                dataSet.getNString(9), // nombre
                                                dataSet.getNString(10), // apellidos
                                                dataSet.getNString(11), // direccion
                                                dataSet.getNString(12), // telefono
                                                dataSet.getNString(13)  // email
                                        ),
                                        new Tipo(
                                                dataSet.getNString(7), // tipo
                                                dataSet.getInt(6) // idTipo

                                        ));
                mascotas.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mascotas;
    }

    // obtener un propietario por pasaporte

    public Mascota getMascotaByPasaporte(String pasaporte) {

        Mascota mascota = null;

        String SqlState = "SELECT  m.*, t.tipo, p.* FROM mascota m " +
                "JOIN propietario p ON p.dni = m.Propietario_dni " +
                "JOIN tipo t ON m.Tipo_idTipo = t.idTipo" + " WHERE Pasaporte = ?";
        try (Connection conection = SQLManager.getConnection(); PreparedStatement statement = conection.prepareStatement(SqlState);
            ) {
            statement.setString(1, pasaporte);
            ResultSet dataSet = statement.executeQuery();

            while (dataSet.next()) {
                Mascota m = new Mascota(

                                        dataSet.getNString(2), // nombre
                                        dataSet.getNString(1), // pasaporte
                        dataSet.getDouble(3), // fechaNacimiento
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // peso
                                        new Propietario(
                                                dataSet.getNString(8), // dni
                                                dataSet.getNString(9), // nombre
                                                dataSet.getNString(10), // apellidos
                                                dataSet.getNString(11), // direccion
                                                dataSet.getNString(12), // telefono
                                                dataSet.getNString(13)  // email
                                        ),
                                        new Tipo(
                                                dataSet.getNString(7), // tipo
                                                dataSet.getInt(6) // idTipo

                                        ));
                mascota = m;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mascota;
    }

    // Insertar un propietario

    public int añadirPropietario (Propietario propietario){
        int response = -1;
        String SQLStatement = "INSERT INTO Propietario (dni, Nombre, Apellido, Telefono, Direcion, Email) VALUES (?,?,?,?,?,?)";

        try(Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(SQLStatement);) {
            statement.setNString(1, propietario.getDni());
            statement.setNString(2, propietario.getNombre());
            statement.setNString(3, propietario.getApellido());
            statement.setNString(4, propietario.getTelefono());
            statement.setNString(5, propietario.getDireccion());
            statement.setNString(6, propietario.getEmail());
            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    // Insertar una mascota

    public int InsertarMascota(Mascota mascota) {
        int response = -1;

        String insertMascota = "INSERT INTO mascota (Pasaporte, Nombre, Peso, FechaNacimiento, Propietario_dni, Tipo_idTipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conection = SQLManager.getConnection(); PreparedStatement statement = conection.prepareStatement(insertMascota)) {

            statement.setString(1, mascota.getPasaporte());
            statement.setString(2, mascota.getNombre());
            statement.setDouble(3, mascota.getPeso());
            statement.setDate(4, Date.valueOf(mascota.getFechaNacimiento()));
            statement.setString(5, mascota.getPropietario().getDni());
            statement.setInt(6, mascota.getTipo().getId());
            response = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return response;

    }

    // Insertar una consulta

    public int InsertarConsulta (Consulta consulta) {
        int response = -1;

        String insertConsulta = "INSERT INTO consulta (Fecha, Duracion, Observaciones, Mascota_Pasaporte, Mascota_Propietario_dni) VALUES (?, ?, ?, ?, ?)";

        try (Connection conection = SQLManager.getConnection(); PreparedStatement statement = conection.prepareStatement(insertConsulta)) {

            statement.setDate(1, Date.valueOf(consulta.getFecha()));
            statement.setInt(2, consulta.getDuracion());
            statement.setString(3, consulta.getObservaciones());
            statement.setString(4, consulta.getMascota().getPasaporte());
            statement.setString(5, consulta.getMascota().getPropietario().getDni());
            response = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return response;

    }

    public  Mascota getMascotaByPropietario(String dni) {

        Mascota mascota = null;

        String SqlState = "SELECT  m.*, t.tipo, p.* FROM mascota m " +
                "JOIN propietario p ON p.dni = m.Propietario_dni " +
                "JOIN tipo t ON m.Tipo_idTipo = t.idTipo" + " WHERE p.dni = ?";

        try (Connection conection = SQLManager.getConnection(); PreparedStatement statement = conection.prepareStatement(SqlState);
        ) {
            statement.setString(1, dni);
            ResultSet dataSet = statement.executeQuery();

            while (dataSet.next()) {
                Mascota m = new Mascota(

                        dataSet.getNString(2), // nombre
                        dataSet.getNString(1), // pasaporte
                        dataSet.getDouble(3), // fechaNacimiento
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // peso
                        new Propietario(
                                dataSet.getNString(8), // dni
                                dataSet.getNString(9), // nombre
                                dataSet.getNString(10), // apellidos
                                dataSet.getNString(11), // direccion
                                dataSet.getNString(12), // telefono
                                dataSet.getNString(13)  // email
                        ),
                        new Tipo(
                                dataSet.getNString(7), // tipo
                                dataSet.getInt(6) // idTipo

                        ));
                mascota = m;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mascota;
    }




}


