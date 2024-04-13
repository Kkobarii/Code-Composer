package org.codeComposer.parser.compiler.instruction.jumper;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record FalseJump(String n) implements Instruction {

    @Override
    public String toString() {
        return "fjmp %s".formatted(n);
    }
}
