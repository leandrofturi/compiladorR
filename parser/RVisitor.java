// Generated from R.g4 by ANTLR 4.9.2
 package parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(RParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNotFormula}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNotFormula(RParser.ExprNotFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprINT}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprINT(RParser.ExprINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNA}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNA(RParser.ExprNAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprValuePkg}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValuePkg(RParser.ExprValuePkgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPexprP}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPexprP(RParser.ExprPexprPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprbreak}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprbreak(RParser.ExprbreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprWrappedin}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprWrappedin(RParser.ExprWrappedinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSubsublist}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSubsublist(RParser.ExprSubsublistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprExtract}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExtract(RParser.ExprExtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCompound(RParser.ExprCompoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSTRING}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSTRING(RParser.ExprSTRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(RParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTRUE}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTRUE(RParser.ExprTRUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprfor}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprfor(RParser.ExprforContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprwhile}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprwhile(RParser.ExprwhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(RParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInf}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInf(RParser.ExprInfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(RParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprifelse}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprifelse(RParser.ExprifelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprHEX}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprHEX(RParser.ExprHEXContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSign}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSign(RParser.ExprSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprHelp}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprHelp(RParser.ExprHelpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAssocRight}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssocRight(RParser.ExprAssocRightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(RParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFALSE}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFALSE(RParser.ExprFALSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSublist}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSublist(RParser.ExprSublistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNamespace}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNamespace(RParser.ExprNamespaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprEquality}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEquality(RParser.ExprEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFLOAT}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFLOAT(RParser.ExprFLOATContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCOMPLEX}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCOMPLEX(RParser.ExprCOMPLEXContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSum(RParser.ExprSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprDefine}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDefine(RParser.ExprDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNULL}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNULL(RParser.ExprNULLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTimes}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTimes(RParser.ExprTimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprrepeat}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprrepeat(RParser.ExprrepeatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprnext}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprnext(RParser.ExprnextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCall}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(RParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(RParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprif}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprif(RParser.ExprifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNaN}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNaN(RParser.ExprNaNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprEFormulaE}
	 * labeled alternative in {@link RParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEFormulaE(RParser.ExprEFormulaEContext ctx);
	/**
	 * Visit a parse tree produced by {@link RParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(RParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link RParser#formlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormlist(RParser.FormlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formID}
	 * labeled alternative in {@link RParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormID(RParser.FormIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formAssign}
	 * labeled alternative in {@link RParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormAssign(RParser.FormAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formVarags}
	 * labeled alternative in {@link RParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormVarags(RParser.FormVaragsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formPoint}
	 * labeled alternative in {@link RParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormPoint(RParser.FormPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link RParser#sublist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSublist(RParser.SublistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(RParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subID}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubID(RParser.SubIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subAssignID}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAssignID(RParser.SubAssignIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subSTRING}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubSTRING(RParser.SubSTRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subAssignSTRING}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAssignSTRING(RParser.SubAssignSTRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subNULL}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubNULL(RParser.SubNULLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subAssignNULL}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAssignNULL(RParser.SubAssignNULLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subVarags}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubVarags(RParser.SubVaragsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPoint}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPoint(RParser.SubPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subEmpty}
	 * labeled alternative in {@link RParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubEmpty(RParser.SubEmptyContext ctx);
}