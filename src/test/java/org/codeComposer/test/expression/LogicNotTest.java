package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicNotTest {

    @Test
    public void testLogicNot() {
        String input = """
            !false;
        """;
        String output = """
            push B false
            not
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testLogicNotInt() {
        String input = """
            int a;
            !a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicNotFloat() {
        String input = """
            float a;
            !a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicNotString() {
        String input = """
            string a;
            !a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testLogicNotBool() {
        String input = """
            bool a;
            !a;
        """;
        String output = """
            push B false
            save a
            load a
            not
            pop
        """;
        assertTrue(Util.compile(input, output));
    }
}
