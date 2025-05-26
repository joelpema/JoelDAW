package com.decroly.practica_examen;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private VBox registro;
    @FXML
    private VBox listRegistro;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField edadField;
    @FXML
    private TextField direccionField;
    @FXML
    private ComboBox<Profesion> profesionCombo;
    @FXML
    private Button saveButton;
    @FXML
    private Button nextButton;

    @FXML
    protected void OnExitButton(ActionEvent event){
        Platform.exit();
    }

    @FXML
    protected void OnSaveButton(ActionEvent event){
        registro.setVisible(false);
        listRegistro.setVisible(true);
        this.clearFields();

        try {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            int edad = Integer.parseInt(edadField.getText());
            String direccion = direccionField.getText();
            Profesion profesion = profesionCombo.getValue();

            Profesor profesor = new Profesor(nombre, apellido, edad, direccion, profesion);
            ProfesorDAO.insertarProfesor(profesor);

            // Opcional: mostrar mensaje de éxito o limpiar campos
        } catch (Exception e) {
            // Manejar errores, por ejemplo, mostrar alerta
            e.printStackTrace();
        }

    }

    @FXML
    protected void OnSiguienteButton(ActionEvent event){
        registro.setVisible(false);
        listRegistro.setVisible(true);

        ObservableList<Profesor> profesores = FXCollections.observableArrayList(ProfesorDAO.getAllProfesores());
        ListView<Profesor> listView = new ListView<>(profesores);
        listView.setPrefSize(400, 300);
        listRegistro.getChildren().add(listView);
    }

    @FXML
    protected void OnVolverButton(ActionEvent event){
        registro.setVisible(true);
        listRegistro.setVisible(false);
    }

    @FXML
    public void initialize (){

        registro.setVisible(true);
        listRegistro.setVisible(false);
        profesionCombo.getItems().addAll(Profesion.values());

        nombreField.setPromptText("Nombre");
        apellidoField.setPromptText("Apellido");
        edadField.setPromptText("Email");
        direccionField.setPromptText("Direccion");
        profesionCombo.setPromptText("Profesion");

    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        direccionField.setText("");
    }


}