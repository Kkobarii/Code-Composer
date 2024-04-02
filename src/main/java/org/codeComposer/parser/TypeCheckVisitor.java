package org.codeComposer.parser;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.gen.CodeBaseVisitor;
import org.codeComposer.gen.CodeParser;

@Slf4j
public class TypeCheckVisitor extends CodeBaseVisitor<Type> {

    private SymbolTable symbolTable = new SymbolTable();

    private Type mapType(String type) {
        return switch (type) {
            case "int" -> Type.INT;
            case "float" -> Type.FLOAT;
            case "string" -> Type.STRING;
            case "bool" -> Type.BOOL;
            default -> Type.VOID;
        };
    }

    private Object mapDefaultValue(Type type) {
        return switch (type) {
            case INT -> 0;
            case FLOAT -> 0.0;
            case STRING -> "";
            case BOOL -> false;
            default -> null;
        };
    }

    @Override
    public Type visitVarDeclStat(CodeParser.VarDeclStatContext ctx) {
        Type type = mapType(ctx.type().getText());

        log.debug("Variable declaration: " + type);

        // put them in symbol table and check for redeclaration
        for (CodeParser.VariableContext variable : ctx.variable()) {
            if (symbolTable.contains(variable.ID().getText())) {
                TypeErrorHandler.addError("Variable '" + variable.ID().getText() + "' already declared",
                        ctx.getText(),
                        variable.ID().getSymbol().getLine(),
                        variable.ID().getSymbol().getCharPositionInLine());
            }
            symbolTable.add(variable.ID().getText(), type);
        }

        return type;
    }

    @Override
    public Type visitReadStat(CodeParser.ReadStatContext ctx) {
        for (CodeParser.VariableContext variable : ctx.variable()) {
            if (!symbolTable.contains(variable.ID().getText())) {
                TypeErrorHandler.addError("Variable '" + variable.ID().getText() + "' not declared",
                        ctx.getText(),
                        variable.ID().getSymbol().getLine(),
                        variable.ID().getSymbol().getCharPositionInLine());
            }
        }

        return Type.VOID;
    }
}
