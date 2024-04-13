package org.codeComposer.test.statement;

import org.codeComposer.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionTest {

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
        String output = """
            push I 1
            push I 2
            add
            pop
            push I 1
            push I 2
            sub
            pop
            push I 1
            push I 2
            mul
            pop
            push I 1
            push I 2
            div
            pop
            push I 1
            push I 2
            mod
            pop
            push I 1
            push I 2
            eq
            pop
            push I 1
            push I 2
            eq
            not
            pop
            push I 1
            push I 2
            lt
            pop
            push I 1
            push I 2
            gt
            pop
            push I 1
            push I 2
            le
            pop
            push I 1
            push I 2
            ge
            pop
            push B true
            push B false
            and
            pop
            push B true
            push B false
            or
            pop
            push B true
            not
            pop
            push I 1
            uminus
            pop
                """;
        assertTrue(Util.compile(input, output));
    }
}
