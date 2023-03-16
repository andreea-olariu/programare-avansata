package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StudentAllocationProblem problem = new StudentAllocationProblem(20);
        problem.printStudentsWithLessPreferences();

        problem.generateRandomInstancesProjects();
        problem.generateRandomInstancesStudents();
        problem.setRandomPreferences();
        problem.buildMatching();
        problem.printMatching();
    }
}