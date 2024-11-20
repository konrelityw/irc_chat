package org.example.AbstractFactory;

import org.example.IRCConnection;
import org.example.Singleton.IRCClient;

public class JoinCommand implements Command {
    private String channel;
    private String message;

    public JoinCommand(String channel, String message) {
        this.channel = channel;
        this.message = message;
    }

    @Override
    public void comply() {
        IRCClient client = IRCClient.getSpecimen();
        IRCConnection connection = client.getConnection();
        connection.joinChannel(channel);
        connection.sendMessage(message);
    }
}
