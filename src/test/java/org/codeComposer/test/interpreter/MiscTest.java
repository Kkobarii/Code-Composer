package org.codeComposer.test.interpreter;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiscTest {

    @Test
    public void testArithmetic() {
        String input = """
            int a;
            a = 1;
            int b;
            b = 2;
            write a + b;
        """;
        String output = "3";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testMultipleWrites() {
        String input = """
            write "hello";
            write "world";
        """;
        String output = "hello\nworld";
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testMultipleWritesInOne() {
        String input = """
            write "hello", "world";
        """;
        String output = "hello world";
        assertTrue(Util.interpret(input, output));
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
        assertTrue(Util.interpret(input, output));
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
        assertTrue(Util.interpret(input, output));
    }

    @Test
    public void testReadWrite() {
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

        assertTrue(Util.interpret(input, output, new Scanner(scannerInput)));
    }

    @Test
    public void pajdaTest() {
        String input = """
            int a;
            int x;
            read x;
            
            while (x < 30) {
                if (x > 0 && x < 10) {
                    if (a % 2 == 0) {
                        a = a + 1;
                    } else {
                        a = a + 2;
                    }
                    
                    x = x + 1;
                } else if (x > 10 && x < 20) {
                    if (a % 2 == 0) {
                        a = a * 2;
                    } else {
                        a = a * 3;
                    }
                    
                    x = x + 2;
                } else {
                    a = a + 3;
                    x = x + 3;
                }
            }
            
            write a;
        """;

        String scannerInput = "5\n";

        String output = """
            201
        """;

        assertTrue(Util.interpret(input, output, new Scanner(scannerInput)));
    }
}
