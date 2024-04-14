package org.codeComposer.parser;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.codeComposer.gen.CodeLexer;
import org.codeComposer.gen.CodeParser;
import org.codeComposer.parser.compiler.CodeCompiler;
import org.codeComposer.parser.compiler.instruction.Instruction;
import org.codeComposer.parser.error.ErrorListener;
import org.codeComposer.parser.error.ErrorHandler;
import org.codeComposer.parser.interpreter.CodeInterpreter;
import org.codeComposer.parser.typeChecker.CodeTypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Code {

    CodeParser parser = null;
    CodeParser.ProgramContext context = null;

    @Getter
    List<Instruction> instructions = new ArrayList<>();
    @Getter
    List<String> output = new ArrayList<>();

    public Code() {
        ErrorHandler.clearErrors();
    }

    public boolean parse(String input) {
        log.debug("Parsing...");
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        parser = new CodeParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());

        context = parser.program();

        if (parser.getNumberOfSyntaxErrors() != 0) {
            log.error("Parsing failed!");
            return false;
        }

        log.info("Parsing successful!");
        return true;
    }

    public boolean check() {
        log.debug("Checking...");
        CodeTypeChecker visitor = new CodeTypeChecker();
        visitor.visit(context);

        if (ErrorHandler.hasErrors()) {
            ErrorHandler.logErrors();
            log.error("Checking failed!");
            return false;
        }

        log.info("Checking successful!");
        return true;
    }

    public boolean compile() {
        log.debug("Compiling...");
        CodeCompiler compiler = new CodeCompiler();
        instructions = compiler.visit(context);

        if (ErrorHandler.hasErrors()) {
            ErrorHandler.logErrors();
            log.error("Compilation failed!");
            return false;
        }

        for (Instruction instruction : instructions) {
            log.trace("\t\t{}", instruction.toString());
        }

        log.info("Compilation successful!");
        return true;
    }

    public boolean interpret() {
        return interpret(new Scanner(System.in));
    }

    public boolean interpret(Scanner scanner) {
        log.debug("Interpreting...");
        CodeInterpreter interpreter = new CodeInterpreter(scanner);

        try {
            interpreter.interpret(instructions);
            output = interpreter.getOutput();
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("Interpreting failed!");
            return false;
        }

        for (String line : output) {
            log.trace("\t\t{}", line);
        }

        log.info("Interpreting successful!");

        return true;
    }

    public String getInstructionsString() {
        StringBuilder sb = new StringBuilder();
        instructions.forEach(instruction -> sb.append(instruction.toString()).append("\n"));
        return sb.toString();
    }

    public String getOutputString() {
        StringBuilder sb = new StringBuilder();
        output.forEach(line -> sb.append(line).append("\n"));
        return sb.toString();
    }

    public void log() {
        context.statement().forEach(stat -> log.info("Statement: {}", stat.toStringTree(parser)));
    }
}
