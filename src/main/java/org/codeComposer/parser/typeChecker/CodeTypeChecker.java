package org.codeComposer.parser.typeChecker;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.gen.CodeBaseVisitor;
import org.codeComposer.gen.CodeParser;
import org.codeComposer.parser.error.ErrorHandler;
import org.codeComposer.parser.error.model.TypeError;

@Slf4j
public class CodeTypeChecker extends CodeBaseVisitor<Type> {

    private final SymbolTable symbolTable = new SymbolTable();

    @Override
    public Type visitVarDeclStat(CodeParser.VarDeclStatContext ctx) {
        Type type = Type.mapType(ctx.type().getText());

        // put them in symbol table and check for redeclaration
        for (CodeParser.VariableContext variable : ctx.variable()) {
            if (symbolTable.contains(variable.ID().getText())) {
                ErrorHandler.addError(TypeError.of(ctx, variable.getStart(), "Variable %s has already been declared", variable.ID().getText()));
            }
            symbolTable.put(variable.ID().getText(), type);
        }

        return type;
    }

    @Override
    public Type visitVariable(CodeParser.VariableContext ctx) {
        if (!symbolTable.contains(ctx.ID().getText())) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.ID().getSymbol(), "Variable %s has not been declared", ctx.ID().getText()));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.expression().getStart(), "Invalid type %s for unary minus", type));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for binary arithmetic", left));
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for binary arithmetic", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for modulo", left));
            return Type.ERROR;
        }

        if (right != Type.INT) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for modulo", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for concatenation", left));
            return Type.ERROR;
        }

        if (right != Type.STRING) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for concatenation", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for relational expression", left));
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for relational expression", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for comparison", left));
            return Type.ERROR;
        }

        if (right != Type.INT && right != Type.FLOAT && right != Type.STRING) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for comparison", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.left.getStart(), "Invalid type %s for logical expression", left));
            return Type.ERROR;
        }

        if (right != Type.BOOL) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.right.getStart(), "Invalid type %s for logical expression", right));
            return Type.ERROR;
        }

        return Type.BOOL;
    }

    @Override
    public Type visitLogicalNotExpr(CodeParser.LogicalNotExprContext ctx) {
        Type type = visit(ctx.expression());

        if (type != Type.BOOL) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.expression().getStart(), "Invalid type %s for logical not", type));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.expression().getStart(), "Invalid type %s for assignment", right));
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
            ErrorHandler.addError(TypeError.of(ctx, ctx.expression().getStart(), "Invalid type %s for condition", type));
            return Type.ERROR;
        }

        return type;
    }

    @Override
    public Type visitTernaryExpr(CodeParser.TernaryExprContext ctx) {
        Type condition = visit(ctx.cond);
        Type left = visit(ctx.ifTrue);
        Type right = visit(ctx.ifFalse);

        if (condition == Type.ERROR || left == Type.ERROR || right == Type.ERROR) {
            return Type.ERROR;
        }

        if (condition != Type.BOOL) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.cond.getStart(), "Invalid type %s for ternary condition", condition));
            return Type.ERROR;
        }

        if (left == Type.FLOAT && right == Type.INT) {
            return Type.FLOAT;
        }
        if (left == Type.INT && right == Type.FLOAT) {
            return Type.FLOAT;
        }

        if (left != right) {
            ErrorHandler.addError(TypeError.of(ctx, ctx.ifFalse.getStart(), "Invalid types %s and %s for ternary ", left, right));
            return Type.ERROR;
        }

        return left;
    }
}
