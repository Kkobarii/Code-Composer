package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcatenationTest {

    @Test
    public void testConcatenation() {
        String input = """
            "string" . "string";
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testConcatenationInt() {
        String input = """
            1 . 2;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testConcatenationFloat() {
        String input = """
            1.0 . 2.0;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testConcatenationBool() {
        String input = """
            true . false;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testConcatenationString() {
        String input = """
            "string" . "string";
        """;
        assertTrue(Util.check(input));
    }
}
