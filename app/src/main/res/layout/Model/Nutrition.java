package com.example.gymmyproject.Model;

public class Nutrition {
    private int id;
    private int employee_id;
    private String name ;
    private String type ;
    private String membership ;
    private String image ;

    public Nutrition() {
    }

    public Nutrition(int id, int employee_id, String name, String type, String membership, String image) {
        this.id = id;
        this.employee_id = employee_id;
        this.name = name;
        this.type = type;
        this.membership = membership;
        this.image = image;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
