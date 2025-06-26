package com.bluelanka_guide.controller.TripPlanner;

public class UserTripPlan {
    public String geographic_region = "";
    public String experience_type = "";
    public String trip_duration = "";

    public String sea_activities = "";
    public String budget_range = "";
    public String title = "";
    public String description = "";
    public String[] itinerary = {};
    public String estimated_cost = "";
    public String accommodation = "";
    public String transportation = "";
    public String meals = "";
    public String[] activities = {};



    public UserTripPlan() {};

    public UserTripPlan(String geographic_region, String experience_type, String trip_duration, String sea_activities, String budget_range, String title, String description, String[] itinerary, String estimated_cost, String accommodation, String transportation, String meals, String[] activities) {
        this.geographic_region = geographic_region;
        this.experience_type = experience_type;
        this.trip_duration = trip_duration;
        this.sea_activities = sea_activities;
        this.budget_range = transportation;
        this.title = title;
        this.description = description;
        this.itinerary = itinerary;
        this.estimated_cost = estimated_cost;
        this.accommodation = accommodation;
        this.transportation = transportation;
        this.meals = meals;
        this.activities = activities;
    }

    // Getter and Setter
    public void setGeographic_regionGeographic_region(String geographic_region){
        this.geographic_region = geographic_region;
    }
    public void setExperience_typeExperience_type(String experience_type){
        this.experience_type = experience_type;
    }
    public void setTrip_durationTripDuration(String trip_duration){
        this.trip_duration = trip_duration;
    }
    public void setTrip_duration(String trip_duration){
        this.trip_duration = trip_duration;
    }

    public String getGeographic_region(){
        return geographic_region;
    }
    public String getExperience_type(){
        return experience_type;
    }
    public String getTrip_duration(){
        return trip_duration;
    }
    public String getActivities(){
        return sea_activities;
    }
}
