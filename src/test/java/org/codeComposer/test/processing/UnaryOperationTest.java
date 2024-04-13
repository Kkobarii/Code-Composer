package org.codeComposer.test.processing;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnaryOperationTest {

    @Test
    public void testNeg() {
        String input = """
            write -1;
        """;
        String output = "-1";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testNegInt() {
        String input = """
            int a;
            a = 2;
            write -a;
        """;
        String output = "-2";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testNegFloat() {
        String input = """
            float a;
            a = 2.0;
            write -a;
        """;
        String output = "-2.0";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testNegFromNeg() {
        String input = """
            int a;
            a = -1;
            write -a;
        """;
        String output = "1";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testNot() {
        String input = """
            write !true;
        """;
        String output = "false";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testNotFromNot() {
        String input = """
            write !!true;
        """;
        String output = "true";
        assertTrue(Util.process(input, output));
    }
}
