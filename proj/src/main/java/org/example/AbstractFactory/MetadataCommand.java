package org.example.AbstractFactory;

import org.example.IRCConnection;
import org.example.Singleton.IRCClient;

public class MetadataCommand implements Command {
    private String metadata;

    public MetadataCommand(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public void comply() {
        IRCClient client = IRCClient.getSpecimen();
        IRCConnection connection = client.getConnection();
        connection.sendMetadata(metadata);
        System.out.println("Sent metadata: " + metadata);
    }
}
