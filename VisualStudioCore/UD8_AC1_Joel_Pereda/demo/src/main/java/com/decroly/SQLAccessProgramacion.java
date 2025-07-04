package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.TablaProductos;
import com.Tipo;

public class SQLAccessProgramacion {

    public List<TablaProductos> getProductos(){
        
            List<TablaProductos> completa = new LinkedList<>();
        
        //Setencia SQL
        String getChNames = "SELECT * FROM producto";
        
        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getChNames);) {

            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia = dataSet.getString(2);
                String nombre = dataSet.getString(3);
                String descripcion = dataSet.getString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                TablaProductos c1 =  new TablaProductos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                completa.add(c1);
            }
        
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        


        return completa;
    }

    public List<TablaProductos> getByRef(String ref){
        List<TablaProductos> ProductoReference = new LinkedList<>();

        String getRef = "SELECT * from producto WHERE referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getRef);) {

            statement.setString(1, ref);
            ResultSet dataSet = statement.executeQuery();

            while(dataSet.next()){
                
                int id = dataSet.getInt(1);
                String referencia = dataSet.getString(2);
                String nombre = dataSet.getString(3);
                String descripcion = dataSet.getString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                TablaProductos c1 =  new TablaProductos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                ProductoReference.add(c1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ProductoReference;
    }

    public List<TablaProductos> getByTipo(String tip){
        List<TablaProductos> ProductoTipos = new LinkedList<>();

        String getTipos = "SELECT * from producto WHERE tipo = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getTipos);) {

            statement.setString(1, tip);
            ResultSet dataSet = statement.executeQuery();

            while(dataSet.next()){
                
                int id = dataSet.getInt(1);
                String referencia = dataSet.getString(2);
                String nombre = dataSet.getString(3);
                String descripcion = dataSet.getString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                TablaProductos c1 =  new TablaProductos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                ProductoTipos.add(c1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ProductoTipos;
    }

    public List<TablaProductos> getProductoByCantidad(int cant){
        List<TablaProductos> ProductoCantidad = new LinkedList<>();

        String getCantidad = "SELECT * from producto WHERE cantidad = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getCantidad);) {

            statement.setInt(1, cant);
            ResultSet dataSet = statement.executeQuery();

            while(dataSet.next()){
                
                int id = dataSet.getInt(1);
                String referencia = dataSet.getString(2);
                String nombre = dataSet.getString(3);
                String descripcion = dataSet.getString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                TablaProductos c1 =  new TablaProductos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                ProductoCantidad.add(c1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ProductoCantidad;
    }

    public int getInsertarProducto(TablaProductos producto){
        int response = -1;
        String insertarProd = "INSERT INTO producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(insertarProd);) {

            
            statement.setNString(1, producto.getReferencia());
            statement.setNString(2, producto.getNombre());
            statement.setNString(3, producto.getDescripcion());
            statement.setInt(4, producto.getTipo());
            statement.setInt(5, producto.getCantidad());
            statement.setDouble(6, producto.getPrecio());
            statement.setInt(7, producto.getDescuento());
            statement.setInt(8, producto.getIva());
            statement.setBoolean(9, producto.isAplicarDto());

            response = statement.executeUpdate();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }
    public int deleteByReference(String referencia){
        int elements = -1;

        String deleteRef = "DELETE FROM producto where referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(deleteRef);) {

            statement.setNString(1, referencia);
            
            elements = statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return elements;
    }

    public int getUpdateProductos(TablaProductos productos){
        int response = -1;
        String actualizarProd = "UPDATE producto set descripcion = ? , cantidad = ? , precio = ? , descuento = ? , AplicarDto = ? where id = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(actualizarProd);) {
            statement.setNString(1, productos.getDescripcion());
            statement.setInt(2, productos.getCantidad());
            statement.setDouble(3, productos.getPrecio());
            statement.setInt(4, productos.getDescuento());
            statement.setBoolean(5, productos.isAplicarDto());
            statement.setInt(6, productos.getId());

            response = statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return response;
    }

    public int getIsertarTipos(Tipo tipo){
        int response = -1;
        String insertarTipo = "INSERT INTO tipo (id, nombre)" + "VALUES (?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(insertarTipo);) {
            statement.setInt(1, tipo.getId());
            statement.setNString(2, tipo.getNombre());

            response = statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return response;
    }




}

