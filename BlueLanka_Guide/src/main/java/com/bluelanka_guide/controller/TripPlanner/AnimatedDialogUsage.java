package com.bluelanka_guide.controller.TripPlanner;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.util.Duration;
import javafx.scene.transform.Scale;

// 5. Usage Examples
public class AnimatedDialogUsage {

    public void showFadeScaleDialog() {
        FadeScaleDialog dialog = new FadeScaleDialog(
                "Modern Dialog",
                "This dialog has a beautiful fade and scale animation!"
        );
        dialog.showAndWait();
    }

    public void showSlideNotification(String cost) {
        SlideNotificationDialog dialog = new SlideNotificationDialog(
                "Estimate cost of your selected trip plan" + cost,
                SlideNotificationDialog.NotificationType.SUCCESS
        );
        dialog.show(); // Non-blocking, auto-closes
    }

    public void showBounceDialog() {
        BounceDialog dialog = new BounceDialog(
                "Confirm Action",
                "Are you sure you want to proceed with this action?"
        );
        dialog.showAndWait().ifPresent(result -> {
            System.out.println("User selected: " + result);
        });
    }

    public void showPulseLoading(String cost) {
        PulseLoadingDialog dialog = new PulseLoadingDialog("Processing your request... \n Estimate trip plan is : " + cost);
        dialog.show();

        // Simulate work and close after 3 seconds
        Timeline closeTimer = new Timeline(new KeyFrame(Duration.seconds(30), e -> dialog.close()));
        closeTimer.play();



    }
}
