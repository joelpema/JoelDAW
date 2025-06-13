package com.decroly.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el favicon
        try {
            Image favicon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/logoPlay_alt.png")));
            stage.getIcons().add(favicon);
        } catch (Exception e) {
            System.out.println("Error al cargar el favicon: " + e.getMessage());
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("PLAYZONE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Iniciar la conexión a la base de datos
        try (Connection connection = SQLManager.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                launch(args);
            } else {
                System.out.println("Error al conectar con la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
        }
    }
}