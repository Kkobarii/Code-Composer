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
        String output = """
            push I 0
            save a
            push I 5
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testAssignFloat() {
        String input = """
            float a;
            a = 5.0;
        """;
        String output = """
            push F 0.0
            save a
            push F 5.0
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testAssignString() {
        String input = """
            string a;
            a = "hello";
        """;
        String output = """
            push S ""
            save a
            push S "hello"
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testAssignBool() {
        String input = """
            bool a;
            a = true;
        """;
        String output = """
            push B false
            save a
            push B true
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testRecast() {
        String input = """
            float a;
            int b;
            a = b;
        """;
        String output = """
            push F 0.0
            save a
            push I 0
            save b
            load b
            itof
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
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
