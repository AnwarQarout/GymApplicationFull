package com.example.gymapplication.EmployeeActivities.Model;

public class Workout {
    int id;
    int employee_id;
    String workout_name;
    String steps;
    String video;

    public Workout(int id, int employee_id, String workout_name, String image, String video) {
        this.id = id;
        this.employee_id = employee_id;
        this.workout_name = workout_name;
        this.steps = image;
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

    public String getWorkout_name() {
        return workout_name;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
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
