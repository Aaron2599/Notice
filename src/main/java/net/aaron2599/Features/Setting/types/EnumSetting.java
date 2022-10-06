package net.aaron2599.Features.Setting.types;

import net.aaron2599.Features.Setting.Setting;

import java.util.List;

public class EnumSetting extends Setting<String> {

    private final List<String> modes;
    
    public EnumSetting(String name, String value, List<String> modes) {
        super("Enum", name, value);
        this.modes = modes;
    }

    public EnumSetting(Setting<?> parent, String name, String value, List<String> modes) {
        super(parent, "Enum", name, value);
        this.modes = modes;
    }

    public List<String> getModes() {
        return modes;
    }
}
