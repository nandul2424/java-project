module com.bluelanka_guide {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
<<<<<<< HEAD
=======
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
>>>>>>> 80e02d43eae397bc8544ba0d44eb72367c5221f9


    opens com.bluelanka_guide to javafx.fxml;
    opens com.bluelanka_guide.controller.TravelToolsPage to javafx.fxml;
<<<<<<< HEAD
=======
    opens com.bluelanka_guide.controller to javafx.fxml;
>>>>>>> 80e02d43eae397bc8544ba0d44eb72367c5221f9
    exports com.bluelanka_guide.controller;
    exports com.bluelanka_guide.controller.TravelToolsPage;
    exports com.bluelanka_guide;
}