module com.decroly.practica_examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.decroly.practica_examen to javafx.fxml;
    exports com.decroly.practica_examen;
}