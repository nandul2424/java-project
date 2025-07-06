package com.bluelanka_guide.controller.TripPlanner;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

// 1. Fade and Scale Animation Dialog
public class FadeScaleDialog extends Dialog<String> {

    public FadeScaleDialog(String title, String message) {
        setTitle(title);
        setHeaderText(null);

        // Create content
        VBox content = createStyledContent(message);
        getDialogPane().setContent(content);

        // Add buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        // Apply modern styling
        applyModernStyling();

        // Add animations
        addFadeScaleAnimation();

        setResultConverter(dialogButton -> {
            if (dialogButton == okButton) return "OK";
            return null;
        });
    }

    private VBox createStyledContent(String message) {
        VBox content = new VBox(15);
        content.setPadding(new Insets(30));
        content.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);" +
                        "-fx-background-radius: 15px;"
        );

        Label messageLabel = new Label(message);
        messageLabel.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-wrap-text: true;"
        );

        content.getChildren().add(messageLabel);
        return content;
    }

    private void applyModernStyling() {
        getDialogPane().setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 20, 0.3, 0, 8);"
        );

        // Style buttons
        getDialogPane().lookupButton(getDialogPane().getButtonTypes().get(0)).setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-min-width: 80px;"
        );

        getDialogPane().lookupButton(getDialogPane().getButtonTypes().get(1)).setStyle(
                "-fx-background-color: #f44336;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-min-width: 80px;"
        );
    }

    private void addFadeScaleAnimation() {
        // Initial state
        getDialogPane().setOpacity(0);
        Scale scale = new Scale(0.8, 0.8);
        getDialogPane().getTransforms().add(scale);

        // Show animation
        setOnShown(e -> {
            FadeTransition fade = new FadeTransition(Duration.millis(300), getDialogPane());
            fade.setFromValue(0);
            fade.setToValue(1);

            Timeline scaleTimeline = new Timeline(
                    new KeyFrame(Duration.millis(300),
                            new KeyValue(scale.xProperty(), 1.0, Interpolator.EASE_OUT),
                            new KeyValue(scale.yProperty(), 1.0, Interpolator.EASE_OUT)
                    )
            );

            ParallelTransition parallel = new ParallelTransition(fade, scaleTimeline);
            parallel.play();
        });
    }
}
