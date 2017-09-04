import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import static java.lang.String.format;

@RequiredArgsConstructor
public class LogField {

    private final String name;
    private final Supplier<String> value;

    @Override
    public String toString() {
        return format("%s=\"%s\"", name, value.get());
    }

    String formatted(BiFunction<String, String, String> formatter) {
        return formatter.apply(name, value.get());
    }
}
