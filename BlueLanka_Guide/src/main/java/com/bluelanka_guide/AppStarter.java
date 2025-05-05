package com.bluelanka_guide;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AppStarter.class.getResource("/FXML/TravelToolsPage/TravelTools.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Travel Tools");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
