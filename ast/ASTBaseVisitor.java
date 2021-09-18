package ast;

public abstract class ASTBaseVisitor<T> {

	public void execute(AST root) {
		visit(root);
	}
	
	protected T visit(AST node) {
		switch(node.kind) {

            case VAR_DECL_NODE:             return visitVarDecl(node);
            case VAR_USE_NODE:              return visitVarUse(node);

            case PROG_NODE:                 return visitProg(node);
            case EXPRSUBSUBLIST_NODE:       return visitExprSubSublist(node);
            case EXPRSUBLIST_NODE:          return visitExprSublist(node);
            case VALUEPKG_NODE:             return visitValuePkg(node);
            case EXTRACT_NODE:              return visitExtract(node);
            case ASSOCRIGHT_NODE:           return visitAssocRight(node);
            case SIGN_NODE:                 return visitSign(node);
            case NAMESPACE_NODE:            return visitNamespace(node);
            case WRAPPEDIN_NODE:            return visitWrappedin(node);
            case EQ_NODE:                   return visitEq(node);
            case LT_NODE:                   return visitLt(node);
            case GT_NODE:                   return visitGt(node);
            case PLUS_NODE:                 return visitPlus(node);
            case MINUS_NODE:                return visitMinus(node);
            case TIMES_NODE:                return visitTimes(node);
            case OVER_NODE:                 return visitOver(node);
            case NOT_NODE:                  return visitNot(node);
            case AND_NODE:                  return visitAnd(node);
            case OR_NODE:                   return visitOr(node);
            case NOTFORMULA_NODE:           return visitNotFormula(node);
            case FORMULA_NODE:              return visitFormula(node);
            case ASSIGN_NODE:               return visitAssign(node);
            case DEFINE_NODE:               return visitDefine(node);
            case CALL_NODE:                 return visitCall(node);
            case COMPOUND_NODE:             return visitCompound(node);
            case IF_NODE:                   return visitIf(node);
            case IFELSE_NODE:               return visitIfElse(node);
            case FOR_NODE:                  return visitFor(node);
            case WHILE_NODE:                return visitWhile(node);
            case REPEAT_NODE:               return visitRepeat(node);
            case HELP_NODE:                 return visitHelp(node);
            case NEXT_NODE:                 return visitNext(node);
            case BREAK_NODE:                return visitBreak(node);
            case PAR_NODE:                  return visitPar(node);
            case ID_NODE:                   return visitId(node);
            case NULL_VAL_NODE:             return visitNull(node);
            case LOGICAL_VAL_NODE:          return visitLogical(node);
            case INTEGER_VAL_NODE:          return visitInteger(node);
            case DOUBLE_VAL_NODE:           return visitDouble(node);
            case COMPLEX_VAL_NODE:          return visitComplex(node);
            case CHARACTER_VAL_NODE:        return visitCharacter(node);
            case VARARG_NODE:               return visitVararg(node);
            case POINT_NODE:                return visitPoint(node);
            case EMPTY_NODE:                return visitEmpty(node);
            case LIST_VAL_NODE:             return visitList(node);
            case SUBLIST_NODE:              return visitSublist(node);
            case EXPRLIST_NODE:             return visitExprList(node);
            case FORMLIST_NODE:             return visitFormList(node);
            case FORMASSIGN_NODE:           return visitFormAssign(node);
            case SUBEXPR_NODE:              return visitSubExpr(node);
            case SUBASSIGNID_NODE:          return visitSubAssign(node);
            case SUBASSIGNCHARACTER_NODE:   return visitSubAssignCharacter(node);
            case SUBASSIGNNULL_NODE:        return visitSubAssignNull(node);

            case L2I_NODE:                  return visitL2I(node);
            case L2D_NODE:                  return visitL2D(node);
            case I2D_NODE:                  return visitI2D(node);
            case I2L_NODE:                  return visitI2L(node);
            case D2L_NODE:                  return visitD2L(node);
	
	        default:
	            System.err.printf("Invalid kind: %s!\n", node.kind.toString());
	            System.exit(1);
	            return null;
		}
	}
	
	// Métodos especializados para visitar um nó com um certo 'kind'.

	protected abstract T visitVarDecl(AST node);

	protected abstract T visitVarUse(AST node);

	protected abstract T visitProg(AST node);

	protected abstract T visitExprSubSublist(AST node);

	protected abstract T visitExprSublist(AST node);

	protected abstract T visitValuePkg(AST node);

	protected abstract T visitExtract(AST node);

	protected abstract T visitAssocRight(AST node);

	protected abstract T visitSign(AST node);

	protected abstract T visitNamespace(AST node);

	protected abstract T visitWrappedin(AST node);

	protected abstract T visitEq(AST node);

	protected abstract T visitLt(AST node);

	protected abstract T visitGt(AST node);

	protected abstract T visitPlus(AST node);

	protected abstract T visitMinus(AST node);

	protected abstract T visitTimes(AST node);

	protected abstract T visitOver(AST node);

	protected abstract T visitNot(AST node);

	protected abstract T visitAnd(AST node);

	protected abstract T visitOr(AST node);

	protected abstract T visitNotFormula(AST node);

	protected abstract T visitFormula(AST node);

	protected abstract T visitAssign(AST node);

	protected abstract T visitDefine(AST node);

	protected abstract T visitCall(AST node);

    protected abstract T visitCompound(AST node);

    protected abstract T visitIf(AST node);

    protected abstract T visitIfElse(AST node);

    protected abstract T visitFor(AST node);

    protected abstract T visitWhile(AST node);

    protected abstract T visitRepeat(AST node);

    protected abstract T visitHelp(AST node);

    protected abstract T visitNext(AST node);

    protected abstract T visitBreak(AST node);

    protected abstract T visitPar(AST node);

    protected abstract T visitId(AST node);

    protected abstract T visitNull(AST node);

    protected abstract T visitLogical(AST node);

    protected abstract T visitInteger(AST node);

    protected abstract T visitDouble(AST node);

    protected abstract T visitComplex(AST node);

    protected abstract T visitCharacter(AST node);

    protected abstract T visitVararg(AST node);

    protected abstract T visitPoint(AST node);

    protected abstract T visitEmpty(AST node);

    protected abstract T visitList(AST node);

    protected abstract T visitSublist(AST node);

    protected abstract T visitExprList(AST node);

    protected abstract T visitFormList(AST node);

    protected abstract T visitFormAssign(AST node);

    protected abstract T visitSubExpr(AST node);

    protected abstract T visitSubAssign(AST node);

    protected abstract T visitSubAssignCharacter(AST node);

    protected abstract T visitSubAssignNull(AST node);

    protected abstract T visitL2I(AST node);

    protected abstract T visitL2D(AST node);

    protected abstract T visitI2D(AST node);

    protected abstract T visitI2L(AST node);

    protected abstract T visitD2L(AST node);

}
