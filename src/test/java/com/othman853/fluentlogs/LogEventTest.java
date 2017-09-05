import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogEventTest {

    private LogEvent event;

    @Mock
    private Consumer<String> logger;

    @Before
    public void setup() {
       event = new LogEvent(new LogMessage(), logger);
    }

    @Test
    public void should_have_an_action() {
        event.action("banana").log();

        verify(logger).accept("action=\"banana\"");
    }

    @Test
    public void should_have_a_description() {
        event.description("banana").log();

        verify(logger).accept("description=\"banana\"");
    }
}
