package org.codeComposer.parser.compiler.instruction.memory;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Save(String id) implements Instruction {

    @Override
    public String toString() {
        return "save " + id;
    }
}
