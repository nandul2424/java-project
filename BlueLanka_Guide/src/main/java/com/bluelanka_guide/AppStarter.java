package com.bluelanka_guide;

import com.bluelanka_guide.models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactoryMain().showLoginWindow();
    }
}
