package org.codeComposer.parser.compiler.instruction.memory;

import org.codeComposer.parser.compiler.instruction.Instruction;
import org.codeComposer.parser.typeChecker.Type;

public record Push(Type type, Object value) implements Instruction {

    @Override
    public String toString() {
        if (type == Type.STRING) {
            return "push %s \"%s\"".formatted(type.toChar(), value);
        }
        return "push %s %s".formatted(type.toChar(), value);
    }
}
