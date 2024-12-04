package org.example.Composite;

public interface IRCComponent {
    void execute();

    default void addComponent(IRCComponent component) {
        throw new UnsupportedOperationException("addComponent not supported");
    }

    default void removeComponent(IRCComponent component) {
        throw new UnsupportedOperationException("removeComponent not supported");
    }

    default IRCComponent getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported");
    }
}
