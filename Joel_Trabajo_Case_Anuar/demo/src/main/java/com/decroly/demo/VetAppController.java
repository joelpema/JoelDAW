
package com.decroly.demo;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class VetAppController implements Initializable {


    @FXML
    private VBox tablaPanel;
    @FXML
    private VBox botonesVBox;
    @FXML
    private VBox registrarMascota;
    @FXML
    private VBox registrarConsulta;
    @FXML
    private VBox registrarPersona;

    @FXML
    private ComboBox<Propietario> propietarioComboBox;
    @FXML
    private ComboBox<Tipo> tipoMascotaText;


    SQLAccess sqlAccess = new SQLAccess();

    //mascota
    @FXML
    private TextField pasaporteMascotaText;
    @FXML
    private TextField nombreMascotaText;
    @FXML
    private TextField pesoMascotaText;
    @FXML
    private TextField fechaNacimientoMascotaText;
    @FXML
    private ListView<Mascota> listaProductosView;

    // propietario
    @FXML
    private TextField dniPersonaText;
    @FXML
    private TextField nombrePersonaText;
    @FXML
    private TextField apellidoPersonaText;
    @FXML
    private TextField telefonoPersonaText;
    @FXML
    private TextField direccionPersonaText;
    @FXML
    private TextField emailPersonaText;

    // consulta
    @FXML
    private DatePicker fechaConsultaDate;
    @FXML
    private TextField duracionConsultaText;
    @FXML
    private TextField observacionesConsultaText;
    @FXML
    private ComboBox<Mascota> mascotaComboBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(true);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);

        // Cargar propietarios en el ComboBox
        List<Propietario> propietarios = sqlAccess.getAllPropietario();
        ObservableList<Propietario> propietarioList = propietarioComboBox.getItems();
        propietarioList.addAll(propietarios);

        // cargar tipos en el combobox
        List<Tipo> tipos = sqlAccess.getAllTipos();
        ObservableList<Tipo> tipoList = tipoMascotaText.getItems();
        tipoList.addAll(tipos);

        // Cargar mascotas en el ComboBox de consultas
        List<Mascota> mascotas = sqlAccess.getAllMascota();
        ObservableList<Mascota> mascotaList = mascotaComboBox.getItems();
        mascotaList.addAll(mascotas);
    }

    private List<Mascota> loadFileProductos(){
        return FileUtils.readFile("export_Productos.dat");
    }

    @FXML
    private void saveInFile() {
        FileUtils.WriteFile("export_Productos.dat", new LinkedList<Mascota>());
    }

    public void insertarMascota() {
        try {
            // Validar campos vacíos
            if (pasaporteMascotaText.getText().isEmpty() || nombreMascotaText.getText().isEmpty() ||
                    pesoMascotaText.getText().isEmpty() || fechaNacimientoMascotaText.getText().isEmpty() ||
                    propietarioComboBox.getValue() == null || tipoMascotaText.getValue() == null) {
                Platform.runLater(() -> salir("Error", "Todos los campos son obligatorios"));
                return;
            }

            String pasaporte = pasaporteMascotaText.getText();
            String nombre = nombreMascotaText.getText();
            double peso = Double.parseDouble(pesoMascotaText.getText());
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoMascotaText.getText());
            Propietario propietario = propietarioComboBox.getValue();
            Tipo tipo = tipoMascotaText.getValue();

            Mascota mascota = new Mascota(pasaporte, nombre, peso, fechaNacimiento, propietario, tipo);
            sqlAccess.InsertarMascota(mascota);

            // validar si la mascota se ha insertado correctamente
            Mascota insertedMascota = sqlAccess.getMascotaByPasaporte(pasaporte);
            if (insertedMascota == null) {
                System.out.println("Error de formato numérico: ");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error de formato numérico: " + e.getMessage());
            return;
        }
    }

    public void insertarPropietario() {
        try {
            String dni = dniPersonaText.getText();
            String nombre = nombrePersonaText.getText();
            String apellido = apellidoPersonaText.getText();
            String telefono = telefonoPersonaText.getText();
            String direccion = direccionPersonaText.getText();
            String email = emailPersonaText.getText();

            //limpiar campos vacíos


            Propietario propietario = new Propietario(dni, nombre, apellido, telefono, direccion, email);
            sqlAccess.añadirPropietario(propietario);

            dniPersonaText.clear();
            nombrePersonaText.clear();
            apellidoPersonaText.clear();
            telefonoPersonaText.clear();
            direccionPersonaText.clear();
            emailPersonaText.clear();

            // Actualizar el ComboBox de propietarios
            List<Propietario> propietarios = sqlAccess.getAllPropietario();
            propietarioComboBox.getItems().clear();
            propietarioComboBox.getItems().addAll(propietarios);

            // Limpiar campos después de insertar exitosamente

            Platform.runLater(() -> salir("Éxito", "Propietario registrado correctamente"));

        } catch (Exception e) {
            Platform.runLater(() -> salir("Error", "Error en la base de datos: " + e.getMessage()));
        }
    }

    public void insertarConsulta() {

        try{
            LocalDate fechaConsulta = fechaConsultaDate.getValue();
            int duracionConsulta = Integer.parseInt(duracionConsultaText.getText());
            String observacionesConsulta = observacionesConsultaText.getText();
            Mascota mascota = mascotaComboBox.getValue();


            Consulta consulta = new Consulta(fechaConsulta, duracionConsulta, observacionesConsulta, mascota);
            sqlAccess.InsertarConsulta(consulta);


        }catch (Exception e) {

            Platform.runLater(() -> salir("Error", "Error al registrar la consulta: " + e.getMessage()));
            return;
        }

    }

    private void salir(String error, String errorAlRegistrarLaMascota) {
    }
    public void ventanaMascotas(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(true);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);
    }
    public void ventanaConsultas(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(true);
        registrarPersona.setVisible(false);
    }
    public void ventanaPersonas(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(true);
    }
    public void ventanaTabla(){
        tablaPanel.setVisible(true);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);

        // Cargar datos en la tabla
        List<Mascota> mascotas = sqlAccess.getAllMascota();
        ListView<Mascota> listView = new ListView<>();
        listView.getItems().addAll(mascotas);
        listaProductosView.setItems(listView.getItems());
    }
    public void salir(){
        Platform.exit();
    }
    public void volver(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(true);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);
    }
}
