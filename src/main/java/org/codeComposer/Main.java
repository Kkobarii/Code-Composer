package org.codeComposer;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.codeComposer.parser.Code;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String path = "src/main/antlr/project/input1.txt";

        log.info("Reading input file: {}", path);

        String input = null;
        try {
            input = CharStreams.fromFileName(path).toString();
        } catch (Exception e) {
            log.error("Error reading file: {}", e.getMessage());
        }

        Code code = new Code();

        if (code.parse(input)) {
            log.info("Code parsed successfully!");
        } else {
            log.error("Code parsing failed!");
        }

        if (code.check()) {
            log.info("Code checked successfully!");
        } else {
            log.error("Code checking failed!");
        }

//        code.log();
    }
}