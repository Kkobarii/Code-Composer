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
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(CodeParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(CodeParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(CodeParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(CodeParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doWhileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(CodeParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doWhileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(CodeParser.DoWhileStatContext ctx);
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
	 * Enter a parse tree produced by the {@code logicalNotExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNotExpr(CodeParser.LogicalNotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNotExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNotExpr(CodeParser.LogicalNotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(CodeParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(CodeParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moduloExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModuloExpr(CodeParser.ModuloExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moduloExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModuloExpr(CodeParser.ModuloExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(CodeParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(CodeParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatenationExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcatenationExpr(CodeParser.ConcatenationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatenationExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcatenationExpr(CodeParser.ConcatenationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(CodeParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(CodeParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryArithmeticExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithmeticExpr(CodeParser.BinaryArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryArithmeticExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithmeticExpr(CodeParser.BinaryArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpr(CodeParser.LogicalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpr(CodeParser.LogicalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(CodeParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(CodeParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(CodeParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(CodeParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(CodeParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(CodeParser.ParenthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond}
	 * labeled alternative in {@link CodeParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond(CodeParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link CodeParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond(CodeParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CodeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CodeParser.LiteralContext ctx);
}