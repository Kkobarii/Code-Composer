package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TernaryTest {

    @Test
    public void testTernary() {
        String input = """
            int a;
            int b;
            int c;
            a = 1;
            b = 2;
            c = (a > b ? a : b);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testTernaryWithoutParentheses() {
        String input = """
            int a;
            int b;
            int c;
            a = 1;
            b = 2;
            c = a > b ? a : b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testTernaryIntFloat() {
        String input = """
            int a;
            float b;
            float c;
            a = 1;
            b = 2.0;
            c = (a > b ? a : b);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testTernaryWrongCondition() {
        String input = """
            string a;
            float b;
            int c;
            a = "ahoj";
            b = 2.0;
            c = (a ? a : b);
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testTernaryWrongAssignment() {
        String input = """
            int a;
            int b;
            string c;
            a = 1;
            b = 2;
            c = (a > b ? a :b);
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testTernaryWrongType() {
        String input = """
            int a;
            string b;
            int c;
            a = 1;
            b = "ahoj";
            c = (true ? a : b);
        """;
        assertFalse(Util.check(input));
    }
}
