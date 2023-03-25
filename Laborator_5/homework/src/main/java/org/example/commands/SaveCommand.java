package org.example.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exceptions.SaveCatalogException;
import org.example.models.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    SaveCommand() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "Saves a Catalog object into a JSON file.\n";
    }

    public static void action(Catalog catalog) throws SaveCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("result.json"), catalog);
        } catch (IOException e) {
            throw new SaveCatalogException();
        }
    }
}
