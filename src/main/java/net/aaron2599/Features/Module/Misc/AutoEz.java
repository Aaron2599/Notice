package net.aaron2599.Features.Module.Misc;

import net.aaron2599.Event.Events.EventTick;
import net.aaron2599.EventBus.NoticeEvent;
import net.aaron2599.Features.Module.Module;
import net.aaron2599.Features.Setting.types.SliderSetting;
import org.lwjgl.glfw.GLFW;

public class AutoEz extends Module {

    SliderSetting messageDelay = new SliderSetting("Delay", 0, 10, 0);

    public AutoEz() {
        super("AutoEz", "ez", Category.Misc, GLFW.GLFW_KEY_UNKNOWN, false);
        settings.add(messageDelay);
    }

    @NoticeEvent
    public void onTick(EventTick event) {

    }



}
