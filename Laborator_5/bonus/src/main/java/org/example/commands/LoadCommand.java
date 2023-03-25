package org.example.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exceptions.LoadCatalogException;
import org.example.models.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {
    LoadCommand() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "Loads a catalog from a JSON file to a Catalog object";
    }

    public static Catalog action(String path) throws LoadCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Catalog catalog = mapper.readValue(new File(path), Catalog.class);
            return catalog;
        } catch (IOException e) {
            throw new LoadCatalogException();
        }
    }

}
