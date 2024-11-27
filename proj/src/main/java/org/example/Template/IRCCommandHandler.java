package org.example.Template;

public abstract class IRCCommandHandler {
    public final void handleCommand(String command) {
        parseCommand(command);
        executeCommand();
        logCommand(command);
    }

    protected abstract void parseCommand(String command);
    protected abstract void executeCommand();
    protected abstract void logCommand(String command);
}
