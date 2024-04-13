package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryArithmeticTest {

    @Test
    public void testAddition() {
        String input = """
            2 + 2;
        """;
        String output = """
            push I 2
            push I 2
            add
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testSubtraction() {
        String input = """
            2 - 2;
        """;
        String output = """
            push I 2
            push I 2
            sub
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testMultiplication() {
        String input = """
            2 * 2;
        """;
        String output = """
            push I 2
            push I 2
            mul
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testDivision() {
        String input = """
            2 / 2;
        """;
        String output = """
            push I 2
            push I 2
            div
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testInt() {
        String input = """
            int a;
            int b;
            a + b;
        """;
        String output = """
            push I 0
            save a
            push I 0
            save b
            load a
            load b
            add
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testFloat() {
        String input = """
            float a;
            float b;
            a + b;
        """;
        String output = """
            push F 0.0
            save a
            push F 0.0
            save b
            load a
            load b
            add
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testRecast() {
        String input = """
            int a;
            float b;
            a + b;
        """;
        String output = """
            push I 0
            save a
            push F 0.0
            save b
            load a
            itof
            load b
            add
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testRecastOtherWay() {
        String input = """
            float a;
            int b;
            a + b;
        """;
        String output = """
            push F 0.0
            save a
            push I 0
            save b
            load a
            load b
            itof
            add
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testString() {
        String input = """
            string a;
            string b;
            a + b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testBool() {
        String input = """
            bool a;
            bool b;
            a + b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testNotDeclared() {
        String input = """
            a + b;
        """;
        assertFalse(Util.check(input));
    }
}
