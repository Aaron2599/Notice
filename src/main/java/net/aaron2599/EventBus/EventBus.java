package net.aaron2599.EventBus;

import net.aaron2599.Event.Event;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {

    private final Map<Class<?>, List<Subscriber>> subscriberMap = new ConcurrentHashMap<>();

    public void post(Event event) {
        List<Subscriber> subscribers = subscriberMap.get(event.getClass());
        if(subscribers != null){
            for(Subscriber subscriber : subscribers){
                try {
                    subscriber.call(event);
                } catch (Throwable t) {
                    System.out.println("Exception Thrown Calling " + subscriber.getMethod().getName());
                }
            }
        }
    }

    public void subscribe(Object object) {
        for(Method method : object.getClass().getDeclaredMethods()){
            if(isValid(method)){
                subscriberMap.computeIfAbsent(method.getParameters()[0].getType(), event -> new CopyOnWriteArrayList<>()).add(new Subscriber(method));
            }
        }
    }

    public void unsubscribe(Object object) {
        subscriberMap.values().removeIf(v -> {
            return v.removeIf(s -> object.getClass().equals(s.getTarget()));
        });
    }

    private boolean isValid(Method method){
        return method.isAnnotationPresent(NodusEvent.class) && method.getParameterCount() == 1 && method.getReturnType() == void.class;
    }





}
