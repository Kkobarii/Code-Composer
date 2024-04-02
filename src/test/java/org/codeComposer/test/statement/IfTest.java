package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IfTest {

    @Test
    public void testIf() {
        String input = """
            if (true) {
                int a;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testIfElse() {
        String input = """
            if (true) {
                int a;
            } else {
                float b;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testIfElseIf() {
        String input = """
            if (true) {
                int a;
            } else if (false) {
                float b;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testIfElseIfElse() {
        String input = """
            if (true) {
                int a;
            } else if (false) {
                float b;
            } else {
                string c;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testIfCondition() {
        String input = """
            int a;
            if (a == 5) {
                int b;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testIfElseConditionNoDeclaration() {
        String input = """
            if (a == 5) {
                int b;
            } else {
                float c;
            }
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testIfWrongCondition() {
        String input = """
            if (a = 5) {
                int b;
            }
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testIfNotBooleanCondition() {
        String input = """
            if ("ahoj") {
                int b;
            }
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testComplexIf() {
        String input = """
            int x;
            x = 5;
            if (x > 0 && x < 10) {
                int a;
            } else if (x > 10 && x < 20) {
                float b;
            } else {
                string c;
            }
        """;
        assertTrue(Util.check(input));
    }
}
