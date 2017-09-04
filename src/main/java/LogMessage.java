import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class LogMessage {

    private List<LogField> fields = new ArrayList<>();
    private final String delimiter;
    private final LogField.FieldFormatter formatter;

    public LogMessage() {
       delimiter = ", ";
       formatter = LogField.FieldFormatter.DEFAULT_FIELD_FORMAT;
    }

    public void add(String name, String value) {
        fields.add(new LogField(name, () -> value));
    }

    public void add(String name, Supplier<String> value) {
        fields.add(new LogField(name, value));
    }

    public String build() {
        return fields
                .stream()
                .map(field -> field.formatted(formatter))
                .collect(joining(delimiter));
    }

}
