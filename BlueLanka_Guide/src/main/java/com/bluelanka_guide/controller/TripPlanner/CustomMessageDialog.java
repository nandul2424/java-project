package com.bluelanka_guide.controller.TripPlanner;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CustomMessageDialog extends Dialog<String> {

    public CustomMessageDialog(String title, String message) {
        setTitle(title);
        setHeaderText(null);

        // Create custom content
        VBox content = new VBox(10);
        content.setPadding(new Insets(20));

        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        messageLabel.setStyle("-fx-font-size: 14px;");

        content.getChildren().add(messageLabel);

        // Set the content
        getDialogPane().setContent(content);

        // Add buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        // Convert result
        setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                return "OK";
            }
            return null;
        });

        // Apply custom styling
        getDialogPane().setStyle(
                "-fx-background-color: #f4f4f4;" +
                        "-fx-border-color: #cccccc;" +
                        "-fx-border-width: 1px;"
        );
    }
}
