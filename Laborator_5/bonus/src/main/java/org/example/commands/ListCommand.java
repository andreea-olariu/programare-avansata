package org.example.commands;

import org.example.exceptions.NullCatalogException;
import org.example.models.Catalog;

public class ListCommand extends Command {

    ListCommand() {
        super(1);
    }
    @Override
    public String getHelp() {
        return "List all the elements from the catalog";
    }

    public static void action(Catalog catalog) throws NullCatalogException {
        if(catalog == null)
            throw new NullCatalogException();
        catalog.getDocuments().stream().forEach(System.out::print);
    }
}
