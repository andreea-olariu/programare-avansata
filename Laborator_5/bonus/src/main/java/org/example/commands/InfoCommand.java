package org.example.commands;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.DefaultParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.example.exceptions.CatalogInfoException;
import org.example.models.Catalog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.example.models.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class InfoCommand extends Command {
    InfoCommand() {
        super(1);
    }

    @Override
    public String getHelp() {
        return null;
    }

    public static void action(Catalog catalog) throws CatalogInfoException, FileNotFoundException {
        Parser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        ContentHandler handler = new BodyContentHandler();

        for(Document document : catalog.getDocuments()) {
            InputStream stream = new FileInputStream(document.getPath());
            try {
                parser.parse(stream, handler, metadata, context);
            }
            catch (IOException | SAXException | TikaException e) {
                throw new CatalogInfoException();
            }

            System.out.println("For the document " + document.getName() + ":");
            for(var name : metadata.names()) {
                System.out.println(name + ": " + metadata.get(name));
                document.addTag(name, metadata.get(name));
            }
            System.out.println();
        }
    }
}
