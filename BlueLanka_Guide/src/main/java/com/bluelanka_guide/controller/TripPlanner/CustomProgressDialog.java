package com.bluelanka_guide.controller.TripPlanner;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

// 4. Progress Dialog
public class CustomProgressDialog extends Dialog<Void> {
    private ProgressIndicator progressIndicator;
    private Label statusLabel;

    public CustomProgressDialog(String title) {
        setTitle(title);
        setHeaderText(null);

        VBox content = new VBox(100);
        content.setPadding(new Insets(150));
        content.setStyle("-fx-alignment: center;");

        progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(-1); // Indeterminate

        statusLabel = new Label("Processing...");
        statusLabel.setStyle("-fx-font-size: 12px;");

        content.getChildren().addAll(progressIndicator, statusLabel);
        getDialogPane().setContent(content);

        // Only cancel button
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().add(cancelButton);

        setResultConverter(dialogButton -> null);
    }

    public void updateProgress(double progress, String status) {
        progressIndicator.setProgress(progress);
        statusLabel.setText(status);
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
