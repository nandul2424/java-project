package com.bluelanka_guide.controller.DestinationsPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DestinationsController implements Initializable {

    static class Destination {
        private final int id;
        private final String name;
        private final String country;
        private final String description;
        private final double rating;
        private final String imagePath;
        private final double latitude;
        private final double longitude;

        public Destination(int id, String name, String country, String description, double rating, String imagePath, double latitude, double longitude) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.description = description;
            this.rating = rating;
            this.imagePath = imagePath;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCountry() { return country; }
        public String getDescription() { return description; }
        public double getRating() { return rating; }
        public String getImagePath() { return imagePath; }
        public double getLatitude() { return latitude; }
        public double getLongitude() { return longitude; }
    }

    // FXML injected components
    @FXML private BorderPane root;
    @FXML private VBox sidebar;
    @FXML private StackPane mapContainer;
    @FXML private VBox destinationDetails;
    @FXML private TabPane destinationTabs;
    @FXML private TextField searchField;
    @FXML private Button toggleSidebarButton;
    @FXML private Button toggleDetailsButton;
    @FXML private Tab popularTab;
    @FXML private Tab savedTab;
    @FXML private Tab recentTab;
    @FXML private ScrollPane popularScrollPane;
    @FXML private VBox popularDestinationList;

    private boolean sidebarVisible = true;
    private boolean detailsVisible = false;
    private List<Destination> destinations;
    private Destination selectedDestination;
    private WebView webView;
    private WebEngine webEngine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing DestinationsController...");

        // Initialize destinations first
        initializeDestinations();

        // Create map view
        createMapView();

        // Populate destination list
        populateDestinationList();

        // Set up search functionality
        setupSearchFunctionality();

        // Set up toggle buttons
        setupToggleButtons();

        System.out.println("DestinationsController initialized successfully!");
    }

    private void initializeDestinations() {
        destinations = new ArrayList<>();
        destinations.add(new Destination(1, "Negombo", "Sri Lanka", "Browns Beach in Negombo is a popular coastal destination known for its golden sands, clear waters, and vibrant atmosphere, offering a perfect blend of relaxation and adventure.", 4.8, "resources/assets/icons/images/Negombo.jpg", 7.2083, 79.8358));
        destinations.add(new Destination(2, "Hikkaduwa", "Sri Lanka", "A bustling beach town known for its coral reefs, surfing, and vibrant nightlife.", 4.7, "resources/assets/icons/images/Hikkaduwa.jpg", 6.1395, 80.1063));
        destinations.add(new Destination(3, "Arugam Bay", "Sri Lanka", "Famous for its world-class surfing spots and laid-back atmosphere.", 4.6, "resources/assets/icons/images/Arugambe.jpg", 6.8404, 81.8368));
        destinations.add(new Destination(4, "Galle", "Sri Lanka", "Historic fort city with colonial architecture and beautiful beaches.", 4.5, "resources/assets/icons/images/Galle.jpg", 6.0535, 80.2210));
        destinations.add(new Destination(5, "Kandy", "Sri Lanka", "Cultural capital with the Temple of the Tooth and beautiful lake.", 4.7, "resources/assets/icons/images/Kandy.jpg", 7.2906, 80.6337));

        System.out.println("Initialized " + destinations.size() + " destinations");
    }

    private void populateDestinationList() {
        if (popularDestinationList == null) {
            System.err.println("popularDestinationList is null!");
            return;
        }

        // Clear existing content
        popularDestinationList.getChildren().clear();

        // Add destination cards
        for (Destination destination : destinations) {
            VBox card = createDestinationCard(destination);
            popularDestinationList.getChildren().add(card);
        }

        System.out.println("Added " + destinations.size() + " destination cards to the list");
    }

    private void setupSearchFunctionality() {
        if (searchField != null) {
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filterDestinations(newValue);
            });
        }
    }

    private void setupToggleButtons() {
        // Setup sidebar toggle button
        if (toggleSidebarButton != null) {
            toggleSidebarButton.setOnAction(event -> toggleSidebar());
        }

        // Setup details toggle button
        if (toggleDetailsButton != null) {
            toggleDetailsButton.setOnAction(event -> toggleDetails());

            // Update button text based on initial state
            updateToggleDetailsButtonText();
        }
    }

    private VBox createDestinationCard(Destination destination) {
        VBox card = new VBox();
        card.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 4, 0, 0, 1); -fx-cursor: hand; -fx-padding: 8; -fx-spacing: 8;");
        card.setPrefWidth(260);

        // Image container
        StackPane imageContainer = new StackPane();
        imageContainer.setPrefHeight(120);
        Rectangle imagePlaceholder = new Rectangle(260, 120);
        imagePlaceholder.setFill(Color.LIGHTGRAY);
        imagePlaceholder.setArcWidth(8);
        imagePlaceholder.setArcHeight(8);

        // Rating badge
        HBox ratingBadge = new HBox();
        ratingBadge.setStyle("-fx-background-color: rgba(13, 148, 136, 0.9); -fx-background-radius: 12; -fx-padding: 4 8;");
        Label ratingLabel = new Label(String.format("%.1f", destination.getRating()));
        ratingLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12;");
        ratingBadge.getChildren().add(ratingLabel);
        StackPane.setAlignment(ratingBadge, Pos.TOP_RIGHT);
        StackPane.setMargin(ratingBadge, new Insets(8));
        imageContainer.getChildren().addAll(imagePlaceholder, ratingBadge);

        // Info container
        VBox infoContainer = new VBox(5);
        infoContainer.setPadding(new Insets(0, 8, 8, 8));

        Label nameLabel = new Label(destination.getName());
        nameLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Label countryLabel = new Label(destination.getCountry());
        countryLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label descriptionLabel = new Label(destination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxHeight(50);
        descriptionLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #4b5563;");

        infoContainer.getChildren().addAll(nameLabel, countryLabel, descriptionLabel);

        card.getChildren().addAll(imageContainer, infoContainer);

        // Add click handler
        card.setOnMouseClicked(e -> {
            selectDestination(destination);

            // Show details panel if it's not visible
            if (!detailsVisible) {
                toggleDetails();
            }
        });

        // Add hover effects
        card.setOnMouseEntered(e -> {
            card.setStyle("-fx-background-color: #f9fafb; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 6, 0, 0, 2); -fx-cursor: hand; -fx-padding: 8; -fx-spacing: 8;");
        });

        card.setOnMouseExited(e -> {
            card.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 4, 0, 0, 1); -fx-cursor: hand; -fx-padding: 8; -fx-spacing: 8;");
        });

        return card;
    }

    private void filterDestinations(String searchText) {
        if (popularDestinationList == null) return;

        popularDestinationList.getChildren().clear();

        List<Destination> filteredDestinations;
        if (searchText == null || searchText.trim().isEmpty()) {
            filteredDestinations = destinations;
        } else {
            filteredDestinations = destinations.stream()
                    .filter(dest -> dest.getName().toLowerCase().contains(searchText.toLowerCase()) ||
                            dest.getCountry().toLowerCase().contains(searchText.toLowerCase()) ||
                            dest.getDescription().toLowerCase().contains(searchText.toLowerCase()))
                    .toList();
        }

        for (Destination destination : filteredDestinations) {
            VBox card = createDestinationCard(destination);
            popularDestinationList.getChildren().add(card);
        }

        System.out.println("Filtered to " + filteredDestinations.size() + " destinations");
    }

    private void createMapView() {
        webView = new WebView();
        webEngine = webView.getEngine();

        // Enable JavaScript-to-Java communication
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("javaApp", this);
                System.out.println("JavaScript-Java bridge established");
            }
        });

        // Load the map
        webEngine.loadContent(getEnhancedMapHtml());
        mapContainer.getChildren().add(webView);

        System.out.println("Map view created");
    }

    private String getEnhancedMapHtml() {
        StringBuilder markersJS = new StringBuilder();

        for (Destination dest : destinations) {
            markersJS.append(String.format(
                    "L.marker([%f, %f])" +
                            ".addTo(map)" +
                            ".bindPopup('<div><h3>%s</h3><p>%s</p><p>Rating: %.1f</p></div>')" +
                            ".on('click', function() { if(window.javaApp) window.javaApp.selectDestinationFromMap(%d); });\n",
                    dest.getLatitude(), dest.getLongitude(),
                    dest.getName(), dest.getCountry(), dest.getRating(), dest.getId()
            ));
        }

        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Sri Lanka Destinations Map</title>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
                <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
                <style>
                    html, body, #map {
                        height: 100%%;
                        margin: 0;
                        padding: 0;
                    }
                    .leaflet-popup-content h3 {
                        margin: 0 0 5px 0;
                        color: #0d9488;
                    }
                    .leaflet-popup-content p {
                        margin: 2px 0;
                        font-size: 12px;
                    }
                </style>
            </head>
            <body>
                <div id="map"></div>
                <script>
                    var map = L.map('map').setView([7.8731, 80.7718], 8);
                    
                    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                        attribution: '&copy; OpenStreetMap contributors',
                        maxZoom: 18
                    }).addTo(map);
                    
                    %s
                    
                    function selectDestination(lat, lng, name) {
                        map.setView([lat, lng], 15);
                        L.popup()
                            .setLatLng([lat, lng])
                            .setContent('<h3>' + name + '</h3>')
                            .openOn(map);
                    }
                    
                    console.log('Map initialized successfully');
                </script>
            </body>
            </html>
            """.formatted(markersJS.toString());
    }

    public void selectDestinationFromMap(int destinationId) {
        Destination destination = destinations.stream()
                .filter(d -> d.getId() == destinationId)
                .findFirst()
                .orElse(null);

        if (destination != null) {
            selectDestination(destination);

            // Show details panel if it's not visible
            if (!detailsVisible) {
                toggleDetails();
            }
        }
    }

    private void selectDestination(Destination destination) {
        selectedDestination = destination;
        updateDestinationDetails();

        // Update map focus
        if (webEngine != null) {
            webEngine.executeScript(String.format(
                    "selectDestination(%f, %f, '%s')",
                    destination.getLatitude(),
                    destination.getLongitude(),
                    destination.getName()
            ));
        }

        System.out.println("Selected destination: " + destination.getName());
    }

    private void updateDestinationDetails() {
        if (selectedDestination == null || destinationDetails == null) {
            if (destinationDetails != null) {
                destinationDetails.setVisible(false);
            }
            return;
        }

        destinationDetails.getChildren().clear();
        destinationDetails.setVisible(true);

        VBox detailsContent = new VBox(15);
        detailsContent.setPadding(new Insets(20));

        // Header
        Label nameLabel = new Label(selectedDestination.getName());
        nameLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Label countryLabel = new Label(selectedDestination.getCountry());
        countryLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #6b7280;");

        HBox ratingBox = new HBox();
        ratingBox.setStyle("-fx-background-color: #0d9488; -fx-background-radius: 6; -fx-padding: 6 10;");
        Label ratingLabel = new Label(String.format("%.1f", selectedDestination.getRating()));
        ratingLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        ratingBox.getChildren().add(ratingLabel);

        // Description
        Label descriptionLabel = new Label(selectedDestination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #4b5563;");

        // Buttons
        Button directionsButton = new Button("Get Directions");
        directionsButton.setStyle("-fx-background-color: #0d9488; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 6;");
        directionsButton.setPrefWidth(200);

        detailsContent.getChildren().addAll(nameLabel, countryLabel, ratingBox, descriptionLabel, directionsButton);
        destinationDetails.getChildren().add(detailsContent);
    }

    @FXML
    private void toggleSidebar() {
        sidebarVisible = !sidebarVisible;
        if (sidebarVisible) {
            root.setLeft(sidebar);
            toggleSidebarButton.setText("Hide Sidebar");
        } else {
            root.setLeft(null);
            toggleSidebarButton.setText("Show Sidebar");
        }
        System.out.println("Sidebar toggled: " + (sidebarVisible ? "visible" : "hidden"));
    }

    @FXML
    private void toggleDetails() {
        detailsVisible = !detailsVisible;
        if (detailsVisible) {
            root.setRight(destinationDetails);
        } else {
            root.setRight(null);
        }
        updateToggleDetailsButtonText();
        System.out.println("Details panel toggled: " + (detailsVisible ? "visible" : "hidden"));
    }

    private void updateToggleDetailsButtonText() {
        if (toggleDetailsButton != null) {
            toggleDetailsButton.setText(detailsVisible ? "Hide Details" : "Show Details");
        }
    }
}