package org.example;

import org.example.commands.*;
import org.example.exceptions.*;
import org.example.models.Catalog;
import org.example.models.Document;
import org.example.models.GraphColoring;
import org.example.models.InstanceGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Catalog catalog;
        try {
            InstanceGenerator.generateJSON(20);
            catalog = LoadCommand.action("./result.json");
            GraphColoring.greedyColoring(catalog);
            System.out.println("============================");

            GraphColoring.graphColoringJGraphT(catalog);

        } catch (LoadCatalogException | SaveCatalogException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}