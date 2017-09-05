import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

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
}
