package org.example.exceptions;

public class NullCatalogException extends Exception {
    public NullCatalogException() {
        super("The Catalog object is null!\n");
    }
}
