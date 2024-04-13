package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnaryMinusTest {

    @Test
    public void testUnaryMinusNoDeclaration() {
        String input = """
            -a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testUnaryMinusInt() {
        String input = """
            int a;
            -a;
        """;
        String output = """
            push I 0
            save a
            load a
            uminus
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testUnaryMinusFloat() {
        String input = """
            float a;
            -a;
        """;
        String output = """
            push F 0.0
            save a
            load a
            uminus
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testUnaryMinusString() {
        String input = """
            string a;
            -a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testUnaryMinusBool() {
        String input = """
            bool a;
            -a;
        """;
        assertFalse(Util.check(input));
    }
}
