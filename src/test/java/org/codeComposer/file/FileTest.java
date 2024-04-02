package org.codeComposer.file;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.codeComposer.Util;
import org.codeComposer.parser.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class FileTest {

    private String readFile(String path) {
        String input = null;
        try {
            input = CharStreams.fromFileName(path).toString();
        } catch (Exception e) {
            log.error("Error reading file: {}", e.getMessage());
        }
        return input;
    }

    @Test
    public void testFile1() {
        String input = readFile("src/main/antlr/project/input1.txt");
        assertTrue(Util.everything(input));
    }

    @Test
    public void testFile2() {
        String input = readFile("src/main/antlr/project/input2.txt");
        assertTrue(Util.everything(input));
    }

    @Test
    public void testFile3() {
        String input = readFile("src/main/antlr/project/input3.txt");
        assertTrue(Util.everything(input));
    }

    @Test
    public void testErrorFile() {
        String input = readFile("src/main/antlr/project/error.txt");
        assertFalse(Util.everything(input));
    }
}
