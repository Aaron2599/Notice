package net.aaron2599.Features.Command;

import net.aaron2599.Features.Command.cmds.Bind;

import java.util.ArrayList;

public class Commands {

    private final ArrayList<Command> commands = new ArrayList<>();

    public Commands() {
        commands.add(new Bind());
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public Command getCommandByName(String name) {
        for(Command command : commands) {
            if(command.getName().equalsIgnoreCase(name)) return command;
        }
        return null;
    }

}
