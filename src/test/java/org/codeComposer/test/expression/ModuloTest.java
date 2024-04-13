package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModuloTest {

    @Test
    public void testModulo() {
        String input = """
            3 % 2;
        """;
        String output = """
            push I 3
            push I 2
            mod
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testModuloInt() {
        String input = """
            int a;
            int b;
            a % b;
        """;
        String output = """
            push I 0
            save a
            push I 0
            save b
            load a
            load b
            mod
            pop
        """;
        assertTrue(Util.compile(input, output));
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
