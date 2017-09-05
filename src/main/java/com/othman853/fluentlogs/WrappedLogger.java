package com.othman853.fluentlogs;

import java.util.function.Consumer;

import static com.othman853.fluentlogs.LogMessage.defaultMessage;

public interface WrappedLogger {

    WrappedLogger DEFAULT = new WrappedLogger() {};

    default LogEvent info(Consumer<String> log) {
        return new LogEvent(defaultMessage(), log);
    }

    default LogEvent debug(Consumer<String> log) {
        return new LogEvent(defaultMessage(), log);
    }

    default LogEvent warning(Consumer<String> log) {
        return new LogEvent(defaultMessage(), log);
    }

    default LogEvent error(Consumer<String> log) {
        return new LogEvent(defaultMessage(), log);
    }
}
