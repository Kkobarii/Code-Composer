package org.codeComposer.parser.error.model;

import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.codeComposer.parser.Type;

@Getter
public class TypeError implements Error {

    private final String message;

    public TypeError(ParserRuleContext ctx, Token token, String error, Object... args) {
            int lineNum = ctx.getStart().getLine();
            int charPos = 0;

            if (token != null) {
                charPos = token.getCharPositionInLine();
            } else {
                charPos = ctx.getStart().getCharPositionInLine();
            }

            String line = ctx.getStart().getInputStream().toString().split("\n")[lineNum - 1];
            String message = error.formatted(args);

            this.message = """
                    (.num.). Type error at line %d:%d! %s
                    |  - Statement: %s
                    |               %s
                    """.formatted(lineNum, charPos, message, line, " ".repeat(charPos) + "^");
        }

        public static TypeError of(ParserRuleContext ctx, Token token, String error, Object... args){
            return new TypeError(ctx, token, error, args);
        }
}
