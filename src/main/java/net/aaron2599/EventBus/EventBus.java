package net.aaron2599.EventBus;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EventBus {

    private final ConcurrentHashMap<Class<?>, List<Listener>> Listeners = new ConcurrentHashMap<>();

    public void Subscribe(Object object) {
        addListeners(object.getClass());
    }

    public void Unsubscribe(Object object){
        removeListeners(object.getClass());
    }

    public void addListeners(Class<?> klass){
        for(Method method : klass.getDeclaredMethods()){
            if(isValid(method)){

            }
        }
    }

    public void removeListeners(Class<?> klass){
        for(Method method : klass.getDeclaredMethods()){

        }
    }

    private boolean isValid(Method method){
        return method.isAnnotationPresent(NodusEvent.class) && method.getParameterCount() == 1 && method.getReturnType() == void.class;
    }





}
