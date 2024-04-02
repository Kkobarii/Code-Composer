package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentTest {

    @Test
    public void testAssignInt() {
        String input = """
            int a;
            a = 5;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testAssignFloat() {
        String input = """
            float a;
            a = 5.0;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testAssignString() {
        String input = """
            string a;
            a = "hello";
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testAssignBool() {
        String input = """
            bool a;
            a = true;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testAssignMixed() {
        String input = """
            int a;
            a = 0.9;
        """;
        assertFalse(Util.check(input));
    }
}
