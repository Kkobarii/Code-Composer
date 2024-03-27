// Generated from /home/kkobari/semester_6/PJP/project/src/main/antlr/project/Code.g4 by ANTLR 4.13.1
package org.codeComposer.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodeParser}.
 */
public interface CodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CodeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CodeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(CodeParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(CodeParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(CodeParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(CodeParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStat(CodeParser.ExpressionStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStat(CodeParser.ExpressionStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(CodeParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(CodeParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code writeStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStat(CodeParser.WriteStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code writeStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStat(CodeParser.WriteStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(CodeParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(CodeParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStat(CodeParser.ConditionStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStat(CodeParser.ConditionStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStat(CodeParser.LoopStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStat(CodeParser.LoopStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CodeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CodeParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CodeParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CodeParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CodeParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CodeParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(CodeParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(CodeParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(CodeParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(CodeParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(CodeParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(CodeParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool(CodeParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool(CodeParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(CodeParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(CodeParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CodeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CodeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFloat(CodeParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFloat(CodeParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInt(CodeParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInt(CodeParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logical}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical(CodeParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logical}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical(CodeParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(CodeParser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(CodeParser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(CodeParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(CodeParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relational}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational(CodeParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relational}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational(CodeParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryArithmetic}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithmetic(CodeParser.BinaryArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryArithmetic}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithmetic(CodeParser.BinaryArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModulo(CodeParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModulo(CodeParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code help}
	 * labeled alternative in {@link CodeParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterHelp(CodeParser.HelpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code help}
	 * labeled alternative in {@link CodeParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitHelp(CodeParser.HelpContext ctx);
}