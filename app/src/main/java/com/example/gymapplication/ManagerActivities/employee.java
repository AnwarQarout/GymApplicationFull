package com.example.gymapplication.ManagerActivities;



public class employee {
    private int id ;
    private String name;
    private String username ;
    private String password ;
    private int phone;
    private int mangerid;
    private double salary;





    public employee(int id, String name, String username, String password, int phone, int mangerid, double salary) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mangerid = mangerid;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMangerid() {
        return mangerid;
    }

    public void setMangerid(int mangerid) {
        this.mangerid = mangerid;
    }

    public double getSalry() {
        return salary;
    }

    public void setSalry(double salry) {
        this.salary = salry;
    }


}
