import net.aaron2599.Event.Events.EventTick;
import net.aaron2599.EventBus.NoticeEvent;
import net.aaron2599.Notice;
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
        assertEquals(1, Notice.EventBus.subscribe(this));
        assertEquals(0, Notice.EventBus.subscribe(this));
        Notice.EventBus.unsubscribe(this);
    }

    @Test
    @Order(2)
    public void unsubscribe(){
        Notice.EventBus.subscribe(this);
        assertEquals(1, Notice.EventBus.unsubscribe(this));
        assertEquals(0, Notice.EventBus.unsubscribe(this));
    }

    @Test
    @Order(3)
    @Tag("slow")
    public void post() {
        EventTick event = new EventTick();
        Notice.EventBus.subscribe(this);
        Notice.EventBus.post(event);
        assertTrue(posted);
        Notice.EventBus.unsubscribe(this);
    }

    @NoticeEvent
    public void onTick(EventTick event) {
        posted = true;
    }

}
