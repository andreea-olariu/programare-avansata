package org.example;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        DatabaseOperations.testJPA();


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        DatabaseOperations.closeEntityManager();
        DatabaseOperations.closeEntityManagerFactory();

    }
}