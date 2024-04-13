package org.codeComposer.test.processing;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComplexTest {

    @Test
    public void testComplex() {
        String input = """
            int a;
            a = 1;
            int b;
            b = 2;
            write a + b;
        """;
        String output = "3";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testMultipleWrites() {
        String input = """
            write "hello";
            write "world";
        """;
        String output = "hello\nworld";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testWhile() {
        String input = """
            int a;
            a = 0;
            while (a < 5) {
                write a;
                a = a + 1;
            }
        """;
        String output = "0\n1\n2\n3\n4";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void testIf() {
        String input = """
            int a;
            a = 0;
            if (a < 5) {
                write "less than 5";
            } else {
                write "greater than or equal to 5";
            }
        """;
        String output = "less than 5";
        assertTrue(Util.process(input, output));
    }

    @Test
    public void ReadWrite() {
        String input = """
            int a;
            float b;
            read a;
            read b;
            write a + b;
        """;

        String scannerInput = "40\n2.0\n";

        String output = """
            42.0
        """;

        // todo
//        assertTrue(Util.process(input, output, new Scanner(scannerInput)));
    }
}
