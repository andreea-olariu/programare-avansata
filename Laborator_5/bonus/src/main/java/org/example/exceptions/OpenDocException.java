package org.example.exceptions;

public class OpenDocException extends Exception {
    public OpenDocException() {
        super("Unable to open the document.");
    }
}
