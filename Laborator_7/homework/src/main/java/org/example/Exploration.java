package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  Exploration is a supervisor
 * */
public class Exploration {
    private final SharedMemory memory = new SharedMemory();
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();

    public Exploration() {
    }

    public boolean allDone() {
        for (Thread t : threads) {
            if (t.getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public void getCommand() {
        synchronized (threads) {
            /* Waiting for a command from user */
            while (!allDone()) {
                System.out.println("Getting the command...");
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();
                if (command.equals("P")) {
                    /* Pause all threads */
                    for (int i = 0; i < threads.size(); i++) {
                        /* Stop the robot */
                        robots.get(i).pause();
                        synchronized (threads.get(i)) {
                            if (threads.get(i).getState() != Thread.State.TERMINATED) {
                                System.out.println("Pausing the thread " + threads.get(i).getName());
                                try {
                                    threads.get(i).wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                } else if (command.equals("R")) {
                    /* Resume all threads */
                    System.out.println("Resuming all threads...");
                    synchronized (threads) {
                        threads.notifyAll();
                    }
                }
            }
        }
    }

    public void start() {
        Thread timeThread = new Thread(new Timekeeper());
        timeThread.setDaemon(true);
        timeThread.start();

        for (Robot robot : robots) {
            Thread t = new Thread(() -> robot.run(map, memory));
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