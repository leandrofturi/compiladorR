package checker;

import org.antlr.v4.runtime.Token;

import parser.RParser;
import parser.RParser.ExprContext;
//import parser.RParser.Assign_stmtContext;
//import parser.RParser.ExprIdContext;
//import parser.RParser.ExprStrValContext;
//import parser.RParser.Read_stmtContext;
import parser.RBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;

/*
 * Analisador semântico de EZLang implementado como um visitor
 * da ParseTree do ANTLR. A classe EZParserBaseVisitor é gerada
 * automaticamente e já possui métodos padrão aonde o comportamento
 * é só visitar todos os filhos. Por conta disto, basta sobreescrever
 * os métodos que a gente quer alterar.
 * 
 * Por enquanto só há uma verificação simples de declaração de
 * variáveis usando uma tabela de símbolos. Funcionalidades adicionais
 * como análise de tipos serão incluídas no próximo laboratório.
 * 
 * O tipo Void indicado na super classe define o valor de retorno dos
 * métodos do visitador. Depois vamos alterar isso para poder construir
 * a AST.
 * 
 * Lembre que em um 'visitor' você é responsável por definir o
 * caminhamento nos filhos de um nó da ParseTree através da chamada
 * recursiva da função 'visit'. Ao contrário do 'listener' que
 * caminha automaticamente em profundidade pela ParseTree, se
 * você não chamar 'visit' nos métodos de visitação, o caminhamento
 * para no nó que você estiver, deixando toda a subárvore do nó atual
 * sem visitar. Tome cuidado neste ponto pois isto é uma fonte
 * muito comum de erros. Veja o método visitAssign_stmt abaixo para
 * ter um exemplo.
 */
public class SemanticChecker extends RBaseVisitor<Void> {

	private StrTable st = new StrTable();   // Tabela de strings.
    private VarTable vt = new VarTable();   // Tabela de variáveis.
    
    private boolean passed = true;

	private boolean assigned = false;		// Indica que um assign está ocorrendo.
	private Token currentID;				// Atual variável declarada.

    // Testa se o dado token foi declarado antes.
    void checkVar(Token token) {
    	String text = token.getText();
    	int line = token.getLine();
   		int idx = vt.lookupVar(text);
    	if (idx == -1) {
    		System.err.printf(
    			"SEMANTIC ERROR (%d): variable '%s' was not declared.\n",
				line, text);
    		passed = false;
            return;
        }
    }

    // Cria uma nova variável a partir do dado token.
    void newVar(Token token, Type type) {
    	String text = token.getText();
    	int line = token.getLine();
   		int idx = vt.lookupVar(text);
        if (idx != -1) {
			// Caso já exista, atualiza o tipo
			vt.updateTypeVar(idx, type);
            return;
        }
        vt.addVar(text, line, type);
    }

    // Retorna true se os testes passaram.
    boolean hasPassed() {
    	return passed;
    }

    // Exibe o conteúdo das tabelas em stdout.
    void printTables() {
        System.out.print("\n\n");
        System.out.print(st);
        System.out.print("\n\n");
    	System.out.print(vt);
    	System.out.print("\n\n");
    }


	@Override public Void visitProg(RParser.ProgContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprNotFormula(RParser.ExprNotFormulaContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprINT(RParser.ExprINTContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.INTEGER_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprNA(RParser.ExprNAContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LOGICAL_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprValuePkg(RParser.ExprValuePkgContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprPexprP(RParser.ExprPexprPContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprbreak(RParser.ExprbreakContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprWrappedin(RParser.ExprWrappedinContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprSubsublist(RParser.ExprSubsublistContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprExtract(RParser.ExprExtractContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprCompound(RParser.ExprCompoundContext ctx) { return visitChildren(ctx); }

	@Override
	public Void visitExprSTRING(RParser.ExprSTRINGContext ctx) {
		// Adiciona a string na tabela de strings.
		st.add(ctx.STRING().getText());
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.CHARACTER_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override
	public Void visitExprAssign(RParser.ExprAssignContext ctx) {
		// Sinaliza que um assign ocorreu.
		assigned = true;
		return visitChildren(ctx);
	}

	@Override public Void visitExprTRUE(RParser.ExprTRUEContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LOGICAL_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprfor(RParser.ExprforContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprwhile(RParser.ExprwhileContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprOr(RParser.ExprOrContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprInf(RParser.ExprInfContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.DOUBLE_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprAnd(RParser.ExprAndContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprifelse(RParser.ExprifelseContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprHEX(RParser.ExprHEXContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.DOUBLE_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprSign(RParser.ExprSignContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprHelp(RParser.ExprHelpContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprAssocRight(RParser.ExprAssocRightContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprNot(RParser.ExprNotContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprFALSE(RParser.ExprFALSEContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LOGICAL_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprSublist(RParser.ExprSublistContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LIST_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprNamespace(RParser.ExprNamespaceContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprEquality(RParser.ExprEqualityContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprFLOAT(RParser.ExprFLOATContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.DOUBLE_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprCOMPLEX(RParser.ExprCOMPLEXContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.COMPLEX_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprSum(RParser.ExprSumContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprDefine(RParser.ExprDefineContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprNULL(RParser.ExprNULLContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.NULL_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprTimes(RParser.ExprTimesContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprrepeat(RParser.ExprrepeatContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprnext(RParser.ExprnextContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprCall(RParser.ExprCallContext ctx) { return visitChildren(ctx); }

	@Override
	public Void visitExprID(RParser.ExprIDContext ctx) {
    	// Salva o ID corrente
		currentID = ctx.ID().getSymbol();
    	return visitChildren(ctx);
	}

	@Override public Void visitExprif(RParser.ExprifContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprNaN(RParser.ExprNaNContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.DOUBLE_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitExprEFormulaE(RParser.ExprEFormulaEContext ctx) { return visitChildren(ctx); }

	@Override public Void visitExprlist(RParser.ExprlistContext ctx) { return visitChildren(ctx); }

	@Override public Void visitFormlist(RParser.FormlistContext ctx) { return visitChildren(ctx); }

	@Override public Void visitForm(RParser.FormContext ctx) { return visitChildren(ctx); }

	@Override public Void visitSublist(RParser.SublistContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LIST_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

	@Override public Void visitSub(RParser.SubContext ctx) {
		if(assigned) {
			// Adiciona o ID corrente à tabela de variáveis.
    		newVar(currentID, Type.LIST_TYPE);
			assigned = false;
		}
		return visitChildren(ctx);
	}

}
