package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.TablaProductos;
import com.Tipo;

public class SQLAccessProgramacion {

    public List<TablaProductos> getCharacters(){
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
                Tipo tipo = (Tipo) dataSet.getObject(5);
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
}

