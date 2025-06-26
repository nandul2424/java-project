package com.bluelanka_guide.controller.TripPlanner;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.util.Callback;

// 5. Usage Examples
public class DialogBoxes {

    public void showCustomMessage() {
        CustomMessageDialog dialog = new CustomMessageDialog(
                "Information",
                "This is a custom message dialog with enhanced styling."
        );

        dialog.showAndWait().ifPresent(result -> {
            if ("OK".equals(result)) {
                System.out.println("User clicked OK");
            }
        });
    }

    public void showInputDialog() {
        CustomInputDialog dialog = new CustomInputDialog(
                "Enter Name",
                "Please enter your name:",
                ""
        );

        dialog.showAndWait().ifPresent(name -> {
            System.out.println("User entered: " + name);
        });
    }

    public void showConfirmDialog() {
        CustomConfirmDialog dialog = new CustomConfirmDialog(
                "Delete File",
                "Are you sure you want to delete this file? This action cannot be undone.",
                "Delete",
                "Cancel"
        );

        dialog.showAndWait().ifPresent(confirmed -> {
            if (confirmed) {
                System.out.println("File deletion confirmed");
            }
        });
    }

    public void showProgressDialog() {
        CustomProgressDialog dialog = new CustomProgressDialog("Processing");

        // Show dialog non-blocking
        dialog.show();

        // Simulate progress updates
        // You would typically do this from a background thread
        // dialog.updateProgress(0.5, "50% complete");
        // dialog.close(); // Close when done
    }
}
