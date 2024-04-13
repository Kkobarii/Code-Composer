package org.codeComposer.parser.compiler.instruction.io;

import org.codeComposer.parser.compiler.instruction.Instruction;
import org.codeComposer.parser.typeChecker.Type;

public record Read(Type t) implements Instruction {

    @Override
    public String toString() {
        return "read %s".formatted(t.toChar());
    }
}
