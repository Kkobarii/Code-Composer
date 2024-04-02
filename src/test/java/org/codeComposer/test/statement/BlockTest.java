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
        assertTrue(Util.check(input));
    }

    @Test
    public void testBlockWithOneStatement() {
        String input = """
            {
                int a;
            }
        """;
        assertTrue(Util.check(input));
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
        assertTrue(Util.check(input));
    }
}
