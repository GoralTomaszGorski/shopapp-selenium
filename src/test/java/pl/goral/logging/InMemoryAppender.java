package pl.goral.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAppender extends AppenderBase<ILoggingEvent> {

    private final List<String> logMessages = new ArrayList<>();
    private static final int STACK_TRACE_LINE_LIMIT = 20;

    private final StringBuilder logBuilder = new StringBuilder();

    @Override
    protected void append(ILoggingEvent eventObject) {
        // Format however you’d like; you can extract the message,
        // timestamp, level, etc. and customize the line.
        logBuilder
                .append(eventObject.getLevel())
                .append(" - ")
                .append(eventObject.getLoggerName())
                .append(": ")
                .append(eventObject.getFormattedMessage())
                .append(System.lineSeparator());
    }

    public String getAllLogs() {
        return logBuilder.toString();
    }



}

