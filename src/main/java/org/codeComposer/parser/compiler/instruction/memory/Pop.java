package org.codeComposer.parser.compiler.instruction.memory;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Pop() implements Instruction {

    @Override
    public String toString() {
        return "pop";
    }
}
