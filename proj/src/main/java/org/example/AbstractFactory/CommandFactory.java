package org.example.AbstractFactory;

public interface CommandFactory {
    Command createCommand(String type, String... args);
}
