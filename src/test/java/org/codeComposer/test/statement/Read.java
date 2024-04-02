package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Read {

    @Test
    public void testReadInt() {
        String input = """
            int a;
            read a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testReadFloat() {
        String input = """
            float a;
            read a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testReadString() {
        String input = """
            string a;
            read a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testReadBool() {
        String input = """
            bool a;
            read a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testReadMultipleVariables() {
        String input = """
            int a;
            float b;
            string c;
            bool d;
            read a, b, c, d;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testReadNoDeclaration() {
        String input = """
            read a;
        """;
        assertFalse(Util.check(input));
    }
}
