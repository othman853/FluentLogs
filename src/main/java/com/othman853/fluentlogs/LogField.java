import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class LogField {

    private final String name;
    private final Supplier<String> value;

    String formatted(FieldFormatter formatter) {
        return formatter.format(name, value.get());
    }

    @FunctionalInterface
    interface FieldFormatter {
        FieldFormatter DEFAULT_FIELD_FORMAT = (name, value) -> String.format("%s=\"%s\"", name, value);

        String format(String name, String value);
    }
}
