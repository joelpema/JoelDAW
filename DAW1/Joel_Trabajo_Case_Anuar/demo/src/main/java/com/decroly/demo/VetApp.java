package com.decroly.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class VetApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VetApp.class.getResource("VetAppView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("VetDaw");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        SQLAccess vetdawAccess = new SQLAccess();

        for (Mascota m : vetdawAccess.getAllMascota()) {
            System.out.println(m);
        }

        Mascota m = vetdawAccess.getMascotaByPasaporte("P00000005");
        System.out.println("Mascota por pasaporte:");
        System.out.println(m);

        Mascota p = vetdawAccess.getMascotaByPropietario("12345678B");
        System.out.println("Mascota por propietario:");
        System.out.println(p);

        try (Connection connection = SQLManager.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                launch();
            } else {
                System.out.println("Error al conectar con la base de datos.");
                launch();
            }
        } catch (SQLException e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
            launch();
        }
    }
}
