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
    public Type visitLiteralExpr(CodeParser.LiteralExprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Type visitLiteral(CodeParser.LiteralContext ctx) {
        if (ctx.INT() != null) {
            return Type.INT;
        } if (ctx.FLOAT() != null) {
            return Type.FLOAT;
        } if (ctx.STRING() != null) {
            return Type.STRING;
        } if (ctx.BOOL() != null) {
            return Type.BOOL;
        }
        return Type.ERROR;
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

    @Override
    public Type visitRelationalExpr(CodeParser.RelationalExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.INT && left != Type.FLOAT) {
            TypeErrorHandler.addError("Invalid type for relational expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT) {
            TypeErrorHandler.addError("Invalid type for relational expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.BOOL;
    }

    @Override
    public Type visitComparisonExpr(CodeParser.ComparisonExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.INT && left != Type.FLOAT && left != Type.STRING) {
            TypeErrorHandler.addError("Invalid type for comparison expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT && right != Type.STRING) {
            TypeErrorHandler.addError("Invalid type for comparison expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.BOOL;
    }

    @Override
    public Type visitLogicalExpr(CodeParser.LogicalExprContext ctx) {
        Type left = visit(ctx.left);
        Type right = visit(ctx.right);

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        // correct types
        if (left != Type.BOOL) {
            TypeErrorHandler.addError("Invalid type for logical expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        if (right != Type.BOOL) {
            TypeErrorHandler.addError("Invalid type for logical expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.BOOL;
    }

    @Override
    public Type visitLogicalNotExpr(CodeParser.LogicalNotExprContext ctx) {
        Type type = visit(ctx.expression());

        if (type != Type.BOOL) {
            TypeErrorHandler.addError("Invalid type for logical not expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return Type.BOOL;
    }

    @Override
    public Type visitAssignmentExpr(CodeParser.AssignmentExprContext ctx) {
        Type left = visit(ctx.variable());
        Type right = visit(ctx.expression());

        if (left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        if (left == Type.FLOAT && right == Type.INT) {
            return Type.FLOAT;
        }

        if (left != right) {
            TypeErrorHandler.addError("Invalid type for assignment expression", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return left;
    }

    @Override
    public Type visitParenthesesExpr(CodeParser.ParenthesesExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Type visitCond(CodeParser.CondContext ctx) {
        Type type = visit(ctx.expression());

        if (type != Type.BOOL) {
            TypeErrorHandler.addError("Invalid type for condition", ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return Type.ERROR;
        }

        return type;
    }
}
