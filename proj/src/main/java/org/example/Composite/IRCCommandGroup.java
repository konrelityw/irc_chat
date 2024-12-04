package org.example.Composite;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IRCCommandGroup implements IRCComponent {
    private final List<IRCComponent> components = new ArrayList<>();
    public IRCCommandGroup(String name) {components.add(new IRCCommand(name));}
    @Override
    public void execute() {
        for (IRCComponent component : components) {
            component.execute();
        }
    }
    @Override
    public void addComponent(IRCComponent component) {
        if (!Objects.isNull(component)) {
            components.add(component);
        }
    }
    @Override
    public void removeComponent(IRCComponent component) {
        components.remove(component);
    }
    @Override
    public IRCComponent getChild(int index) {
        if (index < 0 || index >= components.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return components.get(index);
    }
}
