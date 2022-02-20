package com.example.gymapplication.ManagerActivities;

import java.util.ArrayList;

public class workoutlist {
    static ArrayList<workoutinf> workoutinf = new ArrayList<>() ;
public workoutlist(){
    workoutinf.add(new workoutinf(1,2," Run"," 10","video1"));
    workoutinf.add(new workoutinf(3,4," Walk"," 30","video2"));
    workoutinf.add(new workoutinf(5,6," Dumbels"," 15","video3"));
    workoutinf.add(new workoutinf(7,8," Tridmel"," 5","video4"));

}
}
