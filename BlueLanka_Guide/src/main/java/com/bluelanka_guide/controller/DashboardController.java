package com.bluelanka_guide.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class DashboardController {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSurfing;

    @FXML
    private Button btnDiving;

    @FXML
    private Button btnAbout;

    @FXML
    private Button btnExit;

    @FXML
    void initialize() {
        System.out.println("Controller initialized");
    }

    @FXML
    void handleHomeAction(ActionEvent event) {
        showInfo("Home", "You are already on the home page.");
    }

    @FXML
    void handleSurfingAction(ActionEvent event) {
        showInfo("Surfing Spots", "This will show safe surfing spots.");
        // Navigate or load Surfing page
    }

    @FXML
    void handleDivingAction(ActionEvent event) {
        showInfo("Diving Locations", "This will show safe diving locations.");
        // Navigate or load Diving page
    }

    @FXML
    void handleAboutAction(ActionEvent event) {
        showInfo("About", "SafeSea Explorer helps you find safe surfing and diving spots.");
    }

    @FXML
    void handleExitAction(ActionEvent event) {
        System.exit(0);
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}