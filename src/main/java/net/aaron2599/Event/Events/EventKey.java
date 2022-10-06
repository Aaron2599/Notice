package net.aaron2599.Event.Events;

import net.aaron2599.Event.Event;

public class EventKey extends Event {

    int key;
    int action;

    public EventKey(int key, int action) {
        this.key = key;
        this.action = action;
    }

    public int getKey() {
        return key;
    }

    public int getAction() {
        return action;
    }
}
