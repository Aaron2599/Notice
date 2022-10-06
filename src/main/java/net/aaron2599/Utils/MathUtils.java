package net.aaron2599.Utils;

public class MathUtils implements Globals {

    public static int clamp (int min, int max, int value) {
        if(value < min) return min;
        return Math.min(value, max);
    }

    public static double clamp (double min, double max, double value) {
        if(value < min) return min;
        return Math.min(value, max);
    }



}
