package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparisonTest {

    @Test
    public void testEqual() {
        String input = """
            2 == 2;
        """;
        String output = """
            push I 2
            push I 2
            eq
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testNotEqual() {
        String input = """
            2 != 2;
        """;
        String output = """
            push I 2
            push I 2
            eq
            not
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testInt() {
        String input = """
            int a;
            int b;
            a == b;
        """;
        String output = """
            push I 0
            save a
            push I 0
            save b
            load a
            load b
            eq
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testFloat() {
        String input = """
            float a;
            float b;
            a == b;
        """;
        String output = """
            push F 0.0
            save a
            push F 0.0
            save b
            load a
            load b
            eq
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testString() {
        String input = """
            string a;
            string b;
            a == b;
        """;
        String output = """
            push S ""
            save a
            push S ""
            save b
            load a
            load b
            eq
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testBool() {
        String input = """
            bool a;
            bool b;
            a == b;
        """;
        assertFalse(Util.check(input));
    }
}
