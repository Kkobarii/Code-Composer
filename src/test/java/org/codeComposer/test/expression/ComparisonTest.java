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
        assertTrue(Util.check(input));
    }

    @Test
    public void testNotEqual() {
        String input = """
            2 != 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testInt() {
        String input = """
            int a;
            int b;
            a == b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testFloat() {
        String input = """
            float a;
            float b;
            a == b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testString() {
        String input = """
            string a;
            string b;
            a == b;
        """;
        assertTrue(Util.check(input));
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