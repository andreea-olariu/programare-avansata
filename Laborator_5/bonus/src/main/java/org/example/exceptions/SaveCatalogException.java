package org.example.exceptions;

import java.io.IOException;

public class SaveCatalogException extends Exception {
    public SaveCatalogException() {
        super("Error at saving of the catalog");
    }
}
