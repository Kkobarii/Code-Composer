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
        String output = """
            push I 0
            save a
            load a
            print 1
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testWriteFloat() {
        String input = """
            float a;
            write a;
        """;
        String output = """
            push F 0.0
            save a
            load a
            print 1
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testWriteString() {
        String input = """
            string a;
            write a;
        """;
        String output = """
            push S ""
            save a
            load a
            print 1
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testWriteBool() {
        String input = """
            bool a;
            write a;
        """;
        String output = """
            push B false
            save a
            load a
            print 1
        """;
        assertTrue(Util.compile(input, output));
    }

    @Test
    public void testWriteWord() {
        String input = """
            write "ahoj";
        """;
        String output = """
            push S "ahoj"
            print 1
        """;
        assertTrue(Util.compile(input, output));
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
        String output = """
            push I 0
            save a
            push F 0.0
            save b
            push S ""
            save c
            push B false
            save d
            load a
            load b
            load c
            load d
            print 4
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
