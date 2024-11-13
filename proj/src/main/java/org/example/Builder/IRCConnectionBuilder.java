package org.example.Builder;

import org.example.IRCConnection;

public class IRCConnectionBuilder {
    private String server;
    private int port;

    public IRCConnectionBuilder setServer(String server) {
        this.server = server;
        return this;
    }

    public IRCConnectionBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    public IRCConnection build() {
        IRCConnection connection = new IRCConnection();
        connection.connectToServer(server, port);
        return connection;
    }
}
