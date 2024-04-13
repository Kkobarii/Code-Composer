package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlockTest {

    @Test
    public void testEmptyBlock() {
        String input = """
            {
            }
        """;
        String output = "";
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testBlockWithOneStatement() {
        String input = """
            {
                int a;
            }
        """;
        String output = """
            push I 0
            save a
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testBlockWithMultipleStatements() {
        String input = """
            {
                int a;
                float b;
                string c;
                bool d;
            }
        """;
        String output = """
            push I 0
            save a
            push F 0.0
            save b
            push S ""
            save c
            push B false
            save d
        """;
        assertTrue(Util.compile(input, output));
    }
}
