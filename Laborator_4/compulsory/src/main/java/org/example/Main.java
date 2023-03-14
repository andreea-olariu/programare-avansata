package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Stream for creating the students
        Student[] students = IntStream.range(0, 10)
                .mapToObj(i -> new Student("S" + (i + 5) % 3))
                .toArray(Student[]::new);

        // Stream for creating the projects
        Project[] projects = IntStream.range(0, 10)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<>();
        for(Student stud : students) {
            listOfStudents.add(stud);
        }

        Collections.sort(listOfStudents);
        System.out.println("Students are...: ");
        for(Student stud : listOfStudents) {
            System.out.println("\t" + stud);
        }

        Set<Project> setOfProjects = new TreeSet<>();
        for(Project proj : projects) {
            setOfProjects.add(proj);
        }

        // A TreeSet is already sorted according to the compareTo() method of the elements it contains
        System.out.println("===========================\nProjects are...: ");
        for(Project proj : setOfProjects) {
            System.out.println("\t" + proj);
        }
    }
}