package org.codeComposer.parser.processor;

import lombok.Getter;
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
import org.codeComposer.parser.typeChecker.Type;

import java.util.*;

public class CodeProcessor {

    private final Stack<Object> stack = new Stack<>();
    private final HashMap<String, Object> variableTable = new HashMap<>();
    private final HashMap<String, Integer> labelTable = new HashMap<>();

    @Getter
    private Scanner scanner;

    @Getter
    private List<String> output = new ArrayList<>();

    private int instructionPointer = 0;
    private boolean hasError = false;

    public CodeProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void process(List<Instruction> instructions) {
        instructionPointer = 0;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);

            if (instruction instanceof Label label) {
                labelTable.put(label.n(), i);
            }
        }

        while (instructionPointer < instructions.size() && !hasError) {
            Instruction instruction = instructions.get(instructionPointer);
            processInstruction(instruction);
            instructionPointer++;
        }
    }

    private void processInstruction(Instruction instruction) {

        switch (instruction) {
            // operation
            case BinaryArithmetic binaryArithmetic -> processBinaryArithmetic(binaryArithmetic);
            case Modulo modulo -> processModulo(modulo);
            case UnaryMinus unaryMinus -> processUnaryMinus(unaryMinus);
            case Concatenation concatenation -> processConcatenation(concatenation);
            case Logical logical -> processLogical(logical);
            case Relational relational -> processRelational(relational);
            case Equal equal -> processEqual(equal);
            case Not not -> processNot(not);
            case IntToFloat intToFloat -> processIntToFloat(intToFloat);
            // memory
            case Push push -> stack.push(push.value());
            case Pop pop -> stack.pop();
            case Save save -> processSave(save);
            case Load load -> processLoad(load);
            // io
            case Print print -> processPrint(print);
            case Read read -> processRead(read);
            // jumper
            case Jump jump -> processJump(jump);
            case FalseJump falseJump -> processFalseJump(falseJump);
            case Label label -> {}

            default -> {
                output.add("Unknown instruction: " + instruction);
                hasError = true;
            }
        }
    }

    private void processBinaryArithmetic(BinaryArithmetic binaryArithmetic) {

        Object right = stack.pop();
        Object left = stack.pop();

        boolean isFloat = left instanceof Float || right instanceof Float;

        switch (binaryArithmetic.operator()) {
            case ADD ->  {
                if (isFloat) {
                    stack.push((float) left + (float) right);
                } else {
                    stack.push((int) left + (int) right);
                }
            }
            case SUB -> {
                if (isFloat) {
                    stack.push((float) left - (float) right);
                } else {
                    stack.push((int) left - (int) right);
                }
            }
            case MUL -> {
                if (isFloat) {
                    stack.push((float) left * (float) right);
                } else {
                    stack.push((int) left * (int) right);
                }
            }
            case DIV -> {
                if (isFloat) {
                    stack.push((float) left / (float) right);
                } else {
                    stack.push((int) left / (int) right);
                }
            }
        }
    }

    private void processModulo(Modulo modulo) {
        Object right = stack.pop();
        Object left = stack.pop();

        stack.push((int) left % (int) right);
    }

    private void processUnaryMinus(UnaryMinus unaryMinus) {
        if (stack.peek() instanceof Integer) {
            stack.push(-(int) stack.pop());
        } else {
            stack.push(-(float) stack.pop());
        }
    }

    private void processConcatenation(Concatenation concatenation) {
        String right = (String) stack.pop();
        String left = (String) stack.pop();

        stack.push(left + right);
    }

    private void processLogical(Logical logical) {
        boolean right = (boolean) stack.pop();
        boolean left = (boolean) stack.pop();

        switch (logical.operator()) {
            case AND -> stack.push(left && right);
            case OR -> stack.push(left || right);
        }
    }

    private void processRelational(Relational relational) {
        Object right = stack.pop();
        Object left = stack.pop();

        boolean isFloat = left instanceof Float || right instanceof Float;

        switch (relational.operator()) {
            case GT -> {
                if (isFloat) {
                    stack.push((float) left > (float) right);
                } else {
                    stack.push((int) left > (int) right);
                }
            }
            case GE -> {
                if (isFloat) {
                    stack.push((float) left >= (float) right);
                } else {
                    stack.push((int) left >= (int) right);
                }
            }
            case LT -> {
                if (isFloat) {
                    stack.push((float) left < (float) right);
                } else {
                    stack.push((int) left < (int) right);
                }
            }
            case LE -> {
                if (isFloat) {
                    stack.push((float) left <= (float) right);
                } else {
                    stack.push((int) left <= (int) right);
                }
            }
        }
    }

    private void processEqual(Equal equal) {
        Object right = stack.pop();
        Object left = stack.pop();

        if (left instanceof Integer && right instanceof Integer) {
            stack.push((int) left == (int) right);
        } else if (left instanceof Float && right instanceof Float) {
            stack.push((float) left == (float) right);
        } else if (left instanceof Boolean && right instanceof Boolean) {
            stack.push((boolean) left == (boolean) right);
        } else {
            stack.push(left.equals(right));
        }
    }

    private void processNot(Not not) {
        stack.push(!(boolean) stack.pop());
    }

    private void processIntToFloat(IntToFloat intToFloat) {
        stack.push((float) (int) stack.pop());
    }

    private void processSave(Save save) {
        variableTable.put(save.id(), stack.peek());
    }

    private void processLoad(Load load) {
        stack.push(variableTable.get(load.id()));
    }

    private void processPrint(Print print) {
        String str = "";
        for (int i = 0; i < print.n(); i++) {
            str += stack.pop() + " ";
        }
        output.add(str.trim());
    }

    public void processRead(Read read) {
        String input = scanner.nextLine();

        switch (read.t()) {
            case Type.INT -> stack.push(Integer.parseInt(input));
            case Type.FLOAT -> stack.push(Float.parseFloat(input));
            case Type.BOOL -> stack.push(Boolean.parseBoolean(input));
            case Type.STRING -> stack.push(input);
            default -> {
                output.add("Unknown type: " + read.t());
                hasError = true;
            }
        }

        stack.push(input);
    }

    public void processJump(Jump jump) {
        instructionPointer = labelTable.get(jump.n());
    }

    public void processFalseJump(FalseJump jump) {
        boolean condition = (boolean) stack.pop();
        if (!condition) {
            instructionPointer = labelTable.get(jump.n());
        }
    }
}
