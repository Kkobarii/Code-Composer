package org.codeComposer;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.parser.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ParsingTest {

    @Test
    public void testFile1() {
        String path = "src/main/antlr/project/input1.txt";

        Code code = new Code();
        assertTrue(code.parse(path));
    }

    @Test
    public void testFile2() {
        String path = "src/main/antlr/project/input2.txt";

        Code code = new Code();
        assertTrue(code.parse(path));
    }

    @Test
    public void testFile3() {
        String path = "src/main/antlr/project/input3.txt";

        Code code = new Code();
        assertTrue(code.parse(path));
    }

    @Test
    public void testErrorFile() {
        String path = "src/main/antlr/project/error.txt";

        Code code = new Code();
        assertTrue(code.parse(path));
    }
}
