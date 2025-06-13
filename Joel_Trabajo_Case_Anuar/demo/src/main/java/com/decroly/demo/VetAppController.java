
package com.decroly.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VetAppController implements Initializable {

    private Mascota mascota;
    private ObservableList<Mascota> mascotas;
    private SQLAccess vetdawAccess = new SQLAccess();

    @FXML
    private ListView<Mascota> mascotaListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
