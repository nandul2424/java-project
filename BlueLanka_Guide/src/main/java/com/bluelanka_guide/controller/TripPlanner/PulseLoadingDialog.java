package com.bluelanka_guide.controller.TripPlanner;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

// 4. Pulse Loading Dialog
public class PulseLoadingDialog extends Dialog<Void> {
    private Circle loadingCircle;
    private Timeline pulseAnimation;

    public PulseLoadingDialog(String message) {
        setTitle("Loading");
        setHeaderText(null);

        // Create pulsing content
        VBox content = createPulsingContent(message);
        getDialogPane().setContent(content);

        // Only cancel button
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().add(cancelButton);

        // Apply dark theme styling
        applyDarkTheme();

        // Start pulse animation
        startPulseAnimation();
    }

    private VBox createPulsingContent(String message) {
        VBox content = new VBox(20);
        content.setPadding(new Insets(40));
        content.setStyle("-fx-alignment: center;");

        // Create pulsing circle
        loadingCircle = new Circle(30);
        loadingCircle.setFill(Color.TRANSPARENT);
        loadingCircle.setStroke(Color.web("#00BCD4"));
        loadingCircle.setStrokeWidth(4);

        Label messageLabel = new Label(message);
        messageLabel.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-weight: bold;"
        );

        content.getChildren().addAll(loadingCircle, messageLabel);
        return content;
    }

    private void applyDarkTheme() {
        getDialogPane().setStyle(
                "-fx-background-color: #263238;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 20, 0.3, 0, 8);"
        );

        getDialogPane().lookupButton(getDialogPane().getButtonTypes().get(0)).setStyle(
                "-fx-background-color: #00BCD4;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-min-width: 80px;"
        );
    }

    private void startPulseAnimation() {
        pulseAnimation = new Timeline(
                new KeyFrame(Duration.millis(0),
                        new KeyValue(loadingCircle.scaleXProperty(), 1.0),
                        new KeyValue(loadingCircle.scaleYProperty(), 1.0),
                        new KeyValue(loadingCircle.opacityProperty(), 1.0)
                ),
                new KeyFrame(Duration.millis(1000),
                        new KeyValue(loadingCircle.scaleXProperty(), 1.5),
                        new KeyValue(loadingCircle.scaleYProperty(), 1.5),
                        new KeyValue(loadingCircle.opacityProperty(), 0.3)
                )
        );
        pulseAnimation.setCycleCount(Timeline.INDEFINITE);
        pulseAnimation.setAutoReverse(true);

        setOnShown(e -> pulseAnimation.play());
        setOnHidden(e -> pulseAnimation.stop());
    }
}
