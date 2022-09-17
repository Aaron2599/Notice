import net.aaron2599.Event.Events.EventTick;
import net.aaron2599.EventBus.NodusEvent;
import net.aaron2599.Nodus;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventsBusTest {

    private boolean posted;

    @Test
    @Order(1)
    public void subscribe(){
        assertEquals(1, Nodus.EventBus.subscribe(this));
        assertEquals(0, Nodus.EventBus.subscribe(this));
        Nodus.EventBus.unsubscribe(this);
    }

    @Test
    @Order(2)
    public void unsubscribe(){
        Nodus.EventBus.subscribe(this);
        assertEquals(1, Nodus.EventBus.unsubscribe(this));
        assertEquals(0, Nodus.EventBus.unsubscribe(this));
    }

    @Test
    @Order(3)
    @Tag("slow")
    public void post() {
        EventTick event = new EventTick();
        Nodus.EventBus.subscribe(this);
        Nodus.EventBus.post(event);
        assertTrue(posted);
        Nodus.EventBus.unsubscribe(this);
    }

    @NodusEvent
    public void onTick(EventTick event) {
        posted = true;
    }

}
