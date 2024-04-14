package org.codeComposer.parser.compiler;

import lombok.extern.slf4j.Slf4j;
import org.codeComposer.gen.CodeBaseVisitor;
import org.codeComposer.gen.CodeParser;
import org.codeComposer.parser.compiler.instruction.Instruction;
import org.codeComposer.parser.compiler.instruction.io.Print;
import org.codeComposer.parser.compiler.instruction.io.Read;
import org.codeComposer.parser.compiler.instruction.jumper.FalseJump;
import org.codeComposer.parser.compiler.instruction.jumper.Jump;
import org.codeComposer.parser.compiler.instruction.jumper.Label;
import org.codeComposer.parser.compiler.instruction.memory.Load;
import org.codeComposer.parser.compiler.instruction.memory.Pop;
import org.codeComposer.parser.compiler.instruction.memory.Push;
import org.codeComposer.parser.compiler.instruction.memory.Save;
import org.codeComposer.parser.compiler.instruction.operation.*;
import org.codeComposer.parser.typeChecker.SymbolTable;
import org.codeComposer.parser.typeChecker.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class CodeCompiler extends CodeBaseVisitor<List<Instruction>> {
    private final SymbolTable tree = new SymbolTable();

    private final HashMap<String, Integer> labelCounter = new HashMap<>();
    private String getLabel(String name) {
        labelCounter.putIfAbsent(name, 0);
        int counter = labelCounter.get(name);
        String result = name + "_" + counter;
        labelCounter.put(name, counter + 1);
        return result;
    }

    @Override
    public List<Instruction> visitProgram(CodeParser.ProgramContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        for (CodeParser.StatementContext statement : ctx.statement()) {
            instructions.addAll(visit(statement));
        }

        return instructions;
    }

    // Statement

    @Override
    public List<Instruction> visitExpressionStat(CodeParser.ExpressionStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(visit(ctx.expression()));
        instructions.add(new Pop());
        return instructions;
    }

    @Override
    public List<Instruction> visitWriteStat(CodeParser.WriteStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        for (CodeParser.ExpressionContext expression : ctx.expression()) {
            instructions.addAll(visit(expression));
        }

        instructions.add(new Print(ctx.expression().size()));
        return instructions;
    }

    @Override
    public List<Instruction> visitReadStat(CodeParser.ReadStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        for (CodeParser.VariableContext variable : ctx.variable()) {
            Type type = tree.get(variable.ID().getText());
            instructions.add(new Read(type));
            instructions.add(new Save(variable.ID().getText()));
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitBlockStat(CodeParser.BlockStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        for (CodeParser.StatementContext statement : ctx.statement()) {
            instructions.addAll(visit(statement));
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitIfStat(CodeParser.IfStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> condInstructions = visit(ctx.condition());

        CodeParser.StatementContext ifTrue = ctx.statement(0);
        CodeParser.StatementContext ifFalse = ctx.statement(1);

        String falseLabel = getLabel("ifFalse");

        instructions.addAll(condInstructions);
        instructions.add(new FalseJump(falseLabel));

        instructions.addAll(visit(ifTrue));

        if (ifFalse != null) {
            String endLabel = getLabel("ifEnd");
            instructions.add(new Jump(endLabel));
            instructions.add(new Label(falseLabel));

            instructions.addAll(visit(ifFalse));

            instructions.add(new Label(endLabel));
        } else {
            instructions.add(new Label(falseLabel));
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitWhileStat(CodeParser.WhileStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        String startLabel = getLabel("whileStart");
        String endLabel = getLabel("whileEnd");

        instructions.add(new Label(startLabel));

        List<Instruction> condInstructions = visit(ctx.condition());

        instructions.addAll(condInstructions);
        instructions.add(new FalseJump(endLabel));

        instructions.addAll(visit(ctx.statement()));

        instructions.add(new Jump(startLabel));
        instructions.add(new Label(endLabel));

        return instructions;
    }

    // Expression

    @Override
    public List<Instruction> visitEmptyStat(CodeParser.EmptyStatContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<Instruction> visitVarDeclStat(CodeParser.VarDeclStatContext ctx) {
        List<Instruction> instructions = new ArrayList<>();
        Type type = Type.mapType(ctx.type().getText());
        Object defaultValue = Type.mapDefaultValue(type);

        for (CodeParser.VariableContext var : ctx.variable()) {
            tree.put(var, type);
            tree.put(var.ID().toString(), type);
            instructions.add(new Push(type, defaultValue));
            instructions.add(new Save(var.ID().getText()));
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitAssignmentExpr(CodeParser.AssignmentExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(visit(ctx.expression()));

        if (tree.get(ctx.variable().ID().getText()) == Type.FLOAT && tree.get(ctx.expression()) == Type.INT)
            instructions.add(new IntToFloat());

        instructions.add(new Save(ctx.variable().ID().getText()));
        instructions.add(new Load(ctx.variable().ID().getText()));

        return instructions;
    }

    @Override
    public List<Instruction> visitUnaryMinusExpr(CodeParser.UnaryMinusExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(visit(ctx.expression()));
        instructions.add(new UnaryMinus());

        return instructions;
    }

    private List<Instruction> addAndRecast(List<Instruction> lInstructions, List<Instruction> rInstructions, Type left, Type right) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(lInstructions);
        if (left == Type.INT && right == Type.FLOAT)
            instructions.add(new IntToFloat());
        instructions.addAll(rInstructions);
        if (right == Type.INT && left == Type.FLOAT)
            instructions.add(new IntToFloat());
        return instructions;
    }

    @Override
    public List<Instruction> visitBinaryArithmeticExpr(CodeParser.BinaryArithmeticExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        Type left = tree.get(ctx.left);
        Type right = tree.get(ctx.right);

        instructions.addAll(addAndRecast(lInstructions, rInstructions, left, right));

        BinaryArithmetic.Operator operator = switch (ctx.op.getText()) {
            case "+" -> BinaryArithmetic.Operator.ADD;
            case "-" -> BinaryArithmetic.Operator.SUB;
            case "*" -> BinaryArithmetic.Operator.MUL;
            case "/" -> BinaryArithmetic.Operator.DIV;
            default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        };

        instructions.add(new BinaryArithmetic(operator));

        return instructions;
    }

    @Override
    public List<Instruction> visitRelationalExpr(CodeParser.RelationalExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        Type left = tree.get(ctx.left);
        Type right = tree.get(ctx.right);

        instructions.addAll(addAndRecast(lInstructions, rInstructions, left, right));

        Relational.Operator operator = switch (ctx.op.getText()) {
            case "<" -> Relational.Operator.LT;
            case "<=" -> Relational.Operator.LE;
            case ">" -> Relational.Operator.GT;
            case ">=" -> Relational.Operator.GE;
            default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        };

        instructions.add(new Relational(operator));

        return instructions;
    }

    @Override
    public List<Instruction> visitComparisonExpr(CodeParser.ComparisonExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        Type left = tree.get(ctx.left);
        Type right = tree.get(ctx.right);

        instructions.addAll(addAndRecast(lInstructions, rInstructions, left, right));

        switch (ctx.op.getText()) {
            case "==" -> instructions.add(new Equal());
            case "!=" -> {
                instructions.add(new Equal());
                instructions.add(new Not());
            }
            default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitLogicalExpr(CodeParser.LogicalExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        Type left = tree.get(ctx.left);
        Type right = tree.get(ctx.right);

        instructions.addAll(addAndRecast(lInstructions, rInstructions, left, right));

        Logical.Operator operator = switch (ctx.op.getText()) {
            case "&&" -> Logical.Operator.AND;
            case "||" -> Logical.Operator.OR;
            default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        };

        instructions.add(new Logical(operator));

        return instructions;
    }

    @Override
    public List<Instruction> visitLogicalNotExpr(CodeParser.LogicalNotExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(visit(ctx.expression()));
        instructions.add(new Not());

        return instructions;
    }

    @Override
    public List<Instruction> visitModuloExpr(CodeParser.ModuloExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        instructions.addAll(lInstructions);
        instructions.addAll(rInstructions);

        instructions.add(new Modulo());

        return instructions;
    }

    @Override
    public List<Instruction> visitConcatenationExpr(CodeParser.ConcatenationExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> lInstructions = visit(ctx.left);
        List<Instruction> rInstructions = visit(ctx.right);

        instructions.addAll(lInstructions);
        instructions.addAll(rInstructions);

        instructions.add(new Concatenation());

        return instructions;
    }

    @Override
    public List<Instruction> visitParenthesesExpr(CodeParser.ParenthesesExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public List<Instruction> visitTernaryExpr(CodeParser.TernaryExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        List<Instruction> condInstructions = visit(ctx.cond);
        List<Instruction> trueInstructions = visit(ctx.ifTrue);
        List<Instruction> falseInstructions = visit(ctx.ifFalse);

        String falseLabel = getLabel("ternaryFalse");
        String endLabel = getLabel("ternaryEnd");

        Type left = tree.get(ctx.ifTrue);
        Type right = tree.get(ctx.ifFalse);

        instructions.addAll(condInstructions);
        instructions.add(new FalseJump(falseLabel));

        instructions.addAll(trueInstructions);
        if (left == Type.INT && right == Type.FLOAT)
            instructions.add(new IntToFloat());
        instructions.add(new Jump(endLabel));

        instructions.add(new Label(falseLabel));
        instructions.addAll(falseInstructions);
        if (right == Type.INT && left == Type.FLOAT)
            instructions.add(new IntToFloat());

        instructions.add(new Label(endLabel));

        return instructions;
    }

    // Literal

    @Override
    public List<Instruction> visitVariableExpr(CodeParser.VariableExprContext ctx) {
        String id = ctx.variable().ID().getText();
        tree.put(ctx, tree.get(id));
        return List.of(new Load(id));
    }

    @Override
    public List<Instruction> visitLiteralExpr(CodeParser.LiteralExprContext ctx) {
        List<Instruction> instructions = new ArrayList<>();

        Type type = Type.ERROR;
        Object value = null;

        if (ctx.literal().INT() != null) {
            type = Type.INT;
            value = Integer.parseInt(ctx.getText());
        }
        else if (ctx.literal().FLOAT() != null) {
            type = Type.FLOAT;
            value = Float.parseFloat(ctx.getText());
        }
        else if (ctx.literal().STRING() != null) {
            type = Type.STRING;
            value = ctx.getText().substring(1, ctx.getText().length() - 1);
        }
        else if (ctx.literal().BOOL() != null) {
            type = Type.BOOL;
            value = Boolean.parseBoolean(ctx.getText());
        }

        instructions.add(new Push(type, value));
        tree.put(ctx, type);

        return instructions;
    }
}
