package org.example.Composite;

import java.util.logging.Logger;

public class IRCCommand implements IRCComponent {
    private static final Logger logger = Logger.getLogger(IRCCommand.class.getName());
    private final String command;

    public IRCCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        logger.info("Executing command: " + command);
    }
}
