package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable {
    private String name;

    // the preferences each student has
    private List<Project> preferences;

    public Student(String name) {
        this.name = name;
        preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Project> preferences) {
        this.preferences = preferences;
    }

    public int getPreferencesSize() {
        return this.preferences.size();
    }

    public void addPreference(Project proj) {
        preferences.add(proj);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Student) o).name);
    }

    @Override
    public String toString() {
        return "Student " +
                "named " + name + ".";
    }
}
