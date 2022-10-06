package net.aaron2599.Features.Module;

import net.aaron2599.Features.Setting.Setting;
import net.aaron2599.Features.Setting.types.BindSetting;
import net.aaron2599.Notice;
import net.aaron2599.Utils.Globals;

import java.util.ArrayList;

public class Module implements Globals {

    private boolean active;
    private boolean visible = true;

    private boolean hold;
    private final String name;
    private final String description;
    private final Category category;

    protected ArrayList<Setting<?>> settings = new ArrayList<>();

    protected enum Category {
        Client,
        Combat,
        Misc,
        Movement,
        Player,
        Render
    }

    public BindSetting bind;

    public Module(String name, String description, Category category, int bind, boolean hold){
        this.name = name;
        this.description = description;
        this.category = category;
        this.bind = new BindSetting(bind);
        this.hold = hold;

        settings.add(this.bind);
    }

    public void onActivate() {}

    public void onDeactivate() {}

    public void toggle(){
        setActive(!active);
    }

    public void setActive(boolean state){
        if(active != state){
            active = state;
            if(state){
                Notice.EventBus.subscribe(this);
                onActivate();
            } else {
                Notice.EventBus.unsubscribe(this);
                onDeactivate();
            }
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public ArrayList<Setting<?>> getSettings() {
        return settings;
    }

    public Setting<?> getSettingByName(String name) {
        for(Setting<?> setting : settings){
            if(setting.getName().equalsIgnoreCase(name)) return setting;
        }
        return null;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public boolean Hold() {
        return hold;
    }

}
