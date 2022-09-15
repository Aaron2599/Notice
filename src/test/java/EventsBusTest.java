import net.aaron2599.EventBus.NodusEvent;
import org.junit.jupiter.api.RepeatedTest;

public class EventsBusTest {

    @RepeatedTest(10000)
    public void Benchmark(){

    }

    @NodusEvent
    public void onTick(){

    }

}
