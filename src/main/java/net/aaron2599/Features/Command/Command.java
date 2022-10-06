package net.aaron2599.Features.Command;

public class Command {

    private final String name;
    private final String description;

    public void execute(String[] args) {}

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
