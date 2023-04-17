package org.example;

import java.util.List;
import java.util.Random;

public class Robot {
    private String name;
    private boolean running;
    private int nrOfTokens;

    public Robot(String name) {
        this.name = name;
        this.running = true;
        this.nrOfTokens = 0;
    }

    public void run(ExplorationMap map, SharedMemory memory) {
        while (running) {
            /* Choose to visit the first cell that is unvisited */
            List<Token> tokens = memory.extractTokens(map.getDim());
            this.nrOfTokens += map.getDim();
            if(!map.visit(this, tokens)) {
                running = false;
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (map.isFull()) {
                running = false;
                break;
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

    public int getNrOfTokens() {
        return nrOfTokens;
    }

    public void setNrOfTokens(int nrOfTokens) {
        this.nrOfTokens = nrOfTokens;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}