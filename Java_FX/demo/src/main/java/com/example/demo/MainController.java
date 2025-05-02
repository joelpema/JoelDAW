package com.example.demo;

import com.example.demo.model.Persona;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Persona person;

    @FXML
    private VBox mainPanel;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField surNameTextField;

    @FXML
    private TextField ageTextField;



    @FXML
    protected void onSaveButtonAction(ActionEvent event) {
        person = new Persona();

        try {
            person.setName(nameTextField.getText());
            person.setApellido(surNameTextField.getText());
            person.setEdad(Integer.parseInt(ageTextField.getText()));
            person.setEmail(emailTextField.getText());
            person.setTelefono(phoneTextField.getText());

            nameTextField.clear();
            surNameTextField.clear();
            ageTextField.clear();
            emailTextField.clear();
            phoneTextField.clear();

        } catch (NumberFormatException e) {
            ageTextField.getText();
            ageTextField.setPromptText("Ponga un numero!!");
        }



    }

    @FXML
    protected void onCloseButtonAction(ActionEvent event) {
        Platform.exit();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.setPromptText("Nombre");
        surNameTextField.setPromptText("Apellido");
        ageTextField.setPromptText("Edad");
        emailTextField.setPromptText("Email");
        phoneTextField.setPromptText("Telefono");
    }
}