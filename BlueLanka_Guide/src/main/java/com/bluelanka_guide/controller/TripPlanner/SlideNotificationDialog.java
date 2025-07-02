package com.bluelanka_guide.controller.TripPlanner;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

// 2. Slide-in Notification Dialog
public class SlideNotificationDialog extends Dialog<Void> {

    public SlideNotificationDialog(String message, NotificationType type) {
        setTitle("Notification");
        setHeaderText(null);

        // Create content
        HBox content = createNotificationContent(message, type);
        getDialogPane().setContent(content);

        // Only OK button
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().add(okButton);

        // Apply notification styling
        applyNotificationStyling(type);

        // Add slide animation
        addSlideAnimation();

        // Auto-close after 3 seconds
        addAutoClose();
    }

    private HBox createNotificationContent(String message, NotificationType type) {
        HBox content = new HBox(15);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-alignment: center-left;");

        // Icon based on type
        Label icon = new Label(getIconForType(type));
        icon.setStyle("-fx-font-size: 24px; -fx-text-fill: " + getColorForType(type) + ";");

        Label messageLabel = new Label(message);
        messageLabel.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-wrap-text: true;"
        );

        content.getChildren().addAll(icon, messageLabel);
        return content;
    }

    private void applyNotificationStyling(NotificationType type) {
        String borderColor = getColorForType(type);
        getDialogPane().setStyle(
                "-fx-background-color: white;" +
                        "-fx-border-color: " + borderColor + ";" +
                        "-fx-border-width: 0 0 0 5px;" +
                        "-fx-background-radius: 8px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0.2, 2, 2);"
        );
    }

    private void addSlideAnimation() {
        // Start off-screen
        getDialogPane().setTranslateX(300);

        setOnShown(e -> {
            TranslateTransition slide = new TranslateTransition(Duration.millis(400), getDialogPane());
            slide.setFromX(300);
            slide.setToX(0);
            slide.setInterpolator(Interpolator.EASE_OUT);
            slide.play();
        });
    }

    private void addAutoClose() {
        Timeline autoClose = new Timeline(new KeyFrame(Duration.seconds(3), e -> close()));
        autoClose.play();
    }

    private String getIconForType(NotificationType type) {
        switch (type) {
            case SUCCESS: return "✓";
            case WARNING: return "⚠";
            case ERROR: return "✗";
            case INFO: return "ℹ";
            default: return "ℹ";
        }
    }

    private String getColorForType(NotificationType type) {
        switch (type) {
            case SUCCESS: return "#4CAF50";
            case WARNING: return "#FF9800";
            case ERROR: return "#f44336";
            case INFO: return "#2196F3";
            default: return "#2196F3";
        }
    }

    public enum NotificationType {
        SUCCESS, WARNING, ERROR, INFO
    }
}
