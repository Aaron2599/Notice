package net.aaron2599.Features.Module;

import net.aaron2599.Features.Module.Misc.AutoEz;
import net.aaron2599.Features.Module.Render.Zoom;
import net.aaron2599.Features.Setting.Setting;

import java.util.ArrayList;

public class Modules {

    private final ArrayList<Module> modules = new ArrayList<>();

    public Modules(){
        modules.add(new AutoEz());
        modules.add(new Zoom());
    }

    public void handleKeyPress(int key) {
        for(Module module : modules) {
            if(module.bind.getValue() == key){
                if(module.Hold()){
                    module.setActive(true);
                } else {
                    module.toggle();
                }
            }
        }
    }

    public void handleKeyRelease(int key) {
        for(Module module : modules) {
            if(module.Hold() && module.bind.getValue() == key){
                module.setActive(false);
            }
        }
    }

    public Module getModuleByName(String name){
        for(Module module : modules){
            if(module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
}

