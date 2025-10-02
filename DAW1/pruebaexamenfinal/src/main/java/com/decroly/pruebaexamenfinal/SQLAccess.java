package com.decroly.pruebaexamenfinal;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLAccess {

    // todos los doctores
    public List<Doctor> getAllDoctores() {
        List<Doctor> doctores = new LinkedList<>();
        String getDoctores = "SELECT * FROM Doctor";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getDoctores)) {

            while (dataSet.next()) {
                Doctor d = (new Doctor(
                        dataSet.getString("num_colegiado"),
                        dataSet.getString("Nombre"),
                        dataSet.getString("Apellidos"),
                        dataSet.getString("Telefono"),
                        dataSet.getString("Direccion"),
                        dataSet.getString("Email"),
                        dataSet.getDate("fecha_alta").toLocalDate(),
                        new Tipo(dataSet.getString("TipoConsulta_id"), dataSet.getInt("TipoConsulta_id"))
                ));
                doctores.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doctores;
    }



    // todas las consultas
    public List<Consultas> getAllConsultas() {
        List<Consultas> consultas = new LinkedList<>();
        String getConsultas = "select c.*, d.*, p.*, t.Tipo\n" +
                                "from Consulta c\n" +
                                "Join Doctor d ON d.TipoConsulta_id = c.Doctor_TipoConsulta_id\n" +
                                "join Paciente p ON p.dni = c.Paciente_dni\n" +
                                "join TipoConsulta t ON t.id = c.TipoConsulta_id";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getConsultas)) {



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return consultas;
    }



    //todos los tipos
    public List<Tipo> getAllTipos() {
        List<Tipo> tipos = new LinkedList<>();
        String getTipos = "SELECT id, Tipo FROM TipoConsulta";
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
        return tipos;
    }


    //todos los pacientes

    public List<Paciente> getAllPacientes() {
        List<Paciente> pacientes = new LinkedList<>();
        String getPacientes = "SELECT * FROM Paciente";
        try (Connection conection = SQLManager.getConnection(); Statement statement = conection.createStatement();
             ResultSet dataSet = statement.executeQuery(getPacientes)) {

            while (dataSet.next()) {
                Persona p = (new Persona(
                        dataSet.getString(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6)
                ));
                Paciente paciente = new Paciente(
                        p.getNombre(),
                        p.getApellido(),
                        p.getDni(),
                        p.getTelefono(),
                        p.getDereccion(),
                        p.getEmail()// Consultas se puede inicializar más tarde
                );
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pacientes;
    }

    public List<Doctor> getAllDoctoresByTipo(Tipo tipo) {
        List<Doctor> doctores = new LinkedList<>();
        String getDoctores = "SELECT * FROM Doctor WHERE TipoConsulta_id = ?";
        try (Connection conection = SQLManager.getConnection(); PreparedStatement preparedStatement = conection.prepareStatement(getDoctores)) {
            preparedStatement.setInt(1, tipo.getId());
            ResultSet dataSet = preparedStatement.executeQuery();

            while (dataSet.next()) {
                Doctor d = (new Doctor(
                        dataSet.getString("num_colegiado"),
                        dataSet.getString("Nombre"),
                        dataSet.getString("Apellidos"),
                        dataSet.getString("Telefono"),
                        dataSet.getString("Direccion"),
                        dataSet.getString("Email"),
                        dataSet.getDate("fecha_alta").toLocalDate(),
                        tipo
                ));
                doctores.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doctores;
    }


    //insertar persona
    public boolean insertPaciente(Paciente p) {
        String insertPersona = "INSERT INTO Paciente (dni, nombre, apellidos, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conection = SQLManager.getConnection(); PreparedStatement preparedStatement = conection.prepareStatement(insertPersona)) {
            preparedStatement.setString(1, p.getNombre());
            preparedStatement.setString(2, p.getApellido());
            preparedStatement.setString(3, p.getDni());
            preparedStatement.setString(4, p.getTelefono());
            preparedStatement.setString(5, p.getDereccion());
            preparedStatement.setString(6, p.getEmail());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //insertar Doctor
    public boolean insertDoctor(Doctor doctor) {
        String insertDoctor = "INSERT INTO Doctor (num_colegiado, Nombre, Apellidos, Telefono, Direccion, Email, fecha_alta, TipoConsulta_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conection = SQLManager.getConnection(); PreparedStatement preparedStatement = conection.prepareStatement(insertDoctor)) {
            preparedStatement.setString(1, doctor.getNumeroColegiado());
            preparedStatement.setString(2, doctor.getNombre());
            preparedStatement.setString(3, doctor.getApellido());
            preparedStatement.setString(4, doctor.getTelefono());
            preparedStatement.setString(5, doctor.getDereccion());
            preparedStatement.setString(6, doctor.getEmail());
            preparedStatement.setDate(7, Date.valueOf(doctor.getInicioValdecilla()));
            preparedStatement.setInt(8, doctor.getTipo().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    //insertar consulta
    public boolean insertConsulta(Consultas consulta) {
        String insertConsulta = "INSERT INTO Consulta (Observaciones, fecha, TipoConsulta_id, Paciente_dni, Doctor_num_colegiado, Doctor_TipoConsulta_id) VALUES (?, ?, ?, ?)";
        try (Connection conection = SQLManager.getConnection(); PreparedStatement preparedStatement = conection.prepareStatement(insertConsulta)) {
            preparedStatement.setString(2, consulta.getObservaciones());
            preparedStatement.setDate(3, Date.valueOf(consulta.getFecha()));
            preparedStatement.setInt(4, consulta.getTipoConsulta().getId());
            preparedStatement.setString(5, consulta.getPaciente().getDni());
            preparedStatement.setString(6, consulta.getDoctor().getNumeroColegiado());
            preparedStatement.setInt(7, consulta.getDoctor().getTipo().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }










}
