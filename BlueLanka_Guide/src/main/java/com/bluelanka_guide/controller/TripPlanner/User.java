package com.bluelanka_guide.controller.TripPlanner;

public class User {
    private String name;
    private String email;
    private String id;
    private String phone;

    // Constructors
    public User() {}

    public User(String name, String email, String id, String phone) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.phone = phone;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', id='" + id + "', phone='" + phone + "'}";
    }
}