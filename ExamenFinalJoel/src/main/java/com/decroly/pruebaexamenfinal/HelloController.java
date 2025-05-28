package com.decroly.pruebaexamenfinal;

import com.decroly.pruebaexamenfinal.Utils.FileUtils;
import com.decroly.pruebaexamenfinal.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HelloController {

    @FXML
    private ListView<Mascota> mascotasListView;


    //Panel de registro de nuevo producto
    @FXML
    private AnchorPane mainPanel;

    //Campos de texto del registro
    @FXML
    private TextField pasaporteMascotaText;

    @FXML
    private TextField nombreMascotaText;

    @FXML
    private TextField pesoMascotaText;

    @FXML
    private TextField propietarioMascotaText;

    @FXML
    private ComboBox<Tipo> tipoMascotaText;

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

    @FXML
    private ListView<Propietario> propietarioListView;

    @FXML
    private ListView<Consulta> consultaListView;

    //Consulta text

    @FXML
    private TextField fechaConsultaText;

    @FXML
    private TextField duracionConsultaText;

    @FXML
    private TextField observacionesConsultaText;

    @FXML
    private TextField mascotaPasaporteText;

    @FXML
    private TextField mascotaPasaporteDniText;

    //Boton de registro de nuevo producto
    @FXML
    private Button registrarMascotaBtn;

    @FXML
    private Button consultaButton;

    @FXML
    private Button exportarDatosBtn1;

    @FXML
    private Button SalirApp;

    @FXML
    private Button volver1;

    @FXML
    private Button volver2;

    @FXML
    private Button volver3;

    @FXML
    private Button volver4;

    // VBox

    @FXML
    private VBox botonesVBox;
    @FXML
    private VBox registrarMascota;
    @FXML
    private VBox registrarConsulta;
    @FXML
    private VBox registrarPersona;

    //Botones de panel de lista de productos
    @FXML
    private Button nuevoProductoBtn;

    @FXML
    private Button exportarDatosBtn;

    //Panel de lista de productos
    @FXML
    private VBox tablaPanel;

    @FXML
    private ListView<Propietario> listaPropietariosView;

    //Listview de mascotas


    //Objetos para controlar las entidades
    ObservableList<Mascota> pets = FXCollections.observableArrayList();
    ObservableList<Propietario> propietis = FXCollections.observableArrayList();
    ObservableList<Consulta> consultar = FXCollections.observableArrayList();

    //Metodo initialize que se ejecuta al iniciarse el HelloController
    @FXML
    public void initialize() {
        tablaPanel.setVisible(true);
        botonesVBox.setVisible(true);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);

        mascotasListView.setItems(pets);
        tipoMascotaText.getItems().setAll(Tipo.values());

        listaPropietariosView.setItems(propietis);
        consultaListView.setItems(consultar);

        pasaporteMascotaText.setPromptText("Pasaporte");
        nombreMascotaText.setPromptText("Nombre");
        pesoMascotaText.setPromptText("Peso");
        propietarioMascotaText.setPromptText("Propietario");
        tipoMascotaText.setPromptText("Tipo");

        //Añadir listener para los botones
        mascotasListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
        //Añadir listener para actualizar los campos al seleccionar un producto
        mascotasListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                pasaporteMascotaText.setText(String.valueOf(newValue.getPasaporte()));
                nombreMascotaText.setText(newValue.getNombre());
                pesoMascotaText.setText(String.valueOf(newValue.getPeso()));
                propietarioMascotaText.setText(String.valueOf(newValue.getPropietarioDni()));
                tipoMascotaText.setValue(newValue.getTipo());
                tablaPanel.setVisible(false);
                botonesVBox.setVisible(true);
                registrarMascota.setVisible(false);
                registrarConsulta.setVisible(false);
                registrarPersona.setVisible(false);
            }
        });

        //Añadir listener a las propiedades de focus de los TextFields
        pasaporteMascotaText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(pasaporteMascotaText.getText().isEmpty()){
                    pasaporteMascotaText.setText("");
                    pasaporteMascotaText.setPromptText("Ingrese un Pasaporte");
                }
            }
        });

        nombreMascotaText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(nombreMascotaText.getText().isEmpty()){
                    nombreMascotaText.setText("");
                    nombreMascotaText.setPromptText("Ingrese un nombre");
                }
            }
        });
        pesoMascotaText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(pesoMascotaText.getText().isEmpty()){
                    pesoMascotaText.setText("");
                    pesoMascotaText.setPromptText("Ingrese una peso");
                }
            }
        });
        propietarioMascotaText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(propietarioMascotaText.getText().isEmpty()){
                    propietarioMascotaText.setText("");
                    propietarioMascotaText.setPromptText("Ingrese el DNI del propietario de la mascota");
                }
            }
        });
    }

    @FXML
    private LinkedList<Mascota> loadFileMascotas(){
        return FileUtils.readFile("Exportar_Mascotas.dat");
    }

    //Evento de los botones
    @FXML
    private void añadirMascota() {
        String pasaporte = pasaporteMascotaText.getText();
        String nombre = nombreMascotaText.getText();
        String pesoMascota = pesoMascotaText.getText();
        String dniPropietario = propietarioMascotaText.getText();
        Tipo tipo = tipoMascotaText.getValue();
        if(pasaporteMascotaText.getText().isEmpty() || nombreMascotaText.getText().isEmpty() || pesoMascotaText.getText().isEmpty() || propietarioMascotaText.getText().isEmpty() || tipoMascotaText.getValue() == null){
            showAlert("Error, todos los campos son obligatorios");
        }else {
            Mascota p = new Mascota(pasaporte, nombre, Double.parseDouble(pesoMascota), dniPropietario, tipo);
            pets.add(p);
            SQLAccess.añadirMascota(p);
            showAlert("Exito, Mascota añadida correctamente");
            clearFields();
            tablaPanel.setVisible(true);
            botonesVBox.setVisible(false);
            registrarMascota.setVisible(false);
            registrarConsulta.setVisible(false);
            registrarPersona.setVisible(false);
            mascotasListView.refresh();
        }
    }

    @FXML
    private void añadirPropietario() {
        String dni = dniPersonaText.getText();
        String Nombre = nombrePersonaText.getText();
        String Apellido = apellidoPersonaText.getText();
        String Telefono = telefonoPersonaText.getText();
        String Direccion = direccionPersonaText.getText();
        String Email = emailPersonaText.getText();
        if(dniPersonaText.getText().isEmpty() || nombrePersonaText.getText().isEmpty() || apellidoPersonaText.getText().isEmpty() || telefonoPersonaText.getText().isEmpty() || direccionPersonaText.getText().isEmpty() || emailPersonaText.getText() == null){
            showAlert("Error, todos los campos son obligatorios");
        }else {
            Propietario p = new Propietario(dni, Nombre, Apellido, Telefono, Direccion, Email);
            propietis.add(p);
            SQLAccess.añadirPropietario(p);
            showAlert("Exito, Mascota añadida correctamente");
            clearFields();
            tablaPanel.setVisible(true);
            botonesVBox.setVisible(false);
            registrarMascota.setVisible(false);
            registrarConsulta.setVisible(false);
            registrarPersona.setVisible(false);
            propietarioListView.refresh();
        }
    }

    @FXML
    private void añadirConsulta() {
        String fecha = fechaConsultaText.getText();
        String duracion = duracionConsultaText.getText();
        String observaciones = observacionesConsultaText.getText();
        String mascotaPasaporte = mascotaPasaporteText.getText();
        String mascotaPasaporteDni = mascotaPasaporteDniText.getText();
        if(pasaporteMascotaText.getText().isEmpty() || nombreMascotaText.getText().isEmpty() || pesoMascotaText.getText().isEmpty() || propietarioMascotaText.getText().isEmpty() || tipoMascotaText.getValue() == null){
            showAlert("Error, todos los campos son obligatorios");
        }else {
            Consulta p = new Consulta (fecha,  Integer.parseInt(duracion), observaciones,mascotaPasaporte, mascotaPasaporteDni);
            consultar.add(p);
            SQLAccess.añadirConsulta(p);
            showAlert("Exito, Mascota añadida correctamente");
            clearFields();
            tablaPanel.setVisible(true);
            botonesVBox.setVisible(false);
            registrarMascota.setVisible(false);
            registrarConsulta.setVisible(false);
            registrarPersona.setVisible(false);
            mascotasListView.refresh();
        }
    }


    @FXML
    private void saveInFile() {
        FileUtils.writeFile("Exportar_Mascotas.dat", new LinkedList<Mascota>());
    }

    @FXML
    private void nuevaConsulta() {
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(true);
        registrarPersona.setVisible(false);
    }

    //Metodos internos para realizar operaciones
    @FXML
    private void cambiararegistro(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(false);
        registrarMascota.setVisible(true);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);
    }

    private void clearFields(){
        pasaporteMascotaText.setText("");
        nombreMascotaText.setText("");
        pesoMascotaText.setText("");
        propietarioMascotaText.setText("");
        tipoMascotaText.setPromptText("Tipo");
        tipoMascotaText.getSelectionModel().clearSelection();
    }

    @FXML
    public void Salir(){
        Platform.exit();
    }

    @FXML
    public void volver(){
        tablaPanel.setVisible(false);
        botonesVBox.setVisible(true);
        registrarMascota.setVisible(false);
        registrarConsulta.setVisible(false);
        registrarPersona.setVisible(false);
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    private Mascota productoseleccionado() {
        return mascotasListView.getSelectionModel().getSelectedItem();
    }
}



