import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogMessageTest {

    @Test
    public void should_separate_its_string_fields_by_comma() {

        LogMessage message = new LogMessage();

        message.add("banana", "potassium");
        message.add("milk", "calcium");

        assertThat(message.build(), is("banana=\"potassium\", milk=\"calcium\""));
    }

    @Test
    public void should_separate_its_supplier_fields_by_comma() {

        LogMessage message = new LogMessage();

        message.add("banana", () -> "potassium");
        message.add("milk", "calcium");

        assertThat(message.build(), is("banana=\"potassium\", milk=\"calcium\""));
    }
}
