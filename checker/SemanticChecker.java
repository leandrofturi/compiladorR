package checker;

import org.antlr.v4.runtime.Token;

import ast.AST;
import parser.RParser;
import parser.RParser.ExprContext;
import parser.RBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;
import static typing.Type.NULL_TYPE;
import static typing.Type.LOGICAL_TYPE;
import static typing.Type.INTEGER_TYPE;
import static typing.Type.DOUBLE_TYPE;
import static typing.Type.COMPLEX_TYPE;
import static typing.Type.CHARACTER_TYPE;
import static typing.Type.LIST_TYPE;
import static typing.Type.ID_TYPE;
import static typing.Type.NO_TYPE;

import static ast.NodeKind.PROG_NODE;
import static ast.NodeKind.VAR_DECL_NODE;
import static ast.NodeKind.VAR_USE_NODE;
import static ast.NodeKind.EXPRSUBSUBLIST_NODE;
import static ast.NodeKind.EXPRSUBLIST_NODE;
import static ast.NodeKind.VALUEPKG_NODE;
import static ast.NodeKind.EXTRACT_NODE;
import static ast.NodeKind.SIGN_NODE;
import static ast.NodeKind.NAMESPACE_NODE;
import static ast.NodeKind.TIMES_NODE;
import static ast.NodeKind.SUM_NODE;
import static ast.NodeKind.EQUALITY_NODE;
import static ast.NodeKind.NOT_NODE;
import static ast.NodeKind.AND_NODE;
import static ast.NodeKind.OR_NODE;
import static ast.NodeKind.NOTFORMULA_NODE;
import static ast.NodeKind.FORMULA_NODE;
import static ast.NodeKind.ASSIGN_NODE;
import static ast.NodeKind.DEFINE_NODE;
import static ast.NodeKind.CALL_NODE;
import static ast.NodeKind.COMPOUND_NODE;
import static ast.NodeKind.IF_NODE;
import static ast.NodeKind.IFELSE_NODE;
import static ast.NodeKind.FOR_NODE;
import static ast.NodeKind.WHILE_NODE;
import static ast.NodeKind.REPEAT_NODE;
import static ast.NodeKind.HELP_NODE;
import static ast.NodeKind.NEXT_NODE;
import static ast.NodeKind.BREAK_NODE;
import static ast.NodeKind.PAR_NODE;
import static ast.NodeKind.ID_NODE;
import static ast.NodeKind.NULL_VAL_NODE;
import static ast.NodeKind.LOGICAL_VAL_NODE;
import static ast.NodeKind.INTEGER_VAL_NODE;
import static ast.NodeKind.DOUBLE_VAL_NODE;
import static ast.NodeKind.COMPLEX_VAL_NODE;
import static ast.NodeKind.CHARACTER_VAL_NODE;
import static ast.NodeKind.LIST_VAL_NODE;
import static ast.NodeKind.SUBLIST_NODE;


// Analisador semântico de R implementado como um visitor da ParseTree do ANTLR.
public class SemanticChecker extends RBaseVisitor<AST> {

	private StrTable st = new StrTable();   // Tabela de strings.
    private VarTable vt = new VarTable();   // Tabela de variáveis.

	private boolean assigned = false;		// Indica que um assign está ocorrendo. Utilizado para mudança de tipo
	private Token declaredID;				// Atual variável declarada.

	AST root; // Nó raiz da AST sendo construída.

    // Testa se o dado token foi declarado antes.
    AST checkVar(Token token) {
    	String text = token.getText();
    	int line = token.getLine();
   		int idx = vt.lookupVar(text);
    	if (idx == -1) {
    		System.err.printf("SEMANTIC ERROR (%d): variable '%s' was not declared.\n", line, text);
    		System.exit(1);
            return null;
        }
		return new AST(VAR_USE_NODE, idx, vt.getType(idx));
    }

    // Cria uma nova variável a partir do dado token.
    AST newVar(Token token, Type type) {
    	String text = token.getText();
    	int line = token.getLine();
   		int idx = vt.lookupVar(text);
        if (idx != -1) {
			// Caso já exista, atualiza o tipo
			vt.updateTypeVar(idx, type);
            return new AST(VAR_DECL_NODE, idx, type);
        }
        idx = vt.addVar(text, line, type);
		return new AST(VAR_DECL_NODE, idx, type);
    }

    // ----------------------------------------------------------------------------
    // Type checking and inference.

    private static void typeError(int lineNo, String op, Type t1, Type t2) {
    	System.out.printf("SEMANTIC ERROR (%d): incompatible types for operator '%s', LHS is '%s' and RHS is '%s'.\n",
    			lineNo, op, t1.toString(), t2.toString());
    	System.exit(1);
    }

    private static void checkLogicalExpr(int lineNo, String cmd, Type t) {
        if (t != LOGICAL_TYPE) {
            System.out.printf("SEMANTIC ERROR (%d): conditional expression in '%s' is '%s' instead of '%s'.\n",
               lineNo, cmd, t.toString(), LOGICAL_TYPE.toString());
            System.exit(1);
        }
    }

    // ----------------------------------------------------------------------------
    // Exibe o conteúdo das tabelas em stdout.
    void printTables() {
        System.out.print("\n\n");
        System.out.print(st);
        System.out.print("\n\n");
    	System.out.print(vt);
    	System.out.print("\n\n");
    }

    // Exibe a AST no formato DOT em stderr.
    void printAST() {
    	AST.printDot(root, vt);
    }

    // ----------------------------------------------------------------------------
    // Visitadores.

	@Override public AST visitProg(RParser.ProgContext ctx) {
		// Visita recursivamente os filhos para construir a AST.
    	root = AST.newSubtree(PROG_NODE, NO_TYPE);
    	for (int i = 0; i < ctx.expr().size(); i++) {
    		AST child = visit(ctx.expr(i));
    		root.addChild(child);
    	}
		return root;
	}

	@Override public AST visitExprNotFormula(RParser.ExprNotFormulaContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprINT(RParser.ExprINTContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, INTEGER_TYPE);
			assigned = false;
		}
		int intData = Integer.parseInt(ctx.getText());
		return new AST(INTEGER_VAL_NODE, intData, INTEGER_TYPE);
	}

	@Override public AST visitExprNA(RParser.ExprNAContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, DOUBLE_TYPE);
			assigned = false;
		}
		int intData = Integer.parseInt(ctx.getText());
		return new AST(DOUBLE_VAL_NODE, intData, DOUBLE_TYPE);
	}

	@Override public AST visitExprValuePkg(RParser.ExprValuePkgContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprPexprP(RParser.ExprPexprPContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprbreak(RParser.ExprbreakContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprWrappedin(RParser.ExprWrappedinContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprSubsublist(RParser.ExprSubsublistContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprExtract(RParser.ExprExtractContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprCompound(RParser.ExprCompoundContext ctx) { return visitChildren(ctx); }

	@Override
	public AST visitExprSTRING(RParser.ExprSTRINGContext ctx) {
		int idx = st.addStr(ctx.STRING().getText());
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, CHARACTER_TYPE);
			assigned = false;
		}
		return new AST(CHARACTER_VAL_NODE, idx, CHARACTER_TYPE);
	}

	@Override
	public AST visitExprAssign(RParser.ExprAssignContext ctx) {
		// Sinaliza que um assign ocorreu.
		assigned = true;
		AST node = AST.newSubtree(ASSIGN_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprTRUE(RParser.ExprTRUEContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, LOGICAL_TYPE);
			assigned = false;
		}
		return new AST(LOGICAL_VAL_NODE, 1, LOGICAL_TYPE);
	}

	@Override public AST visitExprfor(RParser.ExprforContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprwhile(RParser.ExprwhileContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprOr(RParser.ExprOrContext ctx) {
		AST node = AST.newSubtree(OR_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprInf(RParser.ExprInfContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, DOUBLE_TYPE);
			assigned = false;
		}
		return new AST(DOUBLE_VAL_NODE, Double.POSITIVE_INFINITY, DOUBLE_TYPE);
	}

	@Override public AST visitExprAnd(RParser.ExprAndContext ctx) {
		AST node = AST.newSubtree(AND_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprifelse(RParser.ExprifelseContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprHEX(RParser.ExprHEXContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, DOUBLE_TYPE);
			assigned = false;
		}
		double doubleData = Double.parseDouble(ctx.getText());
		return new AST(DOUBLE_VAL_NODE, doubleData, DOUBLE_TYPE);
	}

	@Override public AST visitExprSign(RParser.ExprSignContext ctx) {
		AST node = AST.newSubtree(SIGN_NODE, NO_TYPE, visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprHelp(RParser.ExprHelpContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprAssocRight(RParser.ExprAssocRightContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprNot(RParser.ExprNotContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprFALSE(RParser.ExprFALSEContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, LOGICAL_TYPE);
			assigned = false;
		}
		return new AST(LOGICAL_VAL_NODE, 0, LOGICAL_TYPE);
	}

	@Override public AST visitExprSublist(RParser.ExprSublistContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprNamespace(RParser.ExprNamespaceContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprEquality(RParser.ExprEqualityContext ctx) {
		AST node = AST.newSubtree(EQUALITY_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprFLOAT(RParser.ExprFLOATContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, DOUBLE_TYPE);
			assigned = false;
		}
		double doubleData = Double.parseDouble(ctx.getText());
		return new AST(DOUBLE_VAL_NODE, doubleData, DOUBLE_TYPE);
	}

	@Override public AST visitExprCOMPLEX(RParser.ExprCOMPLEXContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprSum(RParser.ExprSumContext ctx) {
		AST node = AST.newSubtree(SUM_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprDefine(RParser.ExprDefineContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprNULL(RParser.ExprNULLContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, NULL_TYPE);
			assigned = false;
		}
		int intData = Integer.parseInt(ctx.getText());
		return new AST(NULL_VAL_NODE, 0, NULL_TYPE);
	}

	@Override public AST visitExprTimes(RParser.ExprTimesContext ctx) {
		AST node = AST.newSubtree(TIMES_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprrepeat(RParser.ExprrepeatContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprnext(RParser.ExprnextContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprCall(RParser.ExprCallContext ctx) {
		AST node = AST.newSubtree(CALL_NODE, NO_TYPE, visit(ctx.expr()), visit(ctx.sublist()));
		return node;
	}

	@Override
	public AST visitExprID(RParser.ExprIDContext ctx) {
    	// Salva o ID corrente
		declaredID = ctx.ID().getSymbol();
		return newVar(declaredID, ID_TYPE);
	}

	@Override public AST visitExprif(RParser.ExprifContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprNaN(RParser.ExprNaNContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(declaredID, DOUBLE_TYPE);
			assigned = false;
		}
		return new AST(DOUBLE_VAL_NODE, Double.NaN, DOUBLE_TYPE);
	}

	@Override public AST visitExprEFormulaE(RParser.ExprEFormulaEContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprlist(RParser.ExprlistContext ctx) { return visitChildren(ctx); }

	@Override public AST visitFormlist(RParser.FormlistContext ctx) { return visitChildren(ctx); }

	@Override public AST visitForm(RParser.FormContext ctx) { return visitChildren(ctx); }

	@Override public AST visitSublist(RParser.SublistContext ctx) {
		AST node = AST.newSubtree(SUBLIST_NODE, NO_TYPE);
		for (int i = 0; i < ctx.sub().size(); i++) {
			AST child = visit(ctx.sub(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitSub(RParser.SubContext ctx) { return visitChildren(ctx); }

}
