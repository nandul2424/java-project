package com.bluelanka_guide.controller.TripPlanner;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

// 3. Bounce Animation Dialog
public class BounceDialog extends Dialog<String> {

    public BounceDialog(String title, String message) {
        setTitle(title);
        setHeaderText(null);

        // Create modern card-style content
        VBox content = createCardContent(message);
        getDialogPane().setContent(content);

        // Add buttons
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        getDialogPane().getButtonTypes().addAll(yesButton, noButton);

        // Apply glass morphism styling
        applyGlassMorphism();

        // Add bounce animation
        addBounceAnimation();

        setResultConverter(dialogButton -> {
            if (dialogButton == yesButton) return "YES";
            if (dialogButton == noButton) return "NO";
            return null;
        });
    }

    private VBox createCardContent(String message) {
        VBox content = new VBox(20);
        content.setPadding(new Insets(30));
        content.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.1);" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-color: rgba(255, 255, 255, 0.2);" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 20px;"
        );

        // Add backdrop blur effect
        content.setEffect(new GaussianBlur(0.5));

        Label titleLabel = new Label("Confirmation");
        titleLabel.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #2c3e50;"
        );

        Label messageLabel = new Label(message);
        messageLabel.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #34495e;" +
                        "-fx-wrap-text: true;"
        );

        content.getChildren().addAll(titleLabel, messageLabel);
        return content;
    }

    private void applyGlassMorphism() {
        getDialogPane().setStyle(
                "-fx-background-color: linear-gradient(135deg, rgba(255,255,255,0.1), rgba(255,255,255,0));" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-color: rgba(255,255,255,0.18);" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 25, 0.2, 0, 10);"
        );

        // Style buttons with gradient
        getDialogPane().lookupButton(getDialogPane().getButtonTypes().get(0)).setStyle(
                "-fx-background-color: linear-gradient(45deg, #667eea 0%, #764ba2 100%);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 25px;" +
                        "-fx-min-width: 100px;" +
                        "-fx-padding: 10px 20px;"
        );

        getDialogPane().lookupButton(getDialogPane().getButtonTypes().get(1)).setStyle(
                "-fx-background-color: linear-gradient(45deg, #f093fb 0%, #f5576c 100%);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 25px;" +
                        "-fx-min-width: 100px;" +
                        "-fx-padding: 10px 20px;"
        );
    }

    private void addBounceAnimation() {
        Scale scale = new Scale(0.1, 0.1);
        getDialogPane().getTransforms().add(scale);

        setOnShown(e -> {
            Timeline bounceTimeline = new Timeline(
                    new KeyFrame(Duration.millis(0),
                            new KeyValue(scale.xProperty(), 0.1),
                            new KeyValue(scale.yProperty(), 0.1)
                    ),
                    new KeyFrame(Duration.millis(200),
                            new KeyValue(scale.xProperty(), 1.1, Interpolator.EASE_OUT),
                            new KeyValue(scale.yProperty(), 1.1, Interpolator.EASE_OUT)
                    ),
                    new KeyFrame(Duration.millis(300),
                            new KeyValue(scale.xProperty(), 0.95, Interpolator.EASE_IN),
                            new KeyValue(scale.yProperty(), 0.95, Interpolator.EASE_IN)
                    ),
                    new KeyFrame(Duration.millis(400),
                            new KeyValue(scale.xProperty(), 1.0, Interpolator.EASE_OUT),
                            new KeyValue(scale.yProperty(), 1.0, Interpolator.EASE_OUT)
                    )
            );
            bounceTimeline.play();
        });
    }
}
