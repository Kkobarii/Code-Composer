package org.codeComposer.parser.error.model;

import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.codeComposer.parser.Type;

@Getter
public class TypeError implements Error {

    private final String message;

    public TypeError(String sender, String variable, Type type, ParserRuleContext ctx, Token token) {

        int linePosition = ctx.getStart().getLine();
        int charPositionInLine = token.getCharPositionInLine();

        StringBuilder sb = new StringBuilder();
        sb.append("TYPE ERROR at ");
        sb.append(linePosition);
        sb.append(":");
        sb.append(charPositionInLine);
        sb.append(" - ");
        sb.append("Invalid type for ");
        sb.append(sender);
        sb.append(" '");
        sb.append(variable);
        sb.append("' (");
        sb.append(type);
        sb.append(")");
        sb.append("\n");

        sb.append(ctx.getText());
        sb.append("\n");
        sb.append(" ".repeat(Math.max(0, charPositionInLine)));
        sb.append("^");
        sb.append("\n");

        this.message = sb.toString();
    }

    public static TypeError of(String sender, String variable, Type type, ParserRuleContext ctx, Token token) {
        return new TypeError(sender, variable, type, ctx, token);
    }
}
