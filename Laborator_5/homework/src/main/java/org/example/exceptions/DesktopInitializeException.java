package org.example.exceptions;

public class DesktopInitializeException extends Exception {
    public DesktopInitializeException() {
        super("A problem occurred at initializing the desktop.\n");
    }
}
