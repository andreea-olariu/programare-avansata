package org.example;

import org.example.commands.*;
import org.example.exceptions.*;
import org.example.models.Catalog;
import org.example.models.Document;

public class Main {
    public static void main(String[] args) {
        Catalog catalog;
        Document doc = new Document("./documents/doc3.txt", 3, "doc3");
        try {
            catalog = LoadCommand.action("./catalog_data.json");
            AddCommand.action(catalog, doc);
            ListCommand.action(catalog);
            SaveCommand.action(catalog);
            ViewCommand.action(catalog.getDocuments().get(0));
            ReportCommand.action(catalog);
        } catch (LoadCatalogException | OpenDocException | SaveCatalogException | NullCatalogException | DesktopInitializeException | NullDocsListException | GenerateHTMLReportException e) {
            System.out.println(e.getMessage());
        }
    }
}