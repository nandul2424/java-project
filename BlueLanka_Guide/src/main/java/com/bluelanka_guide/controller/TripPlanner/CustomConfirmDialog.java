package com.bluelanka_guide.controller.TripPlanner;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

// 3. Confirmation Dialog with Custom Styling
public class CustomConfirmDialog extends Dialog<Boolean> {

    public CustomConfirmDialog(String title, String message, String confirmText, String cancelText) {
        setTitle(title);
        setHeaderText(null);

        // Create content with icon
        HBox content = new HBox(15);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-alignment: center-left;");

        // Warning icon (you can use FontAwesome or other icon fonts)
        Label icon = new Label("⚠");
        icon.setStyle("-fx-font-size: 24px; -fx-text-fill: #ff6b35;");

        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(300);

        content.getChildren().addAll(icon, messageLabel);
        getDialogPane().setContent(content);

        // Custom buttons
        ButtonType confirmButton = new ButtonType(confirmText, ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType(cancelText, ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(confirmButton, cancelButton);

        // Style buttons
        getDialogPane().lookupButton(confirmButton).setStyle(
                "-fx-background-color: #ff6b35; -fx-text-fill: white; -fx-font-weight: bold;"
        );

        // Result converter
        setResultConverter(dialogButton -> dialogButton == confirmButton);

        // Overall dialog styling
        getDialogPane().setStyle(
                "-fx-background-color: white;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0.2, 2, 2);"
        );
    }
}
