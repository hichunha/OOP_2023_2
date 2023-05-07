module com.example.moodle {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.moodle to javafx.fxml;
    exports com.example.moodle;

    opens com.example.moodle.TestPreview to javafx.fxml;
    exports com.example.moodle.TestPreview;
    
    opens com.example.moodle.MenuBar to javafx.fxml;
    exports com.example.moodle.MenuBar;

    opens com.example.moodle.TestList to javafx.fxml;
    exports com.example.moodle.TestList;

    opens com.example.moodle.Header to javafx.fxml;
    exports com.example.moodle.Header;

    opens com.example.moodle.UI to javafx.fxml;
    exports com.example.moodle.UI;
}