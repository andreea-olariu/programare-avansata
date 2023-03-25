package org.example.commands;

public abstract class Command {
    private int numberOfArgs;

    Command(int nrOfArgs) {
        this.numberOfArgs = nrOfArgs;
    }
    public abstract String getHelp();
}
