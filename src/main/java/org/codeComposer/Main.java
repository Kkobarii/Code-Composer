package org.codeComposer;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.parser.Code;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String path = "src/main/antlr/project/input1.txt";

        Code code = new Code();
        if (code.parse(path)) {
            log.info("Code parsed successfully!");
        } else {
            log.error("Code parsing failed!");
        }

        code.log();
    }
}