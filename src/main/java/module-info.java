module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Controllers to javafx.fxml;
    exports Controllers;

    exports view;
    opens view to javafx.fxml;


}