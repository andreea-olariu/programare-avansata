package org.example;

import java.util.List;
import java.util.Random;

public class Robot {
    private String name;
    private boolean running;

    public Robot(String name) {
        this.name = name;
        this.running = true;
    }

    public void run(ExplorationGraph graph) {
        while (running) {
            boolean resPrim = graph.MST();
            if(!resPrim) {
                pause();
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pause() {
        this.running = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}