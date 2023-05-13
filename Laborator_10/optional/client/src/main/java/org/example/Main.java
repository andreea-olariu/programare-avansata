package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            GameClient.start();
        } catch (IOException e) {
            System.out.println("An error occurred while starting the client. Error is: " + e.getMessage());
        }
    }
}