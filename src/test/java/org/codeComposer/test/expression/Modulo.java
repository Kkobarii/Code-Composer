package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Modulo {

    @Test
    public void testModulo() {
        String input = """
            3 % 2;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testModuloInt() {
        String input = """
            int a;
            int b;
            a % b;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testModuloFloat() {
        String input = """
            float a;
            float b;
            a % b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testModuloString() {
        String input = """
            string a;
            string b;
            a % b;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testModuloBool() {
        String input = """
            bool a;
            bool b;
            a % b;
        """;
        assertFalse(Util.check(input));
    }
}