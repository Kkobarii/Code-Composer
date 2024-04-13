package org.codeComposer.parser.compiler.instruction.operation;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Relational(Operator operator) implements Instruction {

    public enum Operator {
        LT, GT, LE, GE
    }

    @Override
    public String toString() {
        return operator().name().toLowerCase();
    }
}
