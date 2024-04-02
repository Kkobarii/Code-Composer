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
        assertTrue(Util.check(input));
    }

    @Test
    public void testParenthesisInt() {
        String input = """
            int a;
            (a);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testParenthesisFloat() {
        String input = """
            float a;
            (a);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testParenthesisString() {
        String input = """
            string a;
            (a);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testParenthesisBool() {
        String input = """
            bool a;
            (a);
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testParenthesisOpertion() {
        String input = """
            (true && false);
        """;
        assertTrue(Util.check(input));
    }
}
