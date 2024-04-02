package org.codeComposer.parser;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TypeErrorHandler {

    private static TypeErrorHandler instance;
    private final List<TypeError> errors = new ArrayList<>();

    public static TypeErrorHandler getInstance() {
        if (instance == null) {
            instance = new TypeErrorHandler();
        }
        return instance;
    }

    public static void addError(String message, String line, int linePosition, int charPositionInLine) {
        getInstance().errors.add(new TypeError(message, line, linePosition, charPositionInLine));
    }

    public static boolean hasErrors() {
        return !getInstance().errors.isEmpty();
    }

    public static void clearErrors() {
        getInstance().errors.clear();
    }

    public static void logErrors() {
        for (TypeError error : getInstance().errors) {
            Arrays.stream(error.getMessage().split("\n")).forEach(log::error);
        }
    }
}
