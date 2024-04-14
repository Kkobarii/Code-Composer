package org.codeComposer.test.interpreter;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryOperationTest {

    @Test
    public void testAdd() {
        String input = """
            write 1 + 2;
        """;
        String output = "3";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testSub() {
        String input = """
            write 1 - 2;
        """;
        String output = "-1";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testMul() {
        String input = """
            write 2 * 3;
        """;
        String output = "6";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testDiv() {
        String input = """
            write 6 / 2;
        """;
        String output = "3";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testFloatDiv() {
        String input = """
            write 6.0 / 4;
        """;
        String output = "1.5";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testComplexArtithmetic() {
        String input = """
            write 2 * 3 + 4;
        """;
        String output = "10";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testModulo() {
        String input = """
            write 3 % 2;
        """;
        String output = "1";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testConcatenation() {
        String input = """
            write "hello" . "world";
        """;
        String output = "helloworld";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testLogicalAnd() {
        String input = """
            write true && false;
        """;
        String output = "false";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testLogicalOr() {
        String input = """
            write true || false;
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testRelationalGt() {
        String input = """
            write 1 > 2;
        """;
        String output = "false";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testRelationalGte() {
        String input = """
            write 1 >= 2;
        """;
        String output = "false";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testRelationalLt() {
        String input = """
            write 1 < 2;
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testRelationalLte() {
        String input = """
            write 1 <= 2;
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testEqualInt() {
        String input = """
            write 1 == 2;
        """;
        String output = "false";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testEqualFloat() {
        String input = """
            write 1.0 == 1.0;
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testEqualString() {
        String input = """
            write "hello" == "hello";
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testNotEqualInt() {
        String input = """
            write 1 != 2;
        """;
        String output = "true";
        assertTrue(Util.interpret(input, output));
    }
}
