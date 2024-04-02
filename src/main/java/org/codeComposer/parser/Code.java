package org.codeComposer.parser;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.codeComposer.gen.CodeLexer;
import org.codeComposer.gen.CodeParser;
import org.codeComposer.parser.error.ErrorListener;
import org.codeComposer.parser.error.ErrorHandler;

@Slf4j
public class Code {

    CodeParser parser = null;
    CodeParser.ProgramContext context = null;

    public Code() {
        ErrorHandler.clearErrors();
    }

    public boolean parse(String input) {
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
        TypeCheckVisitor visitor = new TypeCheckVisitor();
        visitor.visit(context);

        if (ErrorHandler.hasErrors()) {
            ErrorHandler.logErrors();
            log.error("Checking failed!");
            return false;
        }

        log.info("Checking successful!");
        return true;
    }

    public void log() {
        context.statement().forEach(stat -> log.info("Statement: {}", stat.toStringTree(parser)));
    }
}
