package org.example.ClientServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 8080;
    private static final Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("The IRC server is running on the port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    new ClientHandler(clientSocket).start();
                } catch (IOException e) {
                    System.out.println("Error connecting the client: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                out.println("Enter your nickname:");
                username = in.readLine();
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }
                broadcastMessage("User " + username + " joined the chat");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("/quit")) {
                        break;
                    }
                    broadcastMessage(username + ": " + message);
                }

                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
                socket.close();
                broadcastMessage("User " + username + " left the channel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
