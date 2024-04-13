package org.codeComposer.parser.compiler.instruction.memory;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Load(String id) implements Instruction {

    @Override
    public String toString() {
        return "load %s".formatted(id);
    }
}
