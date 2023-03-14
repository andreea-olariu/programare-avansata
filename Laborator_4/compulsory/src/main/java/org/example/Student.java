package org.example;

public class Student implements Comparable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
