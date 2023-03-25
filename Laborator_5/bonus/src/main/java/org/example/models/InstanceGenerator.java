package org.example.models;


import com.github.javafaker.Faker;
import org.example.commands.SaveCommand;
import org.example.exceptions.SaveCatalogException;

import javax.print.Doc;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class InstanceGenerator {
    public static void generateJSON(int nrOfInstances) throws IOException, SaveCatalogException {
        Catalog catalog = new Catalog();
        Faker faker = new Faker();
        Random random = new Random();
        catalog.setName(faker.funnyName().name());
        String[] TAGS = {"author", "title", "year", "publishingDate"};
        for(int i = 0; i < nrOfInstances; i++) {
            String name = faker.funnyName().name();
            String docPath = "./documents/doc" + i + ".txt";
            Document document = new Document(docPath, i, name);

            for(int j = 0; j < random.nextInt(0, TAGS.length); j++) {
                int tag = random.nextInt(0, TAGS.length);
                document.addTag(TAGS[tag], faker.cat().name());
            }

            catalog.addDocument(document);
        }
        SaveCommand.action(catalog);
    }
}
