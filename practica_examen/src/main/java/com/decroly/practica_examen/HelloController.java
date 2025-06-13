package com.decroly.practica_examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

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
    private ComboBox<Asignatura> profesionCombo;
    @FXML
    private Button saveButton;
    @FXML
    private Button nextButton;

    @FXML
     private Button exportarButton;

    ObservableList<Profesor> profesores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        registro.setVisible(true);
        listRegistro.setVisible(false);
        personListView.setItems(profesores);
        profesionCombo.getItems().addAll(Asignatura.values());

        nombreField.setPromptText("Nombre");
        apellidoField.setPromptText("Apellido");
        edadField.setPromptText("Edad");
        direccionField.setPromptText("Direccion");
        profesionCombo.setPromptText("Profesion");

        personListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nombreField.setText(newValue.getNombre());
                apellidoField.setText(newValue.getApellido());
                edadField.setText(String.valueOf(newValue.getEdad()));
                direccionField.setText(newValue.getDireccion());
                profesionCombo.setValue(newValue.getId_asignatura());
                registro.setVisible(true);
            }
        });
    }

    // añadir profesores
    @FXML
    private void anadirProfesor() {

        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String edadText = edadField.getText();
        String direccion = direccionField.getText();
        Asignatura asignatura = profesionCombo.getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || edadText.isEmpty() || direccion.isEmpty() || asignatura == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, completa todos los campos.");
            alert.showAndWait();
        } else {
            Profesor profesor = new Profesor(nombre, apellido, Integer.parseInt(edadText), direccion, asignatura);
            profesores.add(profesor);

            SQLAccess.insertarProfesor(profesor);

            clearFields();
            registro.setVisible(false);
            listRegistro.setVisible(true);
            personListView.refresh();

        }
    }

    @FXML
    private void eliminarProfesor() {
        Profesor seleccionado = profesorSeleccionado();
        if(seleccionado != null){
            profesores.remove(seleccionado);
            personListView.refresh();
            registro.setVisible(false);
            listRegistro.setVisible(true);
            SQLAccess.eliminarProducto(seleccionado);
            Alert alert = new Alert(Alert.AlertType.ERROR,"Exito, Producto eliminado correctamente");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"ERROR, No hay ningun producto seleccionado");
        }
    }

    @FXML
    private void mostrarRegistro() {
        registro.setVisible(false);
        listRegistro.setVisible(true);
    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        direccionField.setText("");
        profesionCombo.setPromptText("Profesion");
        profesionCombo.getSelectionModel().clearSelection();
    }

    @FXML
    private void guardarArchivo(){
        FileUtils.writeFile("profesores.dat", new LinkedList<Profesor>());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Profesores guardados correctamente.");
        alert.showAndWait();
    }

    private Profesor profesorSeleccionado() {
        return personListView.getSelectionModel().getSelectedItem();
    }

}