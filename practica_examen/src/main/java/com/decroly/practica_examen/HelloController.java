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
    private TextField emailField;
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
    }

    @FXML
    protected void OnVolverButton(ActionEvent event){
        registro.setVisible(true);
        listRegistro.setVisible(false);
    }

    @FXML
    public void initialize (URL location, ResourceBundle resources){

        registro.setVisible(true);
        listRegistro.setVisible(false);
        profesionCombo.getItems().addAll(Profesion.values());



        nombreField.setPromptText("Nombre");
        apellidoField.setPromptText("Apellido");
        emailField.setPromptText("Email");
        direccionField.setPromptText("Direccion");
        profesionCombo.setPromptText("Profesion");


    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        emailField.setText("");
        direccionField.setText("");
    }









}