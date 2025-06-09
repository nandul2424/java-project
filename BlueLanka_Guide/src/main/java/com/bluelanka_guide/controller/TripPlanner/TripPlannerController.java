package com.bluelanka_guide.controller.TripPlanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class TripPlannerController implements Initializable{




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

    // FXML injected toggle groups
    @FXML private ToggleGroup destinations;
    @FXML private ToggleGroup experienceType;
    @FXML private ToggleGroup tripDuration;
    @FXML private ToggleGroup budgetType;

    private ObservableList<UserTripPlan> tripList = FXCollections.observableArrayList();

    public int currentTabIndex = 0;
    public final int TOTAL_TABS = 4;

    UserTripPlan currentTripPlan = new UserTripPlan();
    private void setupValueListeners() {
        // Gender selection listener
        destinations.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            currentTripPlan.geographic_region = getRadioButtonValue(newToggle);

        });

        // Size selection listener
        experienceType.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            currentTripPlan.experience_type = getRadioButtonValue(newToggle);

        });

        // Color selection listener
        tripDuration.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            currentTripPlan.trip_duration = getRadioButtonValue(newToggle);

        });

        // Color selection listener
        budgetType.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            currentTripPlan.budget_range = getRadioButtonValue(newToggle);

        });
    }

    // Helper method to get radio button value from toggle
    private String getRadioButtonValue(Toggle toggle) {
        if (toggle != null) {
            return ((RadioButton) toggle).getText();
        }
        return "";
    }

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

        // load data from json file
        loadDataFromJSON();
    }

    private void loadDataFromJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Load JSON file from resources or absolute path
            File jsonFile = new File("src/main/resources/FXML/TripPlanner/data/trip_plan_data.json");
            // Or from resources:
            // InputStream inputStream = getClass().getResourceAsStream("/data.json");

            // Parse JSON to List of Person objects
            List<UserTripPlan> persons = mapper.readValue(jsonFile,
                    new TypeReference<List<UserTripPlan>>() {});

            // Add to observable list
            tripList.addAll(persons);

        } catch (IOException e) {
            System.err.println("Error loading JSON data: " + e.getMessage());
            e.printStackTrace();
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
        if (validateAllTabs()) {
            // Collect all form data and generate trip plan
            generateTripPlan();
        }

    }
    
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
        boolean validDuration = radDayTrip.isSelected() || radWeekend.isSelected() || radWeek.isSelected() || radExtended.isSelected();
        if (!validDuration) {
            showAlert("Validation Error", "Please select at least one duration.");
            return false;
        }

        return true;
    }
    private boolean validateActivities() {
        boolean validActivities = checkRelaxation.isSelected() || checkSnorkeling.isSelected() || checkDiving.isSelected() || checkFishing.isSelected();
        if (!validActivities) {
            showAlert("Validation Error", "Please select at least one activities.");
            return false;
        }
        return true;
    }
    private boolean validateBudget() {
        return true;
    }

    private boolean validateAllTabs() {
        for (int i = 0; i < TOTAL_TABS; i++) {
            int tempIndex = currentTabIndex;
            currentTabIndex = i;
            if (!validateCurrentTab()) {
                currentTabIndex = tempIndex;
                return false;
            }
            currentTabIndex = tempIndex;
        }
        return true;
    }

    private void generateTripPlan() {
        // Collect all selected data
        StringBuilder tripData = new StringBuilder();
        tripData.append("Selected Destinations:\n");

        if (checkMirissa.isSelected()) tripData.append("- Mirissa\n");
        if (checkUnawatuna.isSelected()) tripData.append("- Unawatuna\n");
        if (checkArugambay.isSelected()) tripData.append("- Arugambay\n");
        if (checkHikkaduwa.isSelected()) tripData.append("- Hikkaduwa\n");
        if (checkTangalle.isSelected()) tripData.append("- Tangalle\n");
        if (checkBentota.isSelected()) tripData.append("- Bentota\n");
        if (checkKalpitiya.isSelected()) tripData.append("- Kalpitiya\n");


        tripData.append("\nSelected Experiences:\n");
        if (radCoastal.isSelected()) tripData.append("- Coastal Exploration\n");
        if (radOpenSea.isSelected()) tripData.append("- Open Sea Adventure\n");
        if (radIslandHopping.isSelected()) tripData.append("- Island Hopping\n");
        if (radMixed.isSelected()) tripData.append("- Mixed Experience\n");

        tripData.append("\n Trip Duration:\n");
        if (radDayTrip.isSelected()) tripData.append("- Day Trip\n");
        if (radWeekend.isSelected()) tripData.append("- Weekend\n");
        if (radWeek.isSelected()) tripData.append("- Week\n");
        if (radExtended.isSelected()) tripData.append("- Extended\n");

        tripData.append("\nSelected Activities:\n");
        if(checkRelaxation.isSelected()) tripData.append("- Relaxation\n");
        if (checkSnorkeling.isSelected()) tripData.append("- Snorkeling\n");
        if (checkDiving.isSelected()) tripData.append("- Diving\n");
        if (checkFishing.isSelected()) tripData.append("- Fishing\n");

        tripData.append("\nSelected Budget:\n");
        //  radBudgetFriendly, radBudgetModerate, radBudgetLuxury;
        if(radBudgetFriendly.isSelected()) tripData.append("- Friendly Budget\n");
        if(radBudgetModerate.isSelected()) tripData.append("- Moderate Budget\n");
        if(radBudgetLuxury.isSelected()) tripData.append("- Luxury Budget\n");

        // Show generated trip plan (you can replace this with actual trip generation logic)
        showAlert("Trip Plan Generated", tripData.toString());

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