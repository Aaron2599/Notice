package net.aaron2599.Features.Setting.types;

import net.aaron2599.Features.Setting.Setting;

public class BooleanSetting extends Setting<Boolean> {

    public BooleanSetting(String name, boolean value){
        super("Boolean",name, value);
    }

    public BooleanSetting(Setting<?> parent, String name, boolean value){
        super(parent, "Boolean", name, value);
    }

}
