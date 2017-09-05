package com.othman853.fluentlogs;

import static com.othman853.fluentlogs.WrappedLogger.DEFAULT;
import static java.lang.System.err;
import static java.lang.System.out;

public class SystemLoggerProvider implements LoggerProvider {

    @Override
    public LogEvent info() {
        return DEFAULT.info(out::println);
    }

    @Override
    public LogEvent debug() {
        return DEFAULT.debug(out::println);
    }

    @Override
    public LogEvent warning() {
        return DEFAULT.warning(out::println);
    }

    @Override
    public LogEvent error() {
        return DEFAULT.error(err::println);
    }
}
