package com.bluelanka_guide.models;

import com.bluelanka_guide.views.ViewFactoryMain;
import com.bluelanka_guide.views.ViewFactoryTravelTools;

public class Model {
    private final ViewFactoryMain viewFactoryMain;
    private final ViewFactoryTravelTools viewFactoryTravelTools;
    private static Model model;

    private Model(){
        this.viewFactoryMain = new ViewFactoryMain();
        this.viewFactoryTravelTools = new ViewFactoryTravelTools();
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
}
