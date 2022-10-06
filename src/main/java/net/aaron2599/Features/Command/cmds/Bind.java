package net.aaron2599.Features.Command.cmds;

import net.aaron2599.Features.Command.Command;
import net.aaron2599.Features.Module.Module;
import net.aaron2599.Notice;

public class Bind extends Command {

    public Bind() {
        super("bind", "changes the bind of a module");
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2) return;
        Module module = Notice.Modules.getModuleByName(args[1]);
        if(module == null) return;
        module.bind.setBinding(true);
    }
}
