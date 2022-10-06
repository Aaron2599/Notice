package net.aaron2599.Features.Module.Render;

import net.aaron2599.Event.Events.EventScroll;
import net.aaron2599.EventBus.NoticeEvent;
import net.aaron2599.Features.Module.Module;
import net.aaron2599.Mixin.GameRendererAccessor;
import org.lwjgl.glfw.GLFW;

public class Zoom extends Module {

    private double fov;
    private double sensitivity;
    private double zoom = .23;
    private double scrollSensitivity;
    private boolean viewBobbing;

    public Zoom() {
        super("Zoom", "Optifine but better", Category.Render, GLFW.GLFW_KEY_C, true);
    }

    @NoticeEvent
    public void onScroll(EventScroll event) {
        zoom += event.getVertical() * zoom /-9;
        mc.options.mouseSensitivity = sensitivity * 2 * zoom / .23;
        if(zoom < 0.0015) zoom = 0.0015;
        if (zoom >= .31) zoom = .30;
        if (zoom < .015) mc.options.bobView = false;
        if (zoom > .015 && viewBobbing) mc.options.bobView = true;
        mc.options.fov = fov * zoom;
    }

    @Override
    public void onActivate() {
        zoom = .23;
        fov = mc.options.fov;
        viewBobbing = mc.options.bobView;
        sensitivity = mc.options.mouseSensitivity;
        scrollSensitivity = mc.options.mouseWheelSensitivity;
        mc.options.fov = fov * zoom;
        mc.options.mouseWheelSensitivity = 0;
        mc.options.smoothCameraEnabled = true;
        mc.worldRenderer.scheduleTerrainUpdate();
        ((GameRendererAccessor) mc.gameRenderer).setRenderHand(false);
        mc.gameRenderer.reset();
    }

    @Override
    public void onDeactivate() {
        mc.options.fov = fov;
        mc.options.bobView = viewBobbing;
        mc.options.mouseSensitivity = sensitivity;
        mc.options.mouseWheelSensitivity = scrollSensitivity;
        mc.options.smoothCameraEnabled = false;
        mc.worldRenderer.scheduleTerrainUpdate();
        ((GameRendererAccessor) mc.gameRenderer).setRenderHand(true);
        mc.gameRenderer.reset();
    }

}
