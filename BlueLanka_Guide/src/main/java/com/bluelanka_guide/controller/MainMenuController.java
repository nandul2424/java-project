package com.bluelanka_guide.controller;

import com.bluelanka_guide.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    public Button btnDashboard;
    public Button btnDestinations;
    public Button btnTravelTools;
    public Button btnTripPlanner;
    public Button btnSettings;
    public Button btnLogout;
    public Button btnExit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDashboard.setOnAction(event -> onDashboard());
        btnDestinations.setOnAction(event -> onDestination());
        btnTravelTools.setOnAction(event -> onTraveltools());
        btnTripPlanner.setOnAction(event -> onTripPlanner());
        btnSettings.setOnAction(event -> onSettings());
        btnLogout.setOnAction(event -> onLogout());
        btnExit.setOnAction(event -> onExit());
    }

    private void onExit() {
        System.out.println("Exit button clicked");
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    private void onLogout() {
        System.out.println("Logout button clicked");
    }

    private void onSettings() {
        System.out.println("Settings button clicked");
    }

    private void onTripPlanner() {
        System.out.println("Trip Planner button clicked");
    }

    private void onTraveltools() {
        System.out.println("Travel Tools button clicked");
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("TravelTools");
    }

    private void onDestination() {
        System.out.println("Destination button clicked");
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("Destinations");
    }

    private void onDashboard() {
        System.out.println("Dashboard button clicked");
        Model.getInstance().getViewFactoryMain().getMainMenuSelectedItem().set("Dashboard");
    }
}
