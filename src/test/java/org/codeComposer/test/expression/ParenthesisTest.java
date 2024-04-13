package org.codeComposer.test.expression;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesisTest {

    @Test
    public void testParenthesis() {
        String input = """
            (true);
        """;
        String output = """
            push B true
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testParenthesisInt() {
        String input = """
            int a;
            (a);
        """;
        String output = """
            push I 0
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testParenthesisFloat() {
        String input = """
            float a;
            (a);
        """;
        String output = """
            push F 0.0
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testParenthesisString() {
        String input = """
            string a;
            (a);
        """;
        String output = """
            push S ""
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testParenthesisBool() {
        String input = """
            bool a;
            (a);
        """;
        String output = """
            push B false
            save a
            load a
            pop
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testParenthesisOpertion() {
        String input = """
            (true && false);
        """;
        String output = """
            push B true
            push B false
            and
            pop
        """;
        assertTrue(Util.compile(input, output));
    }
}
