import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogFieldTest {

    @Test
    public void should_be_a_string_with_correct_format() {
       assertThat(new LogField("action", () -> "blue").toString(), is("action=\"blue\""));
    }

    @Test
    public void should_apply_a_custom_format() {
        LogField field = new LogField("color", () -> "blue");

        String customFormatField = field.formatted((name, value) -> format("%s -> %s", name, value));

        assertThat(customFormatField, is("color -> blue"));
    }
}
