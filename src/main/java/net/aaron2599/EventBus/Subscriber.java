package net.aaron2599.EventBus;

import net.aaron2599.Event.Event;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class Subscriber {

    private final Method method;
    private final Class<?> target;
    private final Consumer<Object> consumer;

    public Subscriber(Object object, Method method) {
        try {
            Class<? extends Event> event = (Class<? extends Event>) method.getParameterTypes()[0];

            MethodHandles.Lookup lookup = MethodHandles.lookup();
            CallSite callSite = LambdaMetafactory.metafactory(lookup,
                    "accept",
                    MethodType.methodType(Consumer.class, method.getDeclaringClass()),
                    MethodType.methodType(void.class, Object.class),
                    lookup.unreflect(method),
                    MethodType.methodType(void.class, event));

            this.method = method;
            target = object.getClass();
            consumer = (Consumer<Object>) callSite.getTarget().invokeWithArguments(object);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public void call(Event event){
        consumer.accept(event);
    }

    public Class<?> getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }
}
