package org.codeComposer;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.parser.Code;

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

    public static boolean everything(String input) {
        printInput(input);
        Code code = new Code();
        return code.parse(input) && code.check(); // todo more
    }
}
