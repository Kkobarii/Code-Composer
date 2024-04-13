package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicAndOrTest {

    @Test
    public void testLogicAnd() {
        String input = """
            true && false;
        """;
        String output = """
            push B true
            push B false
            and
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testLogicOr() {
        String input = """
            true || false;
        """;
        String output = """
            push B true
            push B false
            or
            pop
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push B false
            save a
            push B false
            save b
            load a
            load b
            and
            pop
        """;
        assertTrue(Util.compile(input, output));
    }
}
