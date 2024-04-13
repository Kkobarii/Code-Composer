package org.codeComposer.parser.typeChecker;

public enum Type {
    INT, FLOAT, STRING, BOOL, VOID, ERROR;

    public Character toChar() {
        return toString().charAt(0);
    }

    public static Type mapType(String type) {
        return switch (type) {
            case "int" -> Type.INT;
            case "float" -> Type.FLOAT;
            case "string" -> Type.STRING;
            case "bool" -> Type.BOOL;
            default -> Type.VOID;
        };
    }

    public static Object mapDefaultValue(Type type) {
        return switch (type) {
            case INT -> 0;
            case FLOAT -> 0.0;
            case STRING -> "";
            case BOOL -> false;
            default -> null;
        };
    }
}
