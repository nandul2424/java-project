package com.bluelanka_guide.controller;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    public Button btnDashboard;
    public Button btnDestinations;
    public Button btnTravelTools;
    public Button btnTripPlanner;
//    public Button btnSettings;
    public Button btnLogout;
    public Button btnExit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDashboard.setOnAction(event -> onDashboard());
        btnDestinations.setOnAction(event -> onDestination());
        btnTravelTools.setOnAction(event -> onTraveltools());
        btnTripPlanner.setOnAction(event -> onTripPlanner());
//        btnSettings.setOnAction(event -> onSettings());
        btnLogout.setOnAction(event -> {
            try {
                onLogout();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnExit.setOnAction(event -> onExit());
    }

    private void onExit() {
        System.out.println("Exit button clicked");
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    private void onLogout() throws IOException {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactoryMain().showLoginWindow();
    }

//    private void onSettings() {
//        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("Settings");
//    }

    private void onTripPlanner() {
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("TripPlanner");
    }

    private void onTraveltools() {
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("TravelTools");
    }

    private void onDestination() {
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("Destinations");
    }

    private void onDashboard() {
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("Dashboard");
    }
}
