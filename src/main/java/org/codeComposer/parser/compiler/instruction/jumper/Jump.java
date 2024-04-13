package org.codeComposer.parser.compiler.instruction.jumper;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Jump(String n) implements Instruction {

    @Override
    public String toString() {
        return "jmp %s".formatted(n);
    }
}
