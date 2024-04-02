package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Expression {

    @Test
    public void testExpression() {
        String input = """
            1 + 2;
            1 - 2;
            1 * 2;
            1 / 2;
            1 % 2;
            1 == 2;
            1 != 2;
            1 < 2;
            1 > 2;
            1 <= 2;
            1 >= 2;
            true && false;
            true || false;
            !true;
            -1;
            +1;
            1;
            1.0;
            "string";
            true;
            false;
        """;
        assertTrue(Util.check(input));
    }
}
