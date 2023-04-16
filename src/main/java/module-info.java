module com.example.moodle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.moodle to javafx.fxml;
    exports com.example.moodle;
}