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
        String output = """
            push B true
            fjmp ifFalse_0
            push I 0
            save a
            label ifFalse_0
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push B true
            fjmp ifFalse_0
            push I 0
            save a
            jmp ifEnd_0
            label ifFalse_0
            push F 0.0
            save b
            label ifEnd_0
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push B true
            fjmp ifFalse_0
            push I 0
            save a
            jmp ifEnd_0
            label ifFalse_0
            push B false
            fjmp ifFalse_1
            push F 0.0
            save b
            label ifFalse_1
            label ifEnd_0
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push B true
            fjmp ifFalse_0
            push I 0
            save a
            jmp ifEnd_0
            label ifFalse_0
            push B false
            fjmp ifFalse_1
            push F 0.0
            save b
            jmp ifEnd_1
            label ifFalse_1
            push S ""
            save c
            label ifEnd_1
            label ifEnd_0
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testIfCondition() {
        String input = """
            int a;
            if (a == 5) {
                int b;
            }
        """;
        String output = """
            push I 0
            save a
            load a
            push I 5
            eq
            fjmp ifFalse_0
            push I 0
            save b
            label ifFalse_0
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push I 0
            save x
            push I 5
            save x
            load x
            pop
            load x
            push I 0
            gt
            load x
            push I 10
            lt
            and
            fjmp ifFalse_0
            push I 0
            save a
            jmp ifEnd_0
            label ifFalse_0
            load x
            push I 10
            gt
            load x
            push I 20
            lt
            and
            fjmp ifFalse_1
            push F 0.0
            save b
            jmp ifEnd_1
            label ifFalse_1
            push S ""
            save c
            label ifEnd_1
            label ifEnd_0
        """;
        assertTrue(Util.compile(input, output));
    }
}
