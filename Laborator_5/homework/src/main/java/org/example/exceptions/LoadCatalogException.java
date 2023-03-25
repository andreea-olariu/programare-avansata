package org.example.exceptions;

import java.io.IOException;

public class LoadCatalogException extends Exception {
    public LoadCatalogException() {
        super("Error at loading of the catalog");
    }
}
