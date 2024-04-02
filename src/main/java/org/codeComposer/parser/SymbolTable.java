package org.codeComposer.parser;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Type> symbolTable = new HashMap<>();

    public void add(String name, Type type) {
        symbolTable.put(name, type);
    }

    public Type get(String name) {
        return symbolTable.get(name);
    }

    public boolean contains(String name) {
        return symbolTable.containsKey(name);
    }
}
