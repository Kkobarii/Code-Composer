package org.codeComposer.parser.typeChecker;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    @Getter
    private final Map<Object, Type> symbolTable = new HashMap<>();

    public void put(Object object, Type type) {
        symbolTable.put(object, type);
    }

    public Type get(Object object) {
        return symbolTable.get(object);
    }

    public boolean contains(Object object) {
        return symbolTable.containsKey(object);
    }
}
