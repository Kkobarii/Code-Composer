package org.codeComposer;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.parser.Code;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Util {

    private static void printInput(String input) {
        System.out.println("");
        log.info("Testing input:");
        for (String line : input.split("\n")) {
            log.trace(line);
        }
    }

    public static boolean parse(String input) {
        printInput(input);
        Code code = new Code();
        return code.parse(input);
    }

    public static boolean check(String input) {
        printInput(input);
        Code code = new Code();
        return code.parse(input) && code.check();
    }

    public static boolean compile(String input, String output) {
        printInput(input);
        Code code = new Code();
        boolean result = code.parse(input) && code.check() && code.compile();
        assertEquals(output.replace("    ", ""), code.getInstructionsString());
        return result;
    }

    public static boolean process(String input, String output) {
        printInput(input);
        Code code = new Code();
        boolean result = code.parse(input) && code.check() && code.compile() && code.process();
        assertEquals(output.replace("    ", "").trim(), code.getOutputString().trim());
        return result;
    }

    public static boolean process(String input, String output, Scanner scanner) {
        printInput(input);
        Code code = new Code();
        boolean result = code.parse(input) && code.check() && code.compile() && code.process(scanner);
        assertEquals(output.replace("    ", "").trim(), code.getOutputString().trim());
        return result;
    }

    public static boolean everything(String input) {
        printInput(input);
        Code code = new Code();
        return code.parse(input) && code.check(); // todo more
    }
}
