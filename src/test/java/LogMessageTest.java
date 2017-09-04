import org.junit.Test;

import static java.lang.String.format;
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

    @Test
    public void should_format_its_fields_with_arrows() {

        LogMessage message = new LogMessage();

        message.add("banana", () -> "potassium");
        message.add("milk", "calcium");
        message.fieldFormat((name, value) -> format("%s -> %s", name, value));

        assertThat(message.build(), is("banana -> potassium, milk -> calcium"));
    }

    @Test
    public void should_join_by_semi_colon() {
        LogMessage message = new LogMessage();

        message.add("banana", () -> "potassium");
        message.add("milk", "calcium");
        message.joiningBy("; ");

        assertThat(message.build(), is("banana=\"potassium\"; milk=\"calcium\""));
    }

}
