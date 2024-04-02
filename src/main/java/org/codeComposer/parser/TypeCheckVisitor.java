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
    public Type visitVariable(CodeParser.VariableContext ctx) {
        if (!symbolTable.contains(ctx.ID().getText())) {
            TypeErrorHandler.addError("Variable '" + ctx.ID().getText() + "' not declared",
                    ctx.getText(),
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine());
            return Type.ERROR;
        }

        return symbolTable.get(ctx.ID().getText());
    }

    @Override
    public Type visitIntExpr(CodeParser.IntExprContext ctx) {
        return Type.INT;
    }

    @Override
    public Type visitFloatExpr(CodeParser.FloatExprContext ctx) {
        return Type.FLOAT;
    }

    @Override
    public Type visitStringExpr(CodeParser.StringExprContext ctx) {
        return Type.STRING;
    }

    @Override
    public Type visitBoolExpr(CodeParser.BoolExprContext ctx) {
        return Type.BOOL;
    }

    @Override
    public Type visitUnaryMinusExpr(CodeParser.UnaryMinusExprContext ctx) {
        Type type = visit(ctx.expression());
        if (type != Type.INT && type != Type.FLOAT) {
            TypeErrorHandler.addError("Invalid type for unnary minus", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }
        return type;
    }

    @Override
    public Type visitBinaryArithmeticExpr(CodeParser.BinaryArithmeticExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.INT && left != Type.FLOAT) {
            TypeErrorHandler.addError("Invalid type for binary arithmetic expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT) {
            TypeErrorHandler.addError("Invalid type for binary arithmetic expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        // recast to float if one of them is float
        if (left == Type.FLOAT || right == Type.FLOAT) {
            return Type.FLOAT;
        }

        return Type.INT;
    }

    @Override
    public Type visitModuloExpr(CodeParser.ModuloExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.INT) {
            TypeErrorHandler.addError("Invalid type for modulo expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.INT) {
            TypeErrorHandler.addError("Invalid type for modulo expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.INT;
    }

    @Override
    public Type visitConcatenationExpr(CodeParser.ConcatenationExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.STRING) {
            TypeErrorHandler.addError("Invalid type for concatenation expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.STRING) {
            TypeErrorHandler.addError("Invalid type for concatenation expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.STRING;
    }
}
