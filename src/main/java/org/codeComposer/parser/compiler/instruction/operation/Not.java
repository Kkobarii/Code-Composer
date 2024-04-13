package org.codeComposer.parser.compiler.instruction.operation;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Not() implements Instruction {

    @Override
    public String toString() {
        return "not";
    }
}
