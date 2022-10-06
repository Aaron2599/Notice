package net.aaron2599.Features.Setting.types;

import net.aaron2599.Features.Setting.Setting;

import java.awt.*;

public class ColorSetting extends Setting<Color> {

    private boolean rainbow;

    public ColorSetting(String name, String value) {
        super("Color", name, Color.getColor(value));
    }

    public ColorSetting(String name, Color value) {
        super("Color", name, value);
    }

    public ColorSetting(Setting<?> parent, String name, Color value) {
        super(parent, "Color", name, value);
    }

    public String toHex(Color color) {
        return "#" + Integer.toHexString(color.getRGB());
    }

    @Override
    public Color getValue(){
        if (rainbow) {
            this.value = Color.getHSBColor(System.currentTimeMillis(),1,1);
        }
        return value;
    }

    public void setRainbow(boolean rainbow) {
        this.rainbow = rainbow;
    }

    public boolean isRainbow(){
        return rainbow;
    }

}
