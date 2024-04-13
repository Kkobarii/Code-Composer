package org.codeComposer.parser.compiler.instruction.jumper;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Label(String n) implements Instruction {

    @Override
    public String toString() {
        return"label %s".formatted(n);
    }
}
