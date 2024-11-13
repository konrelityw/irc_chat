package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IRCConnection {
    private static final Logger logger = Logger.getLogger(IRCConnection.class.getName());
    private Socket socket;
    private PrintWriter writer;
    private String currentChannel;

    public void connectToServer(String server, int port) {
        try {
            socket = new Socket(server, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to " + server + " on port " + port);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to connect to " + server + " on port " + port, e);
        }
    }

    public void joinChannel(String channel) {
        if (isConnected()) {
            sendCommand("JOIN " + channel);
            currentChannel = channel;
            System.out.println("Joined channel: " + channel);
        } else {
            System.err.println("Not connected to any server.");
        }
    }

    public void sendMessage(String message) {
        if (isConnected() && currentChannel != null) {
            sendCommand("PRIVMSG " + currentChannel + " :" + message);
            System.out.println("Sent message to " + currentChannel + ": " + message);
        } else {
            System.err.println("No channel joined or not connected to any server.");
        }
    }

    public void sendMetadata(String metadata) {
        if (isConnected()) {
            sendCommand("METADATA " + metadata);
            System.out.println("Metadata: " + metadata);
        } else {
            System.err.println("Not connected to any server.");
        }
    }

    private void sendCommand(String command) {
        if (isConnected()) {
            writer.println(command);
            System.out.println("Sent command: " + command);
        } else {
            System.err.println("Not connected to any server.");
        }
    }

    private boolean isConnected() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }
}
