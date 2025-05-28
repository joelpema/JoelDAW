package com.decroly.pruebaexamenfinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLAccess {
    public static List<Mascota> getProductos() {
        List<Mascota> mascotas = new LinkedList<>();
        //Sentencia a la base de datos
        String getProducts = "SELECT * FROM Mascota";

        try (Connection connection = SQLManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getProducts);){
            while (dataSet.next()){
                String pasaporte = dataSet.getString("Pasaporte");
                String nombre = dataSet.getString("Nombre");
                double peso = dataSet.getDouble("Peso");
                String propietarioDni = dataSet.getString("Propietario_dni");
                Tipo tipo = Tipo.valueOf(dataSet.getString("Tipo_idTipo"));

                Mascota p = new Mascota(pasaporte, nombre, peso, propietarioDni, tipo);
                mascotas.add(p);
            }
        }catch (Exception e){
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return mascotas;
    }

    public static List<Mascota> getProductosbyName(String nombredelproducto){
        List<Mascota> productos = new LinkedList<>();
        //Sentencia a la base de datos
        String getProducts = "SELECT * FROM Mascotas WHERE nombre = ?";
        try(Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getProducts);){
            statement.setString(1, nombredelproducto);
            ResultSet dataSet = statement.executeQuery();
            while (dataSet.next()){
                String pasaporte = dataSet.getString("pasaporte");
                String nombre = dataSet.getString("nombre");
                double peso = dataSet.getDouble("peso");
                String descripcion = dataSet.getString("descripcion");
                Tipo tipo = Tipo.valueOf(dataSet.getString("tipo"));

                Mascota p = new Mascota(pasaporte, nombre, peso, descripcion, tipo);
                productos.add(p);
            }
        } catch (Exception e){
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return productos;
    }

    public static int añadirMascota(Mascota mascota) {
        int response = -1;
        String añadirProducto = "INSERT INTO Mascota (pasaporte, nombre, peso, propietario_dni, tipo) VALUES (?,?,?,?,?)";

        try (Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(añadirProducto);) {
            statement.setString(1, mascota.getPasaporte());
            statement.setNString(2, mascota.getNombre());
            statement.setDouble(3, mascota.getPeso());
            statement.setNString(4, mascota.getPropietarioDni());
            statement.setNString(5, mascota.getTipo().name());

            response = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }


    public static int añadirPropietario (Propietario propietario){
        int response = -1;
        String añadirPropietario = "INSERT INTO Mascota (dni, Nombre, Apellido, Telefono, Direccion, Email) VALUES (?,?,?,?,?,?)";

        try(Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(añadirPropietario);) {
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

    public static int añadirConsulta (Consulta consulta){
        int response = -1;
        String añadirPropietario = "INSERT INTO Consulta (Fecha, Duracion, Observaciones, Mascota_Pasaporte, Mascota_Propietario_dni) VALUES (?,?,?,?,?)";

        try(Connection connection = SQLManager.getConnection(); PreparedStatement statement = connection.prepareStatement(añadirPropietario);) {
            statement.setNString(1, consulta.getFecha());
            statement.setInt(2, consulta.getDuracion());
            statement.setNString(3, consulta.getObservaciones());
            statement.setNString(4, consulta.getMascotaPasaporte());
            statement.setNString(5, consulta.getMascotaPropietarioDNI());

            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }





}
