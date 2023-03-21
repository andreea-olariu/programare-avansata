package org.example;

import org.example.controllers.CatalogController;
import org.example.models.Catalog;
import org.example.exceptions.SaveCatalogException;
import org.example.exceptions.LoadCatalogException;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        try {
            catalog = CatalogController.load("./catalog_data.json");
            System.out.println(catalog);

            CatalogController.save(catalog);
        }
        catch (SaveCatalogException | LoadCatalogException e) {
            System.out.println(e.getMessage());
        }

    }
}