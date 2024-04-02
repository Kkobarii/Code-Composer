package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhileTest {

    @Test
    public void testWhile() {
        String input = """
            while (true) {
                int a;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWhileCondition() {
        String input = """
            int a;
            while (a < 10) {
                a = a + 1;
            }
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWhileNoDeclaration() {
        String input = """
            while (a < 10) {
                a = a + 1;
            }
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testWhileNoCondition() {
        String input = """
            int a;
            while () {
                a = a + 1;
            }
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testWhileNoBlock() {
        String input = """
            while (a < 10)
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testWhileEmptyBlock() {
        String input = """
            int a;
            while (a < 10) {}
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWhileBadCondition() {
        String input = """
            int a;
            while ("ahoj") {
                a = a + 1;
            }
        """;
        assertFalse(Util.check(input));
    }
}
