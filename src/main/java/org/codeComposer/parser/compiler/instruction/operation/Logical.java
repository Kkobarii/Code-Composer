package org.codeComposer.parser.compiler.instruction.operation;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Logical(Operator operator) implements Instruction {

    public enum Operator {
        AND, OR
    }

    @Override
    public String toString() {
        return operator().name().toLowerCase();
    }
}
