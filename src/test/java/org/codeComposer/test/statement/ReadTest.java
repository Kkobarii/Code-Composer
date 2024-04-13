package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadTest {

    @Test
    public void testReadInt() {
        String input = """
            int a;
            read a;
        """;
        String output = """
            push I 0
            save a
            read I
            save a
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testReadFloat() {
        String input = """
            float a;
            read a;
        """;
        String output = """
            push F 0.0
            save a
            read F
            save a
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testReadString() {
        String input = """
            string a;
            read a;
        """;
        String output = """
            push S ""
            save a
            read S
            save a
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testReadBool() {
        String input = """
            bool a;
            read a;
        """;
        String output = """
            push B false
            save a
            read B
            save a
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testReadMultipleVariables() {
        String input = """
            int a;
            float b;
            string c;
            bool d;
            read a, b, c, d;
        """;
        String output = """
            push I 0
            save a
            push F 0.0
            save b
            push S ""
            save c
            push B false
            save d
            read I
            save a
            read F
            save b
            read S
            save c
            read B
            save d
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testReadNoDeclaration() {
        String input = """
            read a;
        """;
        assertFalse(Util.check(input));
    }
}
