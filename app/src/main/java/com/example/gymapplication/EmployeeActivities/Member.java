package com.example.gymapplication.EmployeeActivities;

public class Member {
    private int id;
    private int employee_id;
    private String user_name;
    private String password;
    private String name;
    private int phone;
    private double height;
    private double weight;


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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Member(int id, int employee_id, String user_name, String password, String name, int phone, double height, double weight) {
        this.id = id;
        this.employee_id = employee_id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.height = height;
        this.weight = weight;


    }
}
