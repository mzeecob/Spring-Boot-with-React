package com.example.springbootwithreact;

import java.util.Objects;

public class Course {
    private long id;
    private String username;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId() &&
                getUsername().equals(course.getUsername()) &&
                getDescription().equals(course.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getDescription());
    }

    public Course(long id, String username, String description) {
        this.id = id;
        this.username = username;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
