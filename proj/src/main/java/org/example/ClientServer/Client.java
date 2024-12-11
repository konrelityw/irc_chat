package org.example.ClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            Thread receiverThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Error connecting to the server");
                }
            });
            receiverThread.start();

            System.out.println("The connection to the IRC server is established");
            System.out.print("Enter your nickname: ");
            String username = scanner.nextLine();
            out.println(username);

            while (true) {
                String userInput = scanner.nextLine();
                if ("/quit".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
            }
        } catch (IOException e) {
            System.out.println("Error connecting to the server: " + e.getMessage());
        }
    }
}
