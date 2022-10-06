package net.aaron2599.Features.Setting.types;

import net.aaron2599.Features.Setting.Setting;

public class SliderSetting extends Setting<Double> {

    private final double snap;
    private final double min;
    private final double max;

    public SliderSetting(Setting<?> parent, String name, double snap, double min, double max, double value) {
        super(parent, "Slider", name, value);
        this.snap = snap;
        this.min = min;
        this.max = max;
    }

    public SliderSetting(String name, double snap, double min, double max, double value) {
        super("Slider", name, value);
        this.snap = snap;
        this.min = min;
        this.max = max;
    }

    public SliderSetting(String name, double min, double max, double value) {
        super("Slider", name, value);
        this.snap = 1;
        this.min = min;
        this.max = max;
    }

    public double getSnap() {
        return snap;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}
