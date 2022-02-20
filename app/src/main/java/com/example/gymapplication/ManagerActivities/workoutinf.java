package com.example.gymapplication.ManagerActivities;

public class workoutinf {

    private int id ;
    private int employee_id;
    private String name ;
    private String steps;
    private String video ;

    public workoutinf(int id, int employee_id, String name, String steps, String video) {
        this.id = id;
        this.employee_id = employee_id;
        this.name = name;
        this.steps = steps;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
