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
    private RadioButton checkMirissa, checkUnawatuna, checkArugambay, checkHikkaduwa, checkTangalle, checkBentota, checkKalpitiya;

    @FXML
    private RadioButton radCoastal, radOpenSea, radIslandHopping, radMixed;
    @FXML
    private RadioButton radDayTrip, radWeekend, radWeek, radExtended;

    @FXML
    private RadioButton radBudgetFriendly, radBudgetModerate, radBudgetLuxury;

    @FXML
    private CheckBox checkRelaxation, checkSnorkeling, checkDiving, checkFishing;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }

    public int currentTabIndex = 0;
    public final int TOTAL_TABS = 5;
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
        if (validateCurrentTab()) {
            if (currentTabIndex < TOTAL_TABS - 1) {
                currentTabIndex++;
                mainTabPane.getSelectionModel().select(currentTabIndex);

                // Enable the next tab
                mainTabPane.getTabs().get(currentTabIndex).setDisable(false);

                updateButtonStates();
            }
        }
    }

    public void handlePreviousButton(ActionEvent actionEvent) {
        if (currentTabIndex > 0) {
            currentTabIndex--;
            mainTabPane.getSelectionModel().select(currentTabIndex);
            updateButtonStates();
        }
    }

    @FXML
    public void handleGenerateTripPlan(ActionEvent actionEvent) {

    }
    // =======================================================================================================================
    private boolean validateCurrentTab() {
        return switch (currentTabIndex) {
            case 0 -> validateDestinations(); // Destination tab
            case 1 -> validateDuration(); // Duration tab
            case 2 -> validateActivities(); // Activities tab
            case 3 -> validateBudget(); // Budget tab
            default -> true;
        };
    }

    private boolean validateDestinations() {
        boolean geographicRegion = checkMirissa.isSelected() || checkUnawatuna.isSelected() || checkArugambay.isSelected() || checkHikkaduwa.isSelected() || checkTangalle.isSelected() || checkBentota.isSelected() || checkKalpitiya.isSelected();
        boolean experienceType = radCoastal.isSelected() || radOpenSea.isSelected() || radIslandHopping.isSelected() || radMixed.isSelected();

        if (!geographicRegion) {
            showAlert("Validation Error", "Please select at least one geographic region.");
            return false;
        }

        if (!experienceType) {
            showAlert("Validation Error", "Please select at least one experience type.");
            return false;
        }

        return true;
    }
    private boolean validateDuration() {
        return true;
    }
    private boolean validateActivities() {
        return true;
    }
    private boolean validateBudget() {
        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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