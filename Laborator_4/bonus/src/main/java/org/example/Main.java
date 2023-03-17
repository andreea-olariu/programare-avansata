package org.example;

public class Main {
    public static void main(String[] args) {
        // the parameter of the constructor = the number of instances for projects & students
        StudentAllocationProblem problem = new StudentAllocationProblem(20);
        problem.printStudentsWithLessPreferences();

        problem.generateRandomInstancesProjects();
        problem.generateRandomInstancesStudents();
        problem.setRandomPreferences();

        long start1 = System.currentTimeMillis();
        problem.buildMatchingWithGraphsJGT();
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        problem.buildMatchingGreedy();
        long end2 = System.currentTimeMillis();

        System.out.println("\n!!!! The algorithm with graph took " + (end1 - start1) + " milliseconds !!!!");
        System.out.println("!!!! The greedy algorithm took " + (end2 - start2) + " milliseconds !!!!\n");

        System.out.println("=============================\nMinimum Vertex cover: ");
        for(var node : problem.minimumCardinalityVertexCover()) {
            System.out.println(node);
        }
        System.out.println("\n===============================\nMaximum Independent Set:");
        for(var node : problem.maximumCardinalityIndependentSet()) {
            System.out.println(node);
        }

    }
}