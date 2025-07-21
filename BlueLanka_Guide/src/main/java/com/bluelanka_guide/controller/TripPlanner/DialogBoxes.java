package com.bluelanka_guide.controller.TripPlanner;


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
}
