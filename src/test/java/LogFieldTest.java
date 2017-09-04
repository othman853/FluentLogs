import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogFieldTest {

    @Test
    public void should_be_a_string_with_correct_format() {
       assertThat(new LogField("action", () -> "blue").toString(), is("action=\"blue\""));
    }
}
