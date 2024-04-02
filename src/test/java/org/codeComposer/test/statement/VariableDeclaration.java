package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VariableDeclaration {

    @Test
    public void testVariableDeclaration() {
        String input = """
            int a, b, c;
            bool d;
            float e;
            string chachar;
        """;
        assertTrue(Util.check(input));
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
