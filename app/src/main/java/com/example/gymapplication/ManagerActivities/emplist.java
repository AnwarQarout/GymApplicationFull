package com.example.gymapplication.ManagerActivities;

import java.util.ArrayList;

public class emplist {
    static ArrayList<employee> employees = new ArrayList<>() ;

    public emplist() {
        employees.add(new employee(1,"raed","raedS","8",100000,1,1.0)) ;
        employees.add(new employee(2,"yassen","yassenW","8",100000,1,1.0)) ;
        employees.add(new employee(3,"anwar","anwarQ","8",100000,1,1.0)) ;
        employees.add(new employee(4,"habbeb","habbebS","8",100000,1,1.0)) ;
        employees.add(new employee(5,"f5f5","FFFFF","8",100000,1,1.0)) ;

    }
}
