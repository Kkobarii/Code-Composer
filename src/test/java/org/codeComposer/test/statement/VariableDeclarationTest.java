package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VariableDeclarationTest {

    @Test
    public void testVariableDeclaration() {
        String input = """
            int a, b, c;
            bool d;
            float e;
            string chachar;
        """;
        String output = """
            push I 0
            save a
            push I 0
            save b
            push I 0
            save c
            push B false
            save d
            push F 0.0
            save e
            push S ""
            save chachar
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testDoubleDeclaration() {
        String input = """
            int a, b;
            int a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testDoubleDeclarationDifferentTypes() {
        String input = """
            int a, b, c;
            bool a;
        """;
        assertFalse(Util.check(input));
    }
}
