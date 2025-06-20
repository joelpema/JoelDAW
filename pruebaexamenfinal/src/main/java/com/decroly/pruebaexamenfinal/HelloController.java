package com.decroly.pruebaexamenfinal;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class HelloController implements Initializable {

    SQLAccess sqlAccess = new SQLAccess();

    @FXML
    private VBox botonesVBox;
    @FXML
    private VBox registrarPaciente;
    @FXML
    private VBox registrarDoctor;
    @FXML
    private VBox registrarConsulta;
    @FXML
    private VBox tablaPanel;
    @FXML
    private VBox tablaPanelPacientes;



    @FXML
    private Button pacienteButton;
    @FXML
    private Button doctorButton;
    @FXML
    private Button consultaButton;
    @FXML
    private Button buscarButton;
    @FXML
    private Button exportarDatosBtn1;
    @FXML
    private Button SalirApp;

    //campos de registro de doctor
    @FXML
    private TextField nombreDoctorText;
    @FXML
    private TextField apellidoDoctorText;
    @FXML
    private TextField dniDoctorText;
    @FXML
    private TextField telefonoDoctorText;
    @FXML
    private TextField direccionDoctorText;
    @FXML
    private TextField emailDoctorText;
    @FXML
    private TextField nColegiadoText;
    @FXML
    private DatePicker fechaValdecillaText;
    @FXML
    private ComboBox<Tipo> tipoComboBox;


    //campos de registro de paciente
    @FXML
    private TextField nombrePacienteText;
    @FXML
    private TextField apellidoPacienteText;
    @FXML
    private TextField dniPacienteText;
    @FXML
    private TextField telefonoPacienteText;
    @FXML
    private TextField direccionPacienteText;
    @FXML
    private TextField emailPacienteText;

    // registro de consulta

    @FXML
    private TextField observacionesConsultaText;
    @FXML
    private DatePicker fechaConsultaDate;
    @FXML
    private TextField DniPacienteConsultaText;
    @FXML
    private TextField numeroColegiadoConsultaText;
    @FXML
    private ComboBox<Tipo> tipoComboBox1;


    //campos ListView


    @FXML
    private ListView<Doctor> listaDoctoresView;
    @FXML
    private ListView<Paciente> listaPacientesView;
    @FXML
    private ComboBox<Tipo> tipoComboBox2;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar los botones y paneles
        botonesVBox.setVisible(true);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(false);


        List<Tipo> tipos = sqlAccess.getAllTipos();
        ObservableList<Tipo> tipoList = tipoComboBox.getItems();
        tipoList.addAll(tipos);

        List<Tipo> tiposs = sqlAccess.getAllTipos();
        ObservableList<Tipo> tipoListt = tipoComboBox1.getItems();
        tipoListt.addAll(tiposs);

        // Cargar pacientes en la ListView
        List<Doctor> doctores = sqlAccess.getAllDoctores();
        ObservableList<Doctor> doctorList = FXCollections.observableArrayList(doctores);
        listaDoctoresView.setItems(doctorList);


    }

    // registro paciente
    @FXML
    private void registrarPaciente() {
        try {
            String nombre = nombrePacienteText.getText();
            String apellido = apellidoPacienteText.getText();
            String dni = dniPacienteText.getText();
            String telefono = telefonoPacienteText.getText();
            String direccion = direccionPacienteText.getText();
            String email = emailPacienteText.getText();

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, completa todos los campos.");
                alert.showAndWait();
                return;
            }


            Paciente paciente = new Paciente(nombre, apellido, dni, telefono, direccion, email);
            sqlAccess.insertPaciente(paciente);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Paciente registrado correctamente.");
            alert.showAndWait();

            // Limpiar campos
            nombrePacienteText.clear();
            apellidoPacienteText.clear();
            dniPacienteText.clear();
            telefonoPacienteText.clear();
            direccionPacienteText.clear();
            emailPacienteText.clear();
        }catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al registrar el paciente: " + e.getMessage());
            alert.showAndWait();
        }
    }

    // registro doctor

    @FXML
    private void registrarDoctor() {
        try {
            String nombre = nombreDoctorText.getText();
            String apellido = apellidoDoctorText.getText();
            String dni = dniDoctorText.getText();
            String telefono = telefonoDoctorText.getText();
            String direccion = direccionDoctorText.getText();
            String email = emailDoctorText.getText();
            String nColegiado = nColegiadoText.getText();
            LocalDate fechaValdecilla = fechaValdecillaText.getValue();
            Tipo tipo = tipoComboBox.getValue();

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty() || nColegiado.isEmpty() || fechaValdecilla == null || tipo == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, completa todos los campos.");
                alert.showAndWait();
                return;
            }

            Doctor doctor = new Doctor(nombre, apellido, dni, telefono, direccion, email, nColegiado, tipo, fechaValdecilla);
            sqlAccess.insertDoctor(doctor);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Doctor registrado correctamente.");
            alert.showAndWait();

            List<Doctor> doctores = sqlAccess.getAllDoctores();
            ObservableList<Doctor> doctorList = FXCollections.observableArrayList(doctores);
            listaDoctoresView.setItems(doctorList);

            // Limpiar campos
            nombreDoctorText.clear();
            apellidoDoctorText.clear();
            dniDoctorText.clear();
            telefonoDoctorText.clear();
            direccionDoctorText.clear();
            emailDoctorText.clear();
            nColegiadoText.clear();
            fechaValdecillaText.setValue(null);
            tipoComboBox.setValue(null);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al registrar el doctor: " + e.getMessage());
        }
    }

    private List<Doctor> loadFileProductos(){
        return FileUtils.readFile("export_Productos.dat");
    }

    @FXML
    private void saveInFile() {
        FileUtils.WriteFile("export_Productos.dat", new LinkedList<Doctor>());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Datos Exportados");
        alert.showAndWait();
    }




    //Ventanas
    @FXML
    private void panelPaciente(){
        botonesVBox.setVisible(false);
        registrarPaciente.setVisible(true);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(false);


    }
    @FXML
    private void panelDoctor(){
        botonesVBox.setVisible(false);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(true);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(false);

    }
    @FXML
    private void panelConsulta(){
        botonesVBox.setVisible(false);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(true);
        tablaPanel.setVisible(false);

    }
    @FXML
    private void panelLista(){
        botonesVBox.setVisible(false);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(true);


        // Cargar doctores en la ListView
        List<Doctor> doctores = sqlAccess.getAllDoctores();
        ObservableList<Doctor> doctorList = FXCollections.observableArrayList(doctores);
        listaDoctoresView.setItems(doctorList);



    }
    @FXML
    private void panelPacientes(){
        botonesVBox.setVisible(false);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(false);

        // Cargar pacientes en la ListView
        List<Paciente> pacientes = sqlAccess.getAllPacientes();
        ObservableList<Paciente> pacienteList = FXCollections.observableArrayList(pacientes);
        listaPacientesView.setItems(pacienteList);



    }
    @FXML
    private void volver(){
        botonesVBox.setVisible(true);
        registrarPaciente.setVisible(false);
        registrarDoctor.setVisible(false);
        registrarConsulta.setVisible(false);
        tablaPanel.setVisible(false);

    }
    @FXML
    private void salir() {
        Platform.exit();
    }





}



