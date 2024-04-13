package org.codeComposer.parser.compiler.instruction.io;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record Print(Integer n) implements Instruction {

    @Override
    public String toString() {
        return "print %s".formatted(n);
    }
}
