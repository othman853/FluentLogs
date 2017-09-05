package component;

import com.othman853.fluentlogs.SystemLoggerProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SystemLoggerProviderTest {

    private SystemLoggerProvider provider;

    @Before
    public void setup() {
        provider = new SystemLoggerProvider();
    }

    @Test
    public void should_log_info_to_standard_output() {
        provider.info().action("banana").log();
        fail();
    }

    @Test
    public void should_log_debug_to_standard_output() {
        provider.debug().action("banana").log();
        fail();
    }

    @Test
    public void should_log_warning_to_standard_output() {
        provider.warning().action("banana").log();
        fail();
    }

    @Test
    public void should_log_error_to_standard_error() {
        provider.error().action("banana").log();
        fail();
    }
}
