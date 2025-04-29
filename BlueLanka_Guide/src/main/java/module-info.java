module com.bluelanka_guide {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bluelanka_guide to javafx.fxml;
    exports com.bluelanka_guide;
}