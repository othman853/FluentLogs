package com.othman853.fluentlogs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;

class LogMessage {

    private List<LogField> fields = new ArrayList<>();
    private final String delimiter;
    private final LogField.FieldFormatter formatter;

    private LogMessage() {
       delimiter = ", ";
       formatter = LogField.FieldFormatter.DEFAULT_FIELD_FORMAT;
    }

    void add(String name, String value) {
        fields.add(new LogField(name, () -> value));
    }

    void add(String name, Supplier<String> value) {
        fields.add(new LogField(name, value));
    }

    String build() {
        return fields
                .stream()
                .map(field -> field.formatted(formatter))
                .collect(joining(delimiter));
    }

    static LogMessage defaultMessage() {
        return new LogMessage();
    }
}
