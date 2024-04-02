package org.codeComposer.parser;

import lombok.Getter;

@Getter
public class TypeError {

    private String message;

    public TypeError(String message, String line, int linePosition, int charPositionInLine) {
        StringBuilder sb = new StringBuilder();
        sb.append("Type error at line ");
        sb.append(linePosition);
        sb.append(":");
        sb.append(charPositionInLine);
        sb.append(" - ");
        sb.append(message);
        sb.append("\n");

        sb.append(line);
        sb.append("\n");
        sb.append(" ".repeat(Math.max(0, charPositionInLine)));
        sb.append("^");
        sb.append("\n");

        this.message = sb.toString();
    }
}
