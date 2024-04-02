package org.codeComposer.parser.error;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.parser.error.model.Error;
import org.codeComposer.parser.error.model.TypeError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ErrorHandler {

    private static ErrorHandler instance;
    private final List<Error> errors = new ArrayList<>();

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public static void addError(Error error) {
        getInstance().errors.add(error);
    }

    public static boolean hasErrors() {
        return !getInstance().errors.isEmpty();
    }

    public static void clearErrors() {
        getInstance().errors.clear();
    }

    public static void logErrors() {
        for (Error error : getInstance().errors) {
            Arrays.stream(error.getMessage().split("\n")).forEach(log::error);
        }
    }
}
