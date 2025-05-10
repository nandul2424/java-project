package com.bluelanka_guide.controller.TripPlanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TripPlannerController {

    public RadioButton radWeekend;
    public RadioButton radWeek;
    public RadioButton radExtended;
    public CheckBox checkMediterranean;
    public CheckBox checkCaribbean;
    public CheckBox checkNordicFjords;
    public CheckBox checkSouthPacific;
    public CheckBox checkOther;
    public TextField txtOtherRegion;

    public Button btnGeneratePlan;
    public Button btnNext;
    public Button btnPrevious;
    public Button btnSave;

    public CheckBox chkChildFriendly;
    public CheckBox chkAccessibility;


    public Spinner spinnerChildren;
    public Spinner spinnerAdults;

    public ComboBox comboCurrency;
    public TextField txtBudgetAmount;


    public RadioButton radUltraLuxury;
    public RadioButton radLuxury;
    public RadioButton radModerate;
    public RadioButton radBudget;

    public Slider sliderIntensity;

    public CheckBox checkCultural;
    public CheckBox checkWildlife;
    public CheckBox checkSailing;
    public CheckBox checkWaterSports;

    public CheckBox checkRelaxation;
    public CheckBox checkSnorkeling;
    public CheckBox checkDiving;
    public CheckBox checkFishing;

    public Slider sliderDays;
    
    public Slider sliderPopularity;
    
    public RadioButton radCoastal;
    public RadioButton radOpenSea;
    public RadioButton radIslandHopping;
    public RadioButton radMixed;


    @FXML
    private RadioButton radDayTrip;

    @FXML
    public void handleOtherRegion() {

    }

    @FXML
    private void handleSaveProgress() {

    }

    @FXML
    private void handlePrevious() {

    }

    @FXML
    private void handleNext() {

    }

    @FXML
    private void handleGeneratePlan() {

    }
}
