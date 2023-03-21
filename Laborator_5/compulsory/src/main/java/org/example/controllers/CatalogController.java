package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Catalog;
import org.example.exceptions.LoadCatalogException;
import org.example.exceptions.SaveCatalogException;

import java.io.File;
import java.io.IOException;

public class CatalogController {

    // static method because it doesn't manipulate data specific to the instance
    public static void save(Catalog catalog) throws SaveCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("result.json"), catalog);
        } catch (IOException e) {
            throw new SaveCatalogException();
        }
    }

    public static Catalog load(String path) throws LoadCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Catalog catalog = mapper.readValue(new File(path), Catalog.class);
            return catalog;
        } catch (IOException e) {
            throw new LoadCatalogException();
        }
    }
}
