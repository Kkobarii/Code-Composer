package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WriteTest {

    @Test
    public void testWriteInt() {
        String input = """
            int a;
            write a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteFloat() {
        String input = """
            float a;
            write a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteString() {
        String input = """
            string a;
            write a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteBool() {
        String input = """
            bool a;
            write a;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteWord() {
        String input = """
            write "ahoj";
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteMultipleVariables() {
        String input = """
            int a;
            float b;
            string c;
            bool d;
            write a, b, c, d;
        """;
        assertTrue(Util.check(input));
    }

    @Test
    public void testWriteNoDeclaration() {
        String input = """
            write a;
        """;
        assertFalse(Util.check(input));
    }

    @Test
    public void testWriteNonsense() {
        String input = """
            write "ahoj" > 5;
        """;
        assertFalse(Util.check(input));
    }
}
