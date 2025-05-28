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
    private ListView<Profesor> personListView;
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

    ObservableList<Profesor> profesores = FXCollections.observableArrayList();

    @FXML
    public void initialize (){
        registro.setVisible(true);
        listRegistro.setVisible(false);
        personListView.setItems(profesores);
        profesionCombo.getItems().addAll(Profesion.values());

        nombreField.setPromptText("Nombre");
        apellidoField.setPromptText("Apellido");
        edadField.setPromptText("Email");
        direccionField.setPromptText("Direccion");
        profesionCombo.setPromptText("Profesion");

        personListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nombreField.setText(newValue.getNombre());
                apellidoField.setText(newValue.getApellido());
                edadField.setText(String.valueOf(newValue.getEdad()));
                direccionField.setText(newValue.getDireccion());
                profesionCombo.setValue(newValue.getProfesion());
                registro.setVisible(true);
            }
        });
    }

    @FXML
    private void añadirProfesor(){

        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String edadText = edadField.getText();
        String direccion = direccionField.getText();
        Profesion profesion = profesionCombo.getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || edadText.isEmpty() || direccion.isEmpty() || profesion == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, completa todos los campos.");
            alert.showAndWait();
        } else {
            Profesor profesor = new Profesor(nombre, apellido, Integer.parseInt(edadText), direccion, profesion);
            profesores.add(profesor);
            try {
                SQLAccess.insertarProfesor(profesor);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Profesor añadido correctamente.");
                alert.showAndWait();
                clearFields();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al añadir el profesor: " + e.getMessage());
                alert.showAndWait();
            }
            clearFields();
            registro.setVisible(false);
            listRegistro.setVisible(true);
            personListView.refresh();
        }
    }




    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        direccionField.setText("");
        profesionCombo.setPromptText("Profesion");
        profesionCombo.getSelectionModel().clearSelection();
    }


}