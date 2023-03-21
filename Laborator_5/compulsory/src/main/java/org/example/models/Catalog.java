package org.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documents;

    public Catalog() {
        this.documents = new ArrayList<>();
    }
    public Catalog(List<Document> documents) {
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    // internal operation
    public void addDocument(Document doc) {
        this.documents.add(doc);
    }

    // internal operation
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Catalogul " + name + " cuprinde documentele: \n");
        documents.stream().forEach(document -> result.append(document));
        return result.toString();
    }
}
