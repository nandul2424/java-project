package com.bluelanka_guide.controller.TripPlanner;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

// 2. Input Dialog with Validation
public class CustomInputDialog extends Dialog<String> {
    private TextField inputField;

    public CustomInputDialog(String title, String prompt, String defaultValue) {
        setTitle(title);
        setHeaderText(null);

        // Create content
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        Label promptLabel = new Label(prompt);
        inputField = new TextField(defaultValue);
        inputField.setPromptText("Enter value...");

        grid.add(promptLabel, 0, 0);
        grid.add(inputField, 1, 0);

        getDialogPane().setContent(grid);

        // Add buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        // Enable/disable OK button based on input
        Node okBtn = getDialogPane().lookupButton(okButton);
        okBtn.setDisable(true);

        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            okBtn.setDisable(newValue.trim().isEmpty());
        });

        // Focus on input field
        setOnShown(e -> inputField.requestFocus());

        // Result converter
        setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                return inputField.getText().trim();
            }
            return null;
        });
    }
}
