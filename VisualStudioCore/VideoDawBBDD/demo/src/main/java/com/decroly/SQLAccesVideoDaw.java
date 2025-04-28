package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.VideoDaw;

public class SQLAccesVideoDaw {

    public List<VideoDaw> getVideoDaw(){
        
        List<VideoDaw> completa = new LinkedList<>();
        
        //Setencia SQL
        String getVideoDaw = "SELECT * FROM videodaw";
        
        try (Connection connection = SQLDataBaseVideoDaw.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getVideoDaw);) {

            while(dataSet.next()){
                
            }
        
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        


        return completa;
    }
        
}
