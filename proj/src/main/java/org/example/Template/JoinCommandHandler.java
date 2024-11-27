package org.example.Template;

import org.example.AbstractFactory.JoinCommand;

import java.util.logging.Logger;

public class JoinCommandHandler extends IRCCommandHandler {
    private static final Logger logger = Logger.getLogger(JoinCommandHandler.class.getName());
    private String channel;

    @Override
    protected void parseCommand(String command) {
        channel = command.split(" ")[1];
    }

    @Override
    protected void executeCommand() {
        JoinCommand joinCommand = new JoinCommand(channel, "Joining channel " + channel);
        joinCommand.comply();
    }
    @Override
    protected void logCommand(String command) {
        logger.info("Command executed: " + command);
    }
}
