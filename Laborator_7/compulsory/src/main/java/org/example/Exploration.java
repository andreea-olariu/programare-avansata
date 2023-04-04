package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory memory = new SharedMemory();
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();

    private List<Thread> threads = new ArrayList<>();

    public Exploration() {
    }

    public void start(){
        for (Robot robot : robots) {
            Thread t = new Thread(robot);
            threads.add(t);
            t.start();
        }
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Exploration{" + "map=" + map + '}';
    }
}