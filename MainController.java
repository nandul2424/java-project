package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label mainLabel;

    @FXML
    private void handleHome() {
        mainLabel.setText("🏠 Homepage: Explore safe surfing and travel zones in Sri Lanka.");
    }

    @FXML
    private void handleDestinations() {
        mainLabel.setText("📍 Destinations: View top surfing and sea travel areas.");
    }

    @FXML
    private void handleTripPlanner() {
        mainLabel.setText("🗺️ Trip Planner: Customize your perfect coastal journey.");
    }

    @FXML
    private void handleTools() {
        mainLabel.setText("🧰 Travel Tools: Access weather, tides, and safety tips.");
    }

    @FXML
    private void handleEmergency() {
        mainLabel.setText("🚨 Emergency Contacts: Call local authorities or coast guards.");
    }

    @FXML
    private void handleMap() {
        mainLabel.setText("🗾 Operational Map: See our active service coverage.");
    }

    @FXML
    private void handleBug() {
        mainLabel.setText("🐞 Report a Bug: Help us fix problems by reporting them.");
    }

    @FXML
    private void handleTroubleshoot() {
        mainLabel.setText("🔧 Troubleshooting: Resolve app issues with help guides.");
    }
}
