package component;

import com.othman853.fluentlogs.SystemLoggerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SystemLoggerProviderTest {

    private final ByteArrayOutputStream standardOutput = new ByteArrayOutputStream();
    private final ByteArrayOutputStream standardErrorOutput = new ByteArrayOutputStream();

    private SystemLoggerProvider provider;

    @Before
    public void setup() {
        System.setOut(new PrintStream(standardOutput));
        System.setErr(new PrintStream(standardErrorOutput));

        provider = new SystemLoggerProvider();
    }

    @After
    public void cleanup() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_log_info_to_standard_output() {
        provider.info().action("banana").log();

        assertThat(standardOutput.toString(), is("action=\"banana\"\n"));
    }

    @Test
    public void should_log_debug_to_standard_output() {
        provider.debug().action("banana").log();

        assertThat(standardOutput.toString(), is("action=\"banana\"\n"));
    }

    @Test
    public void should_log_warning_to_standard_output() {
        provider.warning().action("banana").log();

        assertThat(standardOutput.toString(), is("action=\"banana\"\n"));
    }

    @Test
    public void should_log_error_to_standard_error() {
        provider.error().action("banana").log();

        assertThat(standardErrorOutput.toString(), is("action=\"banana\"\n"));
    }
}
