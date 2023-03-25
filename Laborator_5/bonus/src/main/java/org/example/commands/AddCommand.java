package org.example.commands;

import org.example.exceptions.NullDocsListException;
import org.example.models.Catalog;
import org.example.models.Document;

public class AddCommand extends Command {
    AddCommand() {
        super(2);
    }
    @Override
    public String getHelp() {
        return "Adds a new document to the catalog.\n";
    }

    public static void action(Catalog catalog, Document document) throws NullDocsListException {
        if(catalog.getDocuments() == null)
            throw new NullDocsListException();
        catalog.getDocuments().add(document);
    }
}
