package net.aaron2599.Event.Events;

import net.aaron2599.Event.Event;

public class EventScroll extends Event {

    private final double vertical;

    public EventScroll(double vertical){
        this.vertical = vertical;
    }

    public double getVertical() {
        return vertical;
    }
}
