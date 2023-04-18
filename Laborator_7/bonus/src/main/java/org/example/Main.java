package org.example;


import com.github.javafaker.Faker;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        Faker faker = new Faker();

        Exploration explore = new Exploration();
        for(int i = 0; i < 10; i++) {
            explore.addRobot(new Robot(faker.superhero().name()));
        }

        explore.start();
//        explore.getCommand();

        /* Wait for all threads to finish */
        for (Thread t : explore.getThreads()) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("A problem occurred during joining threads.\n");
            }
        }

        System.out.println("MST order: " + explore.getGraph().getVisitedMSTNodes());
    }
}