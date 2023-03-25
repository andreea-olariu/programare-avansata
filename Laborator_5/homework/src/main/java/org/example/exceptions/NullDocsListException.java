package org.example.exceptions;

public class NullDocsListException extends Exception {
    public NullDocsListException() {
        super("The list of documents is null!\n");
    }
}
