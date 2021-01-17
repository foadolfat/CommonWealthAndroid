package com.example.commonwealth;

public class CWProject {

    static String projectName;
    static String name;
    static String location;
    static int numOfHelpers;
    static int numOfHelpersAvailable;
    private static CWProject instance = null;
    private CWProject(){

    }

    public static CWProject getInstance(){
        if (instance == null) {
            instance = new CWProject();
        }
        return instance;
    }
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

}
