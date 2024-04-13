package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RelationalOperatorsTest {

    @Test
    public void testGreater() {
        String input = """
            1 > 2;
        """;
        String output = """
            push I 1
            push I 2
            gt
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testGreaterEqual() {
        String input = """
            1 >= 2;
        """;
        String output = """
            push I 1
            push I 2
            ge
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testLess() {
        String input = """
            1 < 2;
        """;
        String output = """
            push I 1
            push I 2
            lt
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testLessEqual() {
        String input = """
            1 <= 2;
        """;
        String output = """
            push I 1
            push I 2
            le
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testInt() {
        String input = """
            int a;
            int b;
            a > b;
        """;
        String output = """
            push I 0
            save a
            push I 0
            save b
            load a
            load b
            gt
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testFloat() {
        String input = """
            float a;
            float b;
            a > b;
        """;
        String output = """
            push F 0.0
            save a
            push F 0.0
            save b
            load a
            load b
            gt
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testString() {
        String input = """
            string a;
            string b;
            a > b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testBool() {
        String input = """
            bool a;
            bool b;
            a > b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testRecast() {
        String input = """
            float a;
            int b;
            a > b;
        """;
        String output = """
            push F 0.0
            save a
            push I 0
            save b
            load a
            load b
            itof
            gt
            pop
        """;
        assertTrue(Util.compile(input, output));
    }
}
