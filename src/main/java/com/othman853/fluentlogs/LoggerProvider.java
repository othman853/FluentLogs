package com.othman853.fluentlogs;

public interface LoggerProvider {
    LogEvent info();
    LogEvent debug();
    LogEvent warning();
    LogEvent error();
}
