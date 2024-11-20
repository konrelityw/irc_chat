package org.example.AbstractFactory;

public class IRCCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String type, String... args) {
        return switch (type) {
            case "join" -> new JoinCommand(args[0], args[1]);
            case "metadata" -> new MetadataCommand(args[0]);
            default -> throw new IllegalArgumentException("Unknown command type");
        };
    }
}
