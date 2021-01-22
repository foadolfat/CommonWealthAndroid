package com.example.commonwealth;

public class CWProject {

    private String projectName;
    private String name;
    private String location;
    private double lat;
    private double lng;
    private int numOfHelpers;
    private int numOfHelpersAvailable;


    public CWProject(){}



    public void setName(String name){
        this.name = name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setNumOfHelpers(int numOFHelper){
        this.numOfHelpers = numOFHelper;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    public void addToHelpers(){
        this.numOfHelpersAvailable = numOfHelpersAvailable + 1;
    }
    public void setLatLng(String latLng){
        latLng = latLng.replaceAll("lat/lng: ","");
        latLng = latLng.replaceAll("[()]", "");
        String[] latLngSplit = latLng.split(",");
        this.lat = Double.parseDouble(latLngSplit[0]);
        this.lng = Double.parseDouble(latLngSplit[1]);

    }

    public String getProjectName(){
        return projectName;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumOfHelpers() {
        return numOfHelpers;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
