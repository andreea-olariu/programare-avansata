package org.example.commands;

import org.example.exceptions.DesktopInitializeException;
import org.example.exceptions.OpenDocException;
import org.example.models.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.rmi.UnexpectedException;

public class ViewCommand extends Command {

    ViewCommand() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "Opens a document using the default OS app.\n";
    }

    public static void action(Document document) throws OpenDocException, DesktopInitializeException {
        try {
            if(Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(document.getPath()));
            }
        }
        catch (HeadlessException | UnexpectedException e) {
            throw new DesktopInitializeException();
        }
        catch (NullPointerException | IllegalArgumentException | UnsupportedOperationException | IOException | SecurityException e) {
            throw new OpenDocException();
        }
    }
}
