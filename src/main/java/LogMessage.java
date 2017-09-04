import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;

public class LogMessage {

    private List<LogField> fields = new ArrayList<>();

    private Optional<BiFunction<String, String, String>> fieldFormat = empty();

    private Collector<CharSequence, ?, String> fieldJoiner = joining(", ");

    public void add(String name, String value) {
       fields.add(new LogField(name, () -> value));
    }

    public void add(String name, Supplier<String> value) {
        fields.add(new LogField(name, value));
    }

    public void fieldFormat(BiFunction<String, String, String> fieldFormat) {
        this.fieldFormat = of(fieldFormat);
    }

    public void joiningBy(String delimiter) {
        this.fieldJoiner = joining(delimiter);
    }

    public String build() {
        return fields
                .stream()
                .map(field -> fieldFormat.isPresent() ? field.formatted(fieldFormat.get()) : field.toString())
                .collect(fieldJoiner);
    }
}
