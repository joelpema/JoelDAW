package com.decroly.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private AnchorPane mainPanel;

    @FXML
    private VBox loginPanel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button forgetButton;

    @FXML
    private Button registMiniButton;

    @FXML
    private VBox registerPanel;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telefonoField;

    @FXML
    private PasswordField contraseñaField;

    @FXML
    private Button registrarButton;

    @FXML
    private Button rememberButton;

    @FXML
    private VBox forgetPasswordPanel;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField repeatPasswordField;

    @FXML
    private Button resetPaswordButton;

    @FXML
    private VBox mainMenuPanel;

    @FXML
    private Button btnReserva;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private VBox reservaPanel;

    @FXML
    private Button reservarBoleraBtn;

    @FXML
    private Button reservarPiscinaBtn;

    @FXML
    private Button reservarPistaBtn;

    @FXML
    private Button backtomenuBtn;

    @FXML
    private VBox reservaBoleraPanel;

    @FXML
    private Button volveramenuBoleraBtn;

    @FXML
    private DatePicker fechadeinicioBoleraField;

    @FXML
    private DatePicker fechadefinBoleraField;

    @FXML
    private Button reservaBoleraBtn;

    @FXML
    private VBox reservaPiscinaPanel;

    @FXML
    private Button volveramenuPiscinaBtn;

    @FXML
    private DatePicker fechadeinicioPiscinaField;

    @FXML
    private DatePicker fechadefinPiscinaField;

    @FXML
    private Button reservaPiscinaBtn;

    @FXML
    private VBox reservaPistaPanel;

    @FXML
    private Button volveramenuPistaBtn;

    @FXML
    private DatePicker fechadeinicioPistaField;

    @FXML
    private DatePicker fechadefinPistaField;

    @FXML
    private Button reservaPistaBtn;

    public void initialize() {

    }
}