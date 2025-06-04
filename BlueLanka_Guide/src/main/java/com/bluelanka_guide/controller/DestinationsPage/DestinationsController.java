package com.bluelanka_guide.controller.DestinationsPage;

import com.bluelanka_guide.util.ImageResourceLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        private final String province;
        private final String activities;
        private final String bestTime;

        public Destination(int id, String name, String country, String description, double rating,
                           String imagePath, double latitude, double longitude, String province,
                           String activities, String bestTime) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.description = description;
            this.rating = rating;
            this.imagePath = imagePath;
            this.latitude = latitude;
            this.longitude = longitude;
            this.province = province;
            this.activities = activities;
            this.bestTime = bestTime;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public String getCountry() { return country; }
        public String getDescription() { return description; }
        public double getRating() { return rating; }
        public String getImagePath() { return imagePath; }
        public double getLatitude() { return latitude; }
        public double getLongitude() { return longitude; }
        public String getProvince() { return province; }
        public String getActivities() { return activities; }
        public String getBestTime() { return bestTime; }
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

        // Preload images in the background
        preloadDestinationImages();

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

        // Western Province Beaches
        destinations.add(new Destination(1, "Negombo", "Sri Lanka",
                "Browns Beach in Negombo is a popular coastal destination known for its golden sands, clear waters, and vibrant atmosphere. Famous for its fishing industry and lagoon.",
                4.8, "images/destinations/Negombo.jpg", 7.2083, 79.8358, "Western Province",
                "Swimming, Fishing, Boat Tours, Water Sports", "November to April"));

        destinations.add(new Destination(2, "Mount Lavinia", "Sri Lanka",
                "A beautiful golden sandy beach just south of Colombo, perfect for sunset viewing and romantic walks. Popular among locals and tourists alike.",
                4.6, "images/destinations/MountLavinia.jpg", 6.8344, 79.8633, "Western Province",
                "Swimming, Sunset Viewing, Dining, Beach Walks", "December to March"));

        destinations.add(new Destination(3, "Kalutara", "Sri Lanka",
                "Known for its wide sandy beaches and the famous Kalutara Bodhiya temple. Great for water sports and river activities on the Kalu Ganga.",
                4.4, "images/destinations/Kalutara.jpg", 6.5854, 79.9607, "Western Province",
                "Water Sports, Temple Visits, River Cruises", "November to April"));

        // Southern Province Beaches
        destinations.add(new Destination(4, "Hikkaduwa", "Sri Lanka",
                "A bustling beach town known for its coral reefs, surfing, and vibrant nightlife. Perfect for snorkeling and diving enthusiasts.",
                4.7, "images/destinations/Hikkaduwa.jpg", 6.1395, 80.1063, "Southern Province",
                "Surfing, Snorkeling, Diving, Nightlife", "November to April"));

        destinations.add(new Destination(5, "Unawatuna", "Sri Lanka",
                "A crescent-shaped bay with calm waters, perfect for swimming and relaxation. One of the most beautiful beaches in Sri Lanka.",
                4.8, "images/destinations/Unawatuna.jpg", 6.0108, 80.2492, "Southern Province",
                "Swimming, Snorkeling, Beach Relaxation, Yoga", "December to March"));

        destinations.add(new Destination(6, "Mirissa", "Sri Lanka",
                "Famous for whale watching and stunning sunsets. A laid-back beach town with excellent seafood and coconut tree-lined shores.",
                4.9, "images/destinations/Mirissa.jpg", 5.9487, 80.4565, "Southern Province",
                "Whale Watching, Surfing, Sunset Viewing, Fishing", "December to April"));

        destinations.add(new Destination(7, "Weligama", "Sri Lanka",
                "Known for its stilt fishermen and excellent surfing conditions. Features a beautiful bay with Snake Island accessible by foot during low tide.",
                4.5, "images/destinations/Weligama.jpg", 5.9749, 80.4293, "Southern Province",
                "Surfing, Stilt Fishing, Photography, Swimming", "November to April"));

        destinations.add(new Destination(8, "Tangalle", "Sri Lanka",
                "A peaceful fishing town with pristine beaches and minimal crowds. Perfect for those seeking tranquility and natural beauty.",
                4.6, "images/destinations/Tangalle.jpg", 6.0235, 80.7928, "Southern Province",
                "Beach Relaxation, Turtle Watching, Fishing, Photography", "December to March"));

        destinations.add(new Destination(9, "Matara", "Sri Lanka",
                "Historic coastal city with beautiful beaches and the famous Matara Fort. Great combination of culture and beach activities.",
                4.3, "images/destinations/Matara.jpg", 5.9549, 80.5550, "Southern Province",
                "Historical Tours, Beach Activities, Temple Visits", "December to March"));

        destinations.add(new Destination(10, "Koggala", "Sri Lanka",
                "Home to a large lagoon and beautiful beaches. Famous for its stilt fishermen and the Martin Wickramasinghe Folk Museum.",
                4.4, "images/destinations/Koggala.jpg", 5.9942, 80.3275, "Southern Province",
                "Lagoon Tours, Cultural Visits, Stilt Fishing, Bird Watching", "December to March"));

        // Eastern Province Beaches
        destinations.add(new Destination(11, "Arugam Bay", "Sri Lanka",
                "World-renowned surfing destination with consistent waves and a laid-back atmosphere. Popular among international surfers.",
                4.9, "images/destinations/ArugamBay.jpg", 6.8404, 81.8368, "Eastern Province",
                "Surfing, Beach Relaxation, Lagoon Safari, Yoga", "April to September"));

        destinations.add(new Destination(12, "Batticaloa", "Sri Lanka",
                "Known for its singing fish phenomenon and beautiful lagoons. Rich in Tamil culture and history.",
                4.2, "images/destinations/Batticaloa.jpg", 7.7102, 81.6924, "Eastern Province",
                "Lagoon Tours, Cultural Experiences, Fishing, Bird Watching", "April to September"));

        destinations.add(new Destination(13, "Trincomalee", "Sri Lanka",
                "Features some of the finest natural harbors in the world and pristine beaches. Rich in naval history and marine life.",
                4.7, "images/destinations/Trincomalee.jpg", 8.5874, 81.2152, "Eastern Province",
                "Whale Watching, Diving, Historical Tours, Beach Activities", "April to September"));

        destinations.add(new Destination(14, "Nilaveli", "Sri Lanka",
                "Crystal clear waters and white sandy beaches near Trincomalee. Perfect for snorkeling and diving with coral reefs nearby.",
                4.8, "images/destinations/Nilaveli.jpg", 8.6833, 81.1833, "Eastern Province",
                "Snorkeling, Diving, Beach Relaxation, Boat Tours", "April to September"));

        destinations.add(new Destination(15, "Uppuveli", "Sri Lanka",
                "A quieter alternative to Nilaveli with beautiful beaches and clear waters. Great for peaceful beach holidays.",
                4.5, "images/destinations/Uppuveli.jpg", 8.6167, 81.2167, "Eastern Province",
                "Swimming, Beach Walks, Relaxation, Photography", "April to September"));

        destinations.add(new Destination(16, "Pasikudah", "Sri Lanka",
                "Known for its shallow, calm waters extending far into the sea. Perfect for families with children and non-swimmers.",
                4.6, "images/destinations/Pasikudah.jpg", 7.9333, 81.5500, "Eastern Province",
                "Family Swimming, Water Sports, Beach Games, Relaxation", "April to September"));

        destinations.add(new Destination(17, "Kalkudah", "Sri Lanka",
                "Adjacent to Pasikudah, offering similar calm waters and beautiful coral reefs. Less crowded and more pristine.",
                4.5, "images/destinations/Kalkudah.jpg", 7.9167, 81.5333, "Eastern Province",
                "Snorkeling, Swimming, Coral Viewing, Beach Relaxation", "April to September"));

        // Northern Province Beaches
        destinations.add(new Destination(18, "Jaffna Peninsula", "Sri Lanka",
                "Unique cultural experience with beautiful beaches and rich Tamil heritage. Features pristine islands and lagoons.",
                4.3, "images/destinations/Jaffna.jpg", 9.6615, 80.0255, "Northern Province",
                "Cultural Tours, Island Hopping, Historical Sites, Fishing", "December to March"));

        destinations.add(new Destination(19, "Casuarina Beach", "Sri Lanka",
                "Located in Karainagar, known for its casuarina trees and golden sand. A peaceful retreat in the northern region.",
                4.4, "images/destinations/Casuarina.jpg", 9.7667, 79.9167, "Northern Province",
                "Beach Relaxation, Photography, Swimming, Nature Walks", "December to March"));

        // North Western Province Beaches
        destinations.add(new Destination(20, "Kalpitiya", "Sri Lanka",
                "Famous for dolphin watching and kite surfing. Features a long stretch of pristine beaches and lagoons.",
                4.7, "images/destinations/Kalpitiya.jpg", 8.2333, 79.7667, "North Western Province",
                "Dolphin Watching, Kite Surfing, Snorkeling, Lagoon Tours", "November to April"));

        destinations.add(new Destination(21, "Chilaw", "Sri Lanka",
                "Known for its fishing industry and beautiful beaches. Features the famous Munneswaram Temple nearby.",
                4.2, "images/destinations/Chilaw.jpg", 7.5756, 79.7951, "North Western Province",
                "Fishing, Temple Visits, Beach Activities, Cultural Tours", "November to April"));

        // Additional Hidden Gems
        destinations.add(new Destination(22, "Bentota", "Sri Lanka",
                "Popular resort town with water sports and river activities. Perfect blend of beach and river experiences.",
                4.6, "images/destinations/Bentota.jpg", 6.4167, 79.9958, "Southern Province",
                "Water Sports, River Safari, Turtle Hatchery, Spa Treatments", "November to April"));

        destinations.add(new Destination(23, "Beruwala", "Sri Lanka",
                "One of the first beach resorts in Sri Lanka with a rich Muslim heritage. Features beautiful mosques and beaches.",
                4.3, "images/destinations/Beruwala.jpg", 6.4792, 79.9828, "Western Province",
                "Cultural Tours, Beach Activities, Mosque Visits, Water Sports", "November to April"));

        destinations.add(new Destination(24, "Ahungalla", "Sri Lanka",
                "Quiet beach destination perfect for relaxation and turtle watching. Less commercialized than neighboring beaches.",
                4.4, "images/destinations/Ahungalla.jpg", 6.3167, 80.0833, "Southern Province",
                "Turtle Watching, Beach Relaxation, Spa Treatments, Swimming", "November to April"));

        destinations.add(new Destination(25, "Dikwella", "Sri Lanka",
                "Features the famous Wewurukannala Vihara temple and beautiful beaches. Great for cultural and beach experiences.",
                4.3, "images/destinations/Dikwella.jpg", 5.9667, 80.7000, "Southern Province",
                "Temple Visits, Beach Activities, Photography, Cultural Tours", "December to March"));

        System.out.println("Initialized " + destinations.size() + " beach destinations in Sri Lanka");
    }

    private void preloadDestinationImages() {
        // Collect all possible image paths to preload
        List<String> imagePaths = new ArrayList<>();

        for (Destination destination : destinations) {
            // Add all possible paths for each destination
            imagePaths.add("/images/destinations/" + destination.getName().replaceAll("\\s+", "") + ".jpg");
            imagePaths.add("/" + destination.getImagePath());
            imagePaths.add("/assets/icons/images/" + destination.getName().replaceAll("\\s+", "") + ".jpg");
            imagePaths.add("/resources/assets/icons/images/" + destination.getName().replaceAll("\\s+", "") + ".jpg");
        }

        // Convert to array and preload
        String[] pathsArray = imagePaths.toArray(new String[0]);
        ImageResourceLoader.preloadImages(pathsArray);
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
        card.setPrefWidth(280);

        // Image container
        StackPane imageContainer = new StackPane();
        imageContainer.setPrefHeight(140);

        // Load image using our utility class with multiple possible paths
        String imageName = destination.getName().replaceAll("\\s+", "");
        Image image = ImageResourceLoader.loadImageFromMultiplePaths(
                "/images/destinations/" + imageName + ".jpg",
                "/" + destination.getImagePath(),
                "/assets/icons/images/" + imageName + ".jpg",
                "/resources/assets/icons/images/" + imageName + ".jpg"
        );

        if (image != null) {
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(280);
            imageView.setFitHeight(140);
            imageView.setPreserveRatio(false);
            imageView.setSmooth(true);
            imageContainer.getChildren().add(imageView);
        } else {
            // Fallback to placeholder if image can't be loaded
            Rectangle placeholder = new Rectangle(280, 140);
            placeholder.setFill(Color.LIGHTGRAY);
            placeholder.setArcWidth(8);
            placeholder.setArcHeight(8);
            imageContainer.getChildren().add(placeholder);
        }

        // Rating badge
        HBox ratingBadge = createRatingBadge(destination.getRating());
        imageContainer.getChildren().add(ratingBadge);
        StackPane.setAlignment(ratingBadge, Pos.TOP_RIGHT);
        StackPane.setMargin(ratingBadge, new Insets(8));

        // Province badge
        HBox provinceBadge = createProvinceBadge(destination.getProvince());
        imageContainer.getChildren().add(provinceBadge);
        StackPane.setAlignment(provinceBadge, Pos.TOP_LEFT);
        StackPane.setMargin(provinceBadge, new Insets(8));

        // Info container
        VBox infoContainer = new VBox(5);
        infoContainer.setPadding(new Insets(0, 8, 8, 8));

        Label nameLabel = new Label(destination.getName());
        nameLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Label countryLabel = new Label(destination.getCountry() + " • " + destination.getProvince());
        countryLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label activitiesLabel = new Label("Activities: " + destination.getActivities());
        activitiesLabel.setWrapText(true);
        activitiesLabel.setMaxHeight(30);
        activitiesLabel.setStyle("-fx-font-size: 10; -fx-text-fill: #059669; -fx-font-weight: bold;");

        Label descriptionLabel = new Label(destination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxHeight(40);
        descriptionLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #4b5563;");

        Label bestTimeLabel = new Label("Best Time: " + destination.getBestTime());
        bestTimeLabel.setStyle("-fx-font-size: 10; -fx-text-fill: #dc2626; -fx-font-style: italic;");

        infoContainer.getChildren().addAll(nameLabel, countryLabel, activitiesLabel, descriptionLabel, bestTimeLabel);

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
            card.setStyle("-fx-background-color: #f0fdfa; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(13, 148, 136, 0.2), 8, 0, 0, 3); -fx-cursor: hand; -fx-padding: 8; -fx-spacing: 8;");
        });

        card.setOnMouseExited(e -> {
            card.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 4, 0, 0, 1); -fx-cursor: hand; -fx-padding: 8; -fx-spacing: 8;");
        });

        return card;
    }

    private HBox createRatingBadge(double rating) {
        HBox ratingBadge = new HBox();
        ratingBadge.setStyle("-fx-background-color: rgba(13, 148, 136, 0.9); -fx-background-radius: 12; -fx-padding: 4 8;");
        Label ratingLabel = new Label(String.format("%.1f", rating));
        ratingLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12;");
        ratingBadge.getChildren().add(ratingLabel);
        return ratingBadge;
    }

    private HBox createProvinceBadge(String province) {
        HBox provinceBadge = new HBox();
        provinceBadge.setStyle("-fx-background-color: rgba(59, 130, 246, 0.9); -fx-background-radius: 12; -fx-padding: 4 8;");
        Label provinceLabel = new Label(province.replace(" Province", ""));
        provinceLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 10;");
        provinceBadge.getChildren().add(provinceLabel);
        return provinceBadge;
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
                            dest.getDescription().toLowerCase().contains(searchText.toLowerCase()) ||
                            dest.getProvince().toLowerCase().contains(searchText.toLowerCase()) ||
                            dest.getActivities().toLowerCase().contains(searchText.toLowerCase()))
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
            // Color code markers by province
            String markerColor = getProvinceColor(dest.getProvince());

            markersJS.append(String.format(
                    "L.circleMarker([%f, %f], {" +
                            "color: '%s'," +
                            "fillColor: '%s'," +
                            "fillOpacity: 0.8," +
                            "radius: 8" +
                            "})" +
                            ".addTo(map)" +
                            ".bindPopup('<div style=\"min-width: 200px;\">" +
                            "<h3 style=\"margin: 0 0 5px 0; color: #0d9488;\">%s</h3>" +
                            "<p style=\"margin: 2px 0; font-size: 12px;\"><strong>%s</strong></p>" +
                            "<p style=\"margin: 2px 0; font-size: 11px;\">Rating: %.1f ⭐</p>" +
                            "<p style=\"margin: 2px 0; font-size: 11px;\">Activities: %s</p>" +
                            "<p style=\"margin: 2px 0; font-size: 11px;\">Best Time: %s</p>" +
                            "</div>')" +
                            ".on('click', function() { if(window.javaApp) window.javaApp.selectDestinationFromMap(%d); });\n",
                    dest.getLatitude(), dest.getLongitude(),
                    markerColor, markerColor,
                    dest.getName(), dest.getProvince(), dest.getRating(),
                    dest.getActivities(), dest.getBestTime(), dest.getId()
            ));
        }

        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Sri Lanka Beach Destinations Map</title>
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
                    .legend {
                        background: white;
                        padding: 10px;
                        border-radius: 5px;
                        box-shadow: 0 0 15px rgba(0,0,0,0.2);
                    }
                    .legend h4 {
                        margin: 0 0 5px 0;
                        color: #333;
                    }
                    .legend-item {
                        margin: 2px 0;
                        font-size: 12px;
                    }
                    .legend-color {
                        display: inline-block;
                        width: 12px;
                        height: 12px;
                        border-radius: 50%%;
                        margin-right: 5px;
                    }
                </style>
            </head>
            <body>
                <div id="map"></div>
                <script>
                    var map = L.map('map').setView([7.8731, 80.7718], 7);
                    
                    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                        attribution: '&copy; OpenStreetMap contributors',
                        maxZoom: 18
                    }).addTo(map);
                    
                    %s
                    
                    // Add legend
                    var legend = L.control({position: 'bottomright'});
                    legend.onAdd = function (map) {
                        var div = L.DomUtil.create('div', 'legend');
                        div.innerHTML = '<h4>Provinces</h4>' +
                            '<div class="legend-item"><span class="legend-color" style="background: #ef4444;"></span>Western</div>' +
                            '<div class="legend-item"><span class="legend-color" style="background: #10b981;"></span>Southern</div>' +
                            '<div class="legend-item"><span class="legend-color" style="background: #3b82f6;"></span>Eastern</div>' +
                            '<div class="legend-item"><span class="legend-color" style="background: #f59e0b;"></span>Northern</div>' +
                            '<div class="legend-item"><span class="legend-color" style="background: #8b5cf6;"></span>North Western</div>';
                        return div;
                    };
                    legend.addTo(map);
                    
                    function selectDestination(lat, lng, name) {
                        map.setView([lat, lng], 12);
                    }
                    
                    console.log('Beach destinations map initialized successfully');
                </script>
            </body>
            </html>
            """.formatted(markersJS.toString());
    }

    private String getProvinceColor(String province) {
        return switch (province) {
            case "Western Province" -> "#ef4444";
            case "Southern Province" -> "#10b981";
            case "Eastern Province" -> "#3b82f6";
            case "Northern Province" -> "#f59e0b";
            case "North Western Province" -> "#8b5cf6";
            default -> "#6b7280";
        };
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
        nameLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Label locationLabel = new Label(selectedDestination.getCountry() + " • " + selectedDestination.getProvince());
        locationLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #6b7280;");

        HBox badgesContainer = new HBox(10);
        HBox ratingBox = createRatingBadge(selectedDestination.getRating());
        HBox provinceBox = createProvinceBadge(selectedDestination.getProvince());
        badgesContainer.getChildren().addAll(ratingBox, provinceBox);

        // Image
        String imageName = selectedDestination.getName().replaceAll("\\s+", "");
        Image detailImage = ImageResourceLoader.loadImageFromMultiplePaths(
                "/images/destinations/" + imageName + ".jpg",
                "/" + selectedDestination.getImagePath(),
                "/assets/icons/images/" + imageName + ".jpg",
                "/resources/assets/icons/images/" + imageName + ".jpg"
        );

        if (detailImage != null) {
            ImageView imageView = new ImageView(detailImage);
            imageView.setFitWidth(320);
            imageView.setPreserveRatio(true);
            imageView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 3);");
            detailsContent.getChildren().add(imageView);
        }

        // Activities
        Label activitiesHeaderLabel = new Label("Activities:");
        activitiesHeaderLabel.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #059669;");

        Label activitiesLabel = new Label(selectedDestination.getActivities());
        activitiesLabel.setWrapText(true);
        activitiesLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #065f46;");

        // Best time to visit
        Label bestTimeHeaderLabel = new Label("Best Time to Visit:");
        bestTimeHeaderLabel.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #dc2626;");

        Label bestTimeLabel = new Label(selectedDestination.getBestTime());
        bestTimeLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #991b1b;");

        // Description
        Label descriptionLabel = new Label(selectedDestination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #4b5563;");

        // Buttons
        HBox buttonContainer = new HBox(10);
        Button directionsButton = new Button("Get Directions");
        directionsButton.setStyle("-fx-background-color: #0d9488; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 6;");
        directionsButton.setPrefWidth(150);

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 6;");
        saveButton.setPrefWidth(100);

        buttonContainer.getChildren().addAll(directionsButton, saveButton);

        detailsContent.getChildren().addAll(
                nameLabel, locationLabel, badgesContainer,
                activitiesHeaderLabel, activitiesLabel,
                bestTimeHeaderLabel, bestTimeLabel,
                descriptionLabel, buttonContainer
        );

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