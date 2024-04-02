// Generated from /home/kkobari/semester_6/PJP/project/src/main/antlr/project/Code.g4 by ANTLR 4.13.1
package org.codeComposer.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(CodeParser.EmptyStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(CodeParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStat(CodeParser.ExpressionStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStat(CodeParser.ReadStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code writeStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStat(CodeParser.WriteStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(CodeParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(CodeParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(CodeParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doWhileStat}
	 * labeled alternative in {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStat(CodeParser.DoWhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CodeParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CodeParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalNotExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNotExpr(CodeParser.LogicalNotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(CodeParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moduloExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuloExpr(CodeParser.ModuloExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(CodeParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatenationExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationExpr(CodeParser.ConcatenationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(CodeParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryArithmeticExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryArithmeticExpr(CodeParser.BinaryArithmeticExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpr(CodeParser.LogicalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(CodeParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(CodeParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(CodeParser.ParenthesesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link CodeParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(CodeParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CodeParser.LiteralContext ctx);
}