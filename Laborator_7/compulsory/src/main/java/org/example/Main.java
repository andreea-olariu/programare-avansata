package org.example;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        explore.start();

        for(var th : explore.getThreads()) {
            th.join();
        }
        System.out.println(explore);
    }
}