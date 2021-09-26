package checker;

import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.ArrayList;

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
import static typing.Type.SYMBOL_TYPE;
import static typing.Type.CLOSURE_TYPE;
import static typing.Type.ARRAY_TYPE;
import static typing.Type.NO_TYPE;

import typing.Conv;
import typing.Conv.Unif;
import static typing.Conv.I2L;
import static typing.Conv.D2L;

import ast.NodeKind;
import static ast.NodeKind.PROG_NODE;
import static ast.NodeKind.VAR_DECL_NODE;
import static ast.NodeKind.VAR_USE_NODE;
import static ast.NodeKind.EXPRSUBSUBLIST_NODE;
import static ast.NodeKind.EXPRSUBLIST_NODE;
import static ast.NodeKind.VALUEPKG_NODE;
import static ast.NodeKind.EXTRACT_NODE;
import static ast.NodeKind.ASSOCRIGHT_NODE;
import static ast.NodeKind.SIGN_NODE;
import static ast.NodeKind.NAMESPACE_NODE;
import static ast.NodeKind.WRAPPEDIN_NODE;
import static ast.NodeKind.EQ_NODE;
import static ast.NodeKind.NEQ_NODE;
import static ast.NodeKind.LT_NODE;
import static ast.NodeKind.LET_NODE;
import static ast.NodeKind.GT_NODE;
import static ast.NodeKind.GET_NODE;
import static ast.NodeKind.PLUS_NODE;
import static ast.NodeKind.MINUS_NODE;
import static ast.NodeKind.TIMES_NODE;
import static ast.NodeKind.OVER_NODE;
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
import static ast.NodeKind.EXPRLIST_NODE;
import static ast.NodeKind.FORMLIST_NODE;
import static ast.NodeKind.FORMASSIGN_NODE;
import static ast.NodeKind.SUBEXPR_NODE;
import static ast.NodeKind.SUBASSIGNID_NODE;
import static ast.NodeKind.SUBASSIGNCHARACTER_NODE;
import static ast.NodeKind.SUBASSIGNNULL_NODE;
import static ast.NodeKind.VARARG_NODE;
import static ast.NodeKind.POINT_NODE;
import static ast.NodeKind.EMPTY_NODE;


// Analisador semântico de R implementado como um visitor da ParseTree do ANTLR.
public class SemanticChecker extends RBaseVisitor<AST> {

	public StrTable st = new StrTable();   // Tabela de strings.
    public VarTable vt = new VarTable();   // Tabela de variáveis.

	AST root; // Nó raiz da AST sendo construída.

	private String assignOp = ""; // Indica que um assign ocorreu

    // Testa se o dado token foi declarado antes.
    AST checkVar(Token token) {
    	String text = token.getText();
    	int line = token.getLine();
   		int idx = vt.lookupVar(text);
    	if (idx == -1) {
    		System.out.printf("SEMANTIC ERROR (%d): variable '%s' was not declared.\n", line, text);
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

	private static void typeError(int lineNo, String op) {
    	System.out.printf("SEMANTIC ERROR (%d): incompatible types for operator '%s'.\n",
    			lineNo, op);
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
    public void printTables() {
        System.out.print("\n\n");
        System.out.print(st);
        System.out.print("\n\n");
    	System.out.print(vt);
    	System.out.print("\n\n");
    }

    // Exibe a AST no formato DOT em stderr.
    public void printAST() {
    	AST.printDot(root, vt);
    }

	// Retorna a AST construída ao final da análise.
    public AST getAST() {
    	return this.root;
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

	@Override public AST visitExprNotFormula(RParser.ExprNotFormulaContext ctx) {
		AST node = AST.newSubtree(NOTFORMULA_NODE, NO_TYPE, visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprINT(RParser.ExprINTContext ctx) {
		// Encapsulamento da conversão
		int intData = 0;
		try {
			intData = Integer.parseInt(ctx.getText().replace("L", ""));
		} catch (NumberFormatException e) {
			System.out.printf("SEMANTIC ERROR: Number Format Exception with %s.\n", ctx.getText());
    		System.exit(1);
		}
		return new AST(INTEGER_VAL_NODE, intData, INTEGER_TYPE);
	}

	@Override public AST visitExprNA(RParser.ExprNAContext ctx) {
		return new AST(DOUBLE_VAL_NODE, 0.0, DOUBLE_TYPE);
	}

	@Override public AST visitExprValuePkg(RParser.ExprValuePkgContext ctx) {
		AST node = AST.newSubtree(VALUEPKG_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprPexprP(RParser.ExprPexprPContext ctx) {
		return visit(ctx.expr());
	}

	@Override public AST visitExprbreak(RParser.ExprbreakContext ctx) {
		AST node = AST.newSubtree(BREAK_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitExprWrappedin(RParser.ExprWrappedinContext ctx) {
		AST node = AST.newSubtree(WRAPPEDIN_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprSubsublist(RParser.ExprSubsublistContext ctx) {
		AST node = AST.newSubtree(EXPRSUBSUBLIST_NODE, NO_TYPE, visit(ctx.expr()), visit(ctx.sublist()));
		return node;
	}

	@Override public AST visitExprExtract(RParser.ExprExtractContext ctx) {
		AST node = AST.newSubtree(EXTRACT_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprCompound(RParser.ExprCompoundContext ctx) {
		AST node = AST.newSubtree(COMPOUND_NODE, NO_TYPE, visit(ctx.exprlist()));
		return node;
	}

	@Override
	public AST visitExprSTRING(RParser.ExprSTRINGContext ctx) {
		int idx = st.addStr(ctx.STRING().getText());
		return new AST(CHARACTER_VAL_NODE, idx, CHARACTER_TYPE);
	}

	@Override
	public AST visitExprAssign(RParser.ExprAssignContext ctx) {
		assignOp = ctx.op.getText();
		AST var = visit(ctx.expr(0));
    	AST value = visit(ctx.expr(1));

		// Atualiza o tipo da variável
		int idx = var.intData;
		if (idx != -1) {
			vt.updateTypeVar(idx, value.type);
		}
		AST node = AST.newSubtree(ASSIGN_NODE, NO_TYPE, var, value);
		return node;
	}

	@Override public AST visitExprTRUE(RParser.ExprTRUEContext ctx) {
		return new AST(LOGICAL_VAL_NODE, 1, LOGICAL_TYPE);
	}

	@Override public AST visitExprfor(RParser.ExprforContext ctx) {
		AST node = AST.newSubtree(FOR_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprwhile(RParser.ExprwhileContext ctx) {
		AST node = AST.newSubtree(WHILE_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprOr(RParser.ExprOrContext ctx) {
		AST node = AST.newSubtree(OR_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprInf(RParser.ExprInfContext ctx) {
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

	@Override public AST visitExprifelse(RParser.ExprifelseContext ctx) {
		AST node = AST.newSubtree(IFELSE_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprHEX(RParser.ExprHEXContext ctx) {  return visitChildren(ctx); }

	@Override public AST visitExprSign(RParser.ExprSignContext ctx) {
		AST node = AST.newSubtree(SIGN_NODE, NO_TYPE, visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprHelp(RParser.ExprHelpContext ctx) {
		AST node = AST.newSubtree(HELP_NODE, NO_TYPE, visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprAssocRight(RParser.ExprAssocRightContext ctx) {
		AST node = AST.newSubtree(ASSOCRIGHT_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprNot(RParser.ExprNotContext ctx) {
		// Visita recursivamente a subexpressão.
		AST r = visit(ctx.expr());

		// Faz a unificação dos tipos para determinar o tipo resultante.
		Type rt = r.type;
		if (rt == INTEGER_TYPE) {
			r = Conv.createConvNode(I2L, r);
		} else if (rt == DOUBLE_TYPE) {
			r = Conv.createConvNode(D2L, r);
		} else if (rt != LOGICAL_TYPE) {
			System.out.printf("SEMANTIC ERROR: incompatible type for operator '!', RHS is '%s'.\n", rt.toString());
    		System.exit(1);
		}

		return AST.newSubtree(NOT_NODE, LOGICAL_TYPE, r);
	}

	@Override public AST visitExprFALSE(RParser.ExprFALSEContext ctx) {
		return new AST(LOGICAL_VAL_NODE, 0, LOGICAL_TYPE);
	}

	@Override public AST visitExprSublist(RParser.ExprSublistContext ctx) {
		AST node = AST.newSubtree(EXPRSUBLIST_NODE, NO_TYPE, visit(ctx.expr()), visit(ctx.sublist()));
		return node;
	}

	@Override public AST visitExprNamespace(RParser.ExprNamespaceContext ctx) {
		AST node = AST.newSubtree(NAMESPACE_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprEquality(RParser.ExprEqualityContext ctx) {
		// Visita recursivamente as duas subexpressões.
		AST l = visit(ctx.expr(0));
		AST r = visit(ctx.expr(1));

		// Faz a unificação dos tipos para determinar o tipo resultante.
		Type lt = l.type;
		Type rt = r.type;
		Unif unif = lt.unifyArithmetic(rt);

		if (unif.type == NO_TYPE) {
			typeError(ctx.op.getLine(), ctx.op.getText(), lt, rt);
		}

		// Cria os nós de conversão que forem necessários segundo a estrutura de conversão.
		l = Conv.createConvNode(unif.c.get(0), l);
		r = Conv.createConvNode(unif.c.get(1), r);

		// Olha qual é o operador e cria o nó correspondente na AST.
		if (ctx.op.getText().equals("==")) {
			return AST.newSubtree(EQ_NODE, unif.type, l, r);
		} else if (ctx.op.getText().equals("!=")) {
			return AST.newSubtree(NEQ_NODE, unif.type, l, r);
		} else if (ctx.op.getText().equals("<")) {
			return AST.newSubtree(LT_NODE, unif.type, l, r);
		} else if (ctx.op.getText().equals("<=")) {
			return AST.newSubtree(LET_NODE, unif.type, l, r);
		} else if (ctx.op.getText().equals(">")) {
			return AST.newSubtree(GT_NODE, unif.type, l, r);
		} else if (ctx.op.getText().equals(">=")) {
			return AST.newSubtree(GET_NODE, unif.type, l, r);
		} else {
			return AST.newSubtree(EMPTY_NODE, unif.type, l, r);
		}
	}

	@Override public AST visitExprFLOAT(RParser.ExprFLOATContext ctx) {
		// Encapsulamento da conversão
		double doubleData = 0.0;
		try {
			doubleData = Double.parseDouble(ctx.getText());
		} catch (NumberFormatException e) {
			System.out.printf("SEMANTIC ERROR: Number Format Exception with %s.\n", ctx.getText());
    		System.exit(1);
		}
		return new AST(DOUBLE_VAL_NODE, doubleData, DOUBLE_TYPE);
	}

	@Override public AST visitExprCOMPLEX(RParser.ExprCOMPLEXContext ctx) { return visitChildren(ctx); }

	@Override public AST visitExprSum(RParser.ExprSumContext ctx) {
		// Visita recursivamente as duas subexpressões.
		AST l = visit(ctx.expr(0));
		AST r = visit(ctx.expr(1));

		// Faz a unificação dos tipos para determinar o tipo resultante.
		Type lt = l.type;
		Type rt = r.type;
		Unif unif = lt.unifyArithmetic(rt);

		if (unif.type == NO_TYPE) {
			typeError(ctx.op.getLine(), ctx.op.getText(), lt, rt);
		}

		// Cria os nós de conversão que forem necessários segundo a estrutura de conversão.
		l = Conv.createConvNode(unif.c.get(0), l);
		r = Conv.createConvNode(unif.c.get(1), r);

		// Olha qual é o operador e cria o nó correspondente na AST.
		if (ctx.op.getText().equals("+")) {
			return AST.newSubtree(PLUS_NODE, unif.type, l, r);
		} else {
			return AST.newSubtree(MINUS_NODE, unif.type, l, r);
		}
	}

	@Override public AST visitExprDefine(RParser.ExprDefineContext ctx) {
		AST node = AST.newSubtree(DEFINE_NODE, NO_TYPE, visit(ctx.formlist()), visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprNULL(RParser.ExprNULLContext ctx) {
		return new AST(NULL_VAL_NODE, 0, NULL_TYPE);
	}

	@Override public AST visitExprTimes(RParser.ExprTimesContext ctx) {
		// Visita recursivamente as duas subexpressões.
		AST l = visit(ctx.expr(0));
		AST r = visit(ctx.expr(1));

		// Faz a unificação dos tipos para determinar o tipo resultante.
		Type lt = l.type;
		Type rt = r.type;
		Unif unif = lt.unifyArithmetic(rt);

		if (unif.type == NO_TYPE) {
			typeError(ctx.op.getLine(), ctx.op.getText(), lt, rt);
		}

		// Cria os nós de conversão que forem necessários segundo a estrutura de conversão.
		l = Conv.createConvNode(unif.c.get(0), l);
		r = Conv.createConvNode(unif.c.get(1), r);

		// Olha qual é o operador e cria o nó correspondente na AST.
		if (ctx.op.getText().equals("*")) {
			return AST.newSubtree(TIMES_NODE, unif.type, l, r);
		} else {
			return AST.newSubtree(OVER_NODE, unif.type, l, r);
		}
	}

	@Override public AST visitExprrepeat(RParser.ExprrepeatContext ctx) {
		AST node = AST.newSubtree(REPEAT_NODE, NO_TYPE, visit(ctx.expr()));
		return node;
	}

	@Override public AST visitExprnext(RParser.ExprnextContext ctx) {
		AST node = AST.newSubtree(NEXT_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitExprCall(RParser.ExprCallContext ctx) {
		AST fun = visit(ctx.expr());
		AST values = visit(ctx.sublist());

		String ass = null;
		String var = null;
		// Lookup no que está sendo passado como argumento
		if(assignOp == "") {
			ass = ctx.expr().getText();
		} else {
			// Obter apenas a chamada: c ou list
			ass = ctx.expr().getText().replaceAll("^[^"+ assignOp +"]*" + assignOp + "\\s*", "");
			// Obter o nome da variável
			var = ctx.expr().getText().replaceAll("\\s*"+ assignOp +".*$", "");
		}
		assignOp = "";
		
		if((values.getChildSize() > 0) && ass.equals("c")) {

			// Obtem todos os tipos
			Type head = values.getChild(0).type;
			List<Integer> types = new ArrayList<>();
			for (int i = 0; i < values.getChildSize(); i++) {
				types.add(values.getChild(i).type.ordinal());
			}

			// Faz a unificação dos tipos para determinar o tipo resultante.
			Unif unif = head.unifyArithmetic(types);
			NodeKind nodeResult = CALL_NODE;
			if (unif.type == LOGICAL_TYPE) {
				nodeResult = LOGICAL_VAL_NODE;
			} else if (unif.type == INTEGER_TYPE) {
				nodeResult = INTEGER_VAL_NODE;
			} else if (unif.type == DOUBLE_TYPE) {
				nodeResult = DOUBLE_VAL_NODE;
			}

			// Atualiza o tipo da variável
			if(var != null) {
				int idx = vt.lookupVar(var);
				if (idx != -1) {
					vt.updateTypeVar(idx, unif.type);
				} else {
					System.out.printf("SEMANTIC ERROR: variable '%s' was not declared.\n", var);
					System.exit(1);
				}
			}

			// Cria os nós de conversão que forem necessários segundo a estrutura de conversão.
			for (int i = 0; i < unif.c.size(); i++) {
				values.children.set(i, Conv.createConvNode(unif.c.get(i), values.getChild(i)));
			}

			// Olha qual é o operador e cria o nó correspondente na AST.
			return AST.newSubtree(nodeResult, ARRAY_TYPE, values);
		} else if((values.getChildSize() > 0) && ass.equals("list")) {
			// Atualiza o tipo da variável
			if(var != null) {
				int idx = vt.lookupVar(var);
				if (idx != -1) {
					vt.updateTypeVar(idx, LIST_TYPE);
				} else {
					System.out.printf("SEMANTIC ERROR: variable '%s' was not declared.\n", var);
					System.exit(1);
				}
			}

			return AST.newSubtree(LIST_VAL_NODE, NO_TYPE, fun, values);
		}
		return AST.newSubtree(CALL_NODE, NO_TYPE, fun, values);
	}

	@Override
	public AST visitExprID(RParser.ExprIDContext ctx) {
		return newVar(ctx.ID().getSymbol(), SYMBOL_TYPE);
	}

	@Override public AST visitExprif(RParser.ExprifContext ctx) {
		AST node = AST.newSubtree(IF_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprNaN(RParser.ExprNaNContext ctx) {
		return new AST(DOUBLE_VAL_NODE, Double.NaN, DOUBLE_TYPE);
	}

	@Override public AST visitExprEFormulaE(RParser.ExprEFormulaEContext ctx) {
		AST node = AST.newSubtree(FORMULA_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitExprlist(RParser.ExprlistContext ctx) {
		AST node = AST.newSubtree(EXPRLIST_NODE, NO_TYPE);
		for (int i = 0; i < ctx.expr().size(); i++) {
			AST child = visit(ctx.expr(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitFormlist(RParser.FormlistContext ctx) {
		AST node = AST.newSubtree(FORMLIST_NODE, NO_TYPE);
		for (int i = 0; i < ctx.form().size(); i++) {
			AST child = visit(ctx.form(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitSublist(RParser.SublistContext ctx) {
		AST node = AST.newSubtree(SUBLIST_NODE, NO_TYPE);
		for (int i = 0; i < ctx.sub().size(); i++) {
			AST child = visit(ctx.sub(i));
    		node.addChild(child);
    	}
		return node;
	}

	@Override public AST visitFormID(RParser.FormIDContext ctx) {
		return newVar(ctx.ID().getSymbol(), SYMBOL_TYPE);
	}

	@Override public AST visitFormAssign(RParser.FormAssignContext ctx) {
		AST node = AST.newSubtree(FORMASSIGN_NODE, NO_TYPE, visit(ctx.ID()), visit(ctx.expr()));
		return node;
	}

	@Override public AST visitFormVarags(RParser.FormVaragsContext ctx) {
		AST node = AST.newSubtree(VARARG_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitFormPoint(RParser.FormPointContext ctx) {
		AST node = AST.newSubtree(POINT_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitSubExpr(RParser.SubExprContext ctx) {
		return visit(ctx.expr());
	 }

	@Override public AST visitSubID(RParser.SubIDContext ctx) {
		return newVar(ctx.ID().getSymbol(), SYMBOL_TYPE);
	}

	@Override public AST visitSubAssignID(RParser.SubAssignIDContext ctx) {
		AST node = AST.newSubtree(SUBASSIGNID_NODE, NO_TYPE, visit(ctx.ID()), visit(ctx.expr()));
		return node;
	}

	@Override public AST visitSubSTRING(RParser.SubSTRINGContext ctx) {
		int idx = st.addStr(ctx.STRING().getText());
		return new AST(CHARACTER_VAL_NODE, idx, CHARACTER_TYPE);
	}

	@Override public AST visitSubAssignSTRING(RParser.SubAssignSTRINGContext ctx) {
		AST node = AST.newSubtree(SUBASSIGNCHARACTER_NODE, NO_TYPE, visit(ctx.STRING()), visit(ctx.expr()));
		return node;
	}

	@Override public AST visitSubNULL(RParser.SubNULLContext ctx) {
		return new AST(NULL_VAL_NODE, 0, NULL_TYPE);
	}

	@Override public AST visitSubAssignNULL(RParser.SubAssignNULLContext ctx) {
		AST node = AST.newSubtree(SUBASSIGNNULL_NODE, NO_TYPE, visit(ctx.expr()), new AST(NULL_VAL_NODE, 0, NULL_TYPE));
		return node;
	}

	@Override public AST visitSubVarags(RParser.SubVaragsContext ctx) {
		AST node = AST.newSubtree(VARARG_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitSubPoint(RParser.SubPointContext ctx) {
		AST node = AST.newSubtree(POINT_NODE, NO_TYPE);
		return node;
	}

	@Override public AST visitSubEmpty(RParser.SubEmptyContext ctx) {
		AST node = AST.newSubtree(EMPTY_NODE, NO_TYPE);
		return node;
	}

}