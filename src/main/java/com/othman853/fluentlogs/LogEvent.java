package com.othman853.fluentlogs;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class LogEvent {

    private final LogMessage message;

    private final Consumer<String> logger;

    public void log() {
        logger.accept(message.build());
    }

    public LogEvent action(String value) {
        message.add("action", () -> value);
        return this;
    }

    public LogEvent description(String value) {
        message.add("description", value);
        return this;
    }

    public LogEvent field(String name, String value) {
       return this;
    }

    public LogEvent field(String name, Supplier<String> value) {
        return this;
    }

    public LogEvent field(Loggable loggable) {
        return this;
    }

    public <T> LogEvent optional(String name, Optional<T> optional) {
       return this;
    }

    public <T> LogEvent ifPresent(Optional<T> optional, BiConsumer<LogEvent, T> whenPresent) {
       return this;
    }

    public <T> LogEvent nullable(String name, T nullable) {
        return this;
    }

    public <T> LogEvent ifNotNull(T nullable, BiConsumer<LogEvent, T> whenNotNull) {
        return this;
    }
}
