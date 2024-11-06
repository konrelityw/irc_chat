package org.example.Singleton;

import org.example.IRCConnection;

public class IRCClient {
    private static IRCClient specimen;
    private final IRCConnection connection;

    private IRCClient() {
        connection = new IRCConnection();
    }

    public static synchronized IRCClient getSpecimen() {
        if (specimen == null) {
            specimen = new IRCClient();
        }
        return specimen;
    }

    public IRCConnection getConnection() {
        return connection;
    }
}
