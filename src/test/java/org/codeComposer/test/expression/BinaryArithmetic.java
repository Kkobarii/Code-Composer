package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryArithmetic {

    @Test
    public void testAddition() {
        String input = """
            2 + 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testSubtraction() {
        String input = """
            2 - 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testMultiplication() {
        String input = """
            2 * 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testDivision() {
        String input = """
            2 / 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testInt() {
        String input = """
            int a;
            int b;
            a + b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testFloat() {
        String input = """
            float a;
            float b;
            a + b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testRecast() {
        String input = """
            int a;
            float b;
            a + b;
        """;
        assertTrue(Util.check(input));
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