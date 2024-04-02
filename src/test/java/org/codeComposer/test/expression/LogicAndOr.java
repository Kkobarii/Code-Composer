package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicAndOr {

    @Test
    public void testLogicAnd() {
        String input = """
            true && false;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testLogicOr() {
        String input = """
            true || false;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testLogicAndInt() {
        String input = """
            int a;
            int b;
            a && b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicAndFloat() {
        String input = """
            float a;
            float b;
            a && b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicAndString() {
        String input = """
            string a;
            string b;
            a && b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicAndBool() {
        String input = """
            bool a;
            bool b;
            a && b;
        """;
        assertTrue(Util.check(input));
    }
}
