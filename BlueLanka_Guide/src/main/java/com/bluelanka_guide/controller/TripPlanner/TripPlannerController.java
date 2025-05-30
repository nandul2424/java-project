package com.bluelanka_guide.controller.TripPlanner;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TripPlannerController implements Initializable{
    @FXML
    private Label welcomeText;



    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab destinationsTab;

    @FXML
    private Tab durationTab;

    @FXML
    private Tab activitiesTab;

    @FXML
    private Tab budgetTab;

    @FXML
    private Button nextActionButton;

    @FXML
    private Button prevActionButton;

    @FXML
    private Button GenerateActionButton;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }

    private int currentTabIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set initial tab selection
        mainTabPane.getSelectionModel().select(0);
        updateButtonStates();

        // Add listener to tab selection changes
        mainTabPane.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentTabIndex = newValue.intValue();
            updateButtonStates();
        });

        // Disable tab switching by clicking (force linear navigation)
        for (Tab tab : mainTabPane.getTabs()) {
            tab.setDisable(true);
        }
        // Enable only the first tab
        if (!mainTabPane.getTabs().isEmpty()) {
            mainTabPane.getTabs().get(0).setDisable(false);
        }
    }

    public void handleNextButton(ActionEvent actionEvent) {

    }

    public void handlePreviousButton(ActionEvent actionEvent) {

    }

    public void handleGenerateTripPlan(ActionEvent actionEvent) {

    }


    private void updateButtonStates() {
        // Update Previous button
        prevActionButton.setDisable(currentTabIndex == 0);

        // Update Next button
        // Destinations, Duration, Activities, Budget, Travelers
        int TOTAL_TABS = 5;
        if (currentTabIndex == TOTAL_TABS - 1) {
            nextActionButton.setVisible(false);
            GenerateActionButton.setVisible(true);
        } else {
            nextActionButton.setVisible(true);
            GenerateActionButton.setVisible(false);
            nextActionButton.setDisable(false);
        }
    }

}