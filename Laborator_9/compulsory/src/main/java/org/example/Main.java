package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseOperations.testJPA();


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        DatabaseOperations.closeEntityManager();
        DatabaseOperations.closeEntityManagerFactory();

    }
}