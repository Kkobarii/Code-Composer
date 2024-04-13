package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyTest {

    @Test
    public void testEmptyStat() {
        String input = """
           
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testOneSemicolon() {
        String input = """
           ;
        """;
        String output = """
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testTwoSemicolons() {
        String input = """
            ;;
        """;
        String output = """
        """;
        assertTrue(Util.compile(input, output));
    }
}
