package org.example;

public class Timekeeper implements Runnable{
    private long start;
    private long limit;
    private long program;
    private boolean running = true;
    Timekeeper() {
        start = System.currentTimeMillis();
        limit = 10000;
    }

    @Override
    public void run() {
        long limit = 10000;
        while(running) {
            long current = System.currentTimeMillis();
            program = current - start;
            System.out.println("TIMEKEEPER: The program has been up for " + program);

            if(program >= limit) {
                running = false;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
