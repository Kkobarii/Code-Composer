package org.codeComposer.parser.compiler.instruction.operation;

import org.codeComposer.parser.compiler.instruction.Instruction;

public record IntToFloat() implements Instruction {

    @Override
    public String toString() {
        return "itof";
    }
}
