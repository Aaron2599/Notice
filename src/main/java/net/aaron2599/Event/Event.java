package net.aaron2599.Event;

public class Event {

    private boolean isCanceled;

    public Event(){
        isCanceled = false;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public boolean isCanceled(){
        return isCanceled;
    }

}
