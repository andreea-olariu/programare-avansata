package org.example;

import java.util.Random;

public class Robot implements Runnable {
    Exploration explore;
    private String name;
    private boolean running;

    public Robot(String name, Exploration explore) {
        this.name = name;
        running = true;
        this.explore = explore;
    }

    public void run() {
        while (running) {
            Random random = new Random();
            int row = random.nextInt(0, explore.getMap().getDim());
            int col = random.nextInt(0, explore.getMap().getDim());
            explore.getMap().visit(row, col, this, explore);

            if(explore.getMap().isFull()) {
                running = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}