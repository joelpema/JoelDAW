module com.decroly.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires bcrypt;
    requires java.desktop;


    opens com.decroly.demo to javafx.fxml;
    exports com.decroly.demo;
}