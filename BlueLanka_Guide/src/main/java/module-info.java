module com.bluelanka_guide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.bluelanka_guide to javafx.fxml;
    opens com.bluelanka_guide.controller.TravelToolsPage to javafx.fxml;
    opens com.bluelanka_guide.controller to javafx.fxml;
    exports com.bluelanka_guide.controller;
    exports com.bluelanka_guide;

}