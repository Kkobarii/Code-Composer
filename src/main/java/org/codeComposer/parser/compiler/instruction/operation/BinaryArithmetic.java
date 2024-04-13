package org.codeComposer.parser.compiler.instruction.operation;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record BinaryArithmetic(Operator operator) implements Instruction {

    public enum Operator {
        ADD, SUB, MUL, DIV
    }

    @Override
    public String toString() {
        return operator().name().toLowerCase();
    }
}
