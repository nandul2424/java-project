package com.bluelanka_guide.models;

import com.bluelanka_guide.controller.DestinationsPage.DestinationManager;
import com.bluelanka_guide.services.CurrentLocation;
import com.bluelanka_guide.views.ViewFactoryMain;
import com.bluelanka_guide.views.ViewFactoryTravelTools;

public class Model {
    private final ViewFactoryMain viewFactoryMain;
    private final ViewFactoryTravelTools viewFactoryTravelTools;
    private final DestinationManager destinationManager;
    private final CurrentLocation currentLocation;
    private static Model model;

    private Model(){
        this.viewFactoryMain = new ViewFactoryMain();
        this.viewFactoryTravelTools = new ViewFactoryTravelTools();
        this.destinationManager = new DestinationManager();
        this.currentLocation = new CurrentLocation();
    }

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactoryTravelTools getViewFactoryTravelTools(){
        return viewFactoryTravelTools;
    }

    public ViewFactoryMain getViewFactoryMain() {
        return viewFactoryMain;
    }

    public DestinationManager getDestinationManager(){
        return destinationManager;
    }

    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }
}
