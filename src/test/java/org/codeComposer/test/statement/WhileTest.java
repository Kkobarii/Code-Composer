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
        String output = """
            label whileStart_0
            push B true
            fjmp whileEnd_0
            push I 0
            save a
            jmp whileStart_0
            label whileEnd_0
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testWhileCondition() {
        String input = """
            int a;
            while (a < 10) {
                a = a + 1;
            }
        """;
        String output = """
            push I 0
            save a
            label whileStart_0
            load a
            push I 10
            lt
            fjmp whileEnd_0
            load a
            push I 1
            add
            save a
            load a
            pop
            jmp whileStart_0
            label whileEnd_0
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push I 0
            save a
            label whileStart_0
            load a
            push I 10
            lt
            fjmp whileEnd_0
            jmp whileStart_0
            label whileEnd_0
        """;
        assertTrue(Util.compile(input, output));
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
