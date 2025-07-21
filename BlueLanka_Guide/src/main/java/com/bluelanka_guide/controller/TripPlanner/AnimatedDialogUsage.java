package com.bluelanka_guide.controller.TripPlanner;
import javafx.animation.*;
import javafx.util.Duration;



public class AnimatedDialogUsage {

    public void showFadeScaleDialog() {
        FadeScaleDialog dialog = new FadeScaleDialog(
                "Something went wrong",
                "According to the request data trip plan is not found !"
        );
        dialog.showAndWait();
    }

    public void showPulseLoading(String cost) {
        PulseLoadingDialog dialog = new PulseLoadingDialog("Processing your request... \n Estimate trip plan is : " + cost);
        dialog.show();

        // Simulate work and close after 3 seconds
        Timeline closeTimer = new Timeline(new KeyFrame(Duration.seconds(30), e -> dialog.close()));
        closeTimer.play();

    }
}
