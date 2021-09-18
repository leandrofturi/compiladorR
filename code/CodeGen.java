package code;

import static code.Instruction.INSTR_MEM_SIZE;

import static code.OpCode.SYSCALL;
import static code.OpCode.LI;
import static code.OpCode.LA;
import static code.OpCode.ASCII;

import static typing.Type.LOGICAL_TYPE;
import static typing.Type.INTEGER_TYPE;
import static typing.Type.DOUBLE_TYPE;

import ast.AST;
import ast.ASTBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;


public final class CodeGen extends ASTBaseVisitor<Integer> {

	private final Instruction code[]; // user program code
    private final Instruction pointer[]; // pointers

	private final StrTable st;
	private final VarTable vt;
	
	// Contadores para geração de código.
	// Próxima posição na memória de código para emit.
	private static int nextInstr;
    private static int nextPointer;
	// Número de registradores temporários já utilizados.
	private static int valueRegsCount;
	private static int argRegsCount;
	
	public CodeGen(StrTable st, VarTable vt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
        this.pointer = new Instruction[INSTR_MEM_SIZE];
		this.st = st;
		this.vt = vt;
	}
	
	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
        nextPointer = 0;
		valueRegsCount = 0;
		argRegsCount = 0;
	    visit(root);
	    dumpProgram();
	}


	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

	void dumpProgram() {
        System.out.println("\ndumping Program...");
	    for (int addr = 0; addr < nextInstr; addr++) {
	    	System.out.printf("%s\n", code[addr].toString());
	    }
        System.out.println();
        for (int addr = 0; addr < nextPointer; addr++) {
	    	System.out.printf("pt_%d: %s\n", addr, pointer[addr].toString());
	    }
	}

	// ----------------------------------------------------------------------------
	// Emits ----------------------------------------------------------------------

	private void emit(OpCode op, String o1, String o2, String o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    code[nextInstr] = instr;
	    nextInstr++;
	}

    private void emit(OpCode op) {
		emit(op, "", "", "");
	}
	
	private void emit(OpCode op, String o1) {
		emit(op, o1, "", "");
	}
	
	private void emit(OpCode op, String o1, String o2) {
		emit(op, o1, o2, "");
    }

    // ----------------------------------------------------------------------------
	// Pointers -------------------------------------------------------------------
	
	private int pointer(OpCode op, String o1, String o2, String o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    pointer[nextPointer] = instr;
	    nextPointer++;
        return nextPointer-1;
	}

	private int pointer(OpCode op) {
		return pointer(op, "", "", "");
	}

	private int pointer(OpCode op, String o1) {
		return pointer(op, o1, "", "");
	}

	private int pointer(OpCode op, String o1, String o2) {
		return pointer(op, o1, o2, "");
	}

    // ----------------------------------------------------------------------------
	// Registers ____--------------------------------------------------------------
	
	private String newValueReg() { // (values) from expression evaluation and function results
        String s = String.format("$v%d", valueRegsCount);
		valueRegsCount++;
        return s;
	}

    private String getValueReg(int i) {
        String s = String.format("$v%d", i);
        return s;
	}
    
	private String newArgReg() { // (arguments) First four parameters for subroutine
        String s = String.format("$a%d", valueRegsCount);
		argRegsCount++;
        return s;
	}

	// ----------------------------------------------------------------------------
	// AST Traversal --------------------------------------------------------------

    @Override
	protected Integer visitVarDecl(AST node) {
        return -1;
    }

    @Override
	protected Integer visitVarUse(AST node) {
        return -1;
    }

    @Override
	protected Integer visitProg(AST node) {
        System.out.println("Prog");

    	for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}
        emit(LI, getValueReg(0), "10"); // Code for syscall: exit
        emit(SYSCALL);

        return -1;
    }

    @Override
	protected Integer visitExprSubSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return -1;
    }

    @Override
	protected Integer visitExprSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return -1;
    }

    @Override
	protected Integer visitValuePkg(AST node) {
        return -1;
    }

    @Override
	protected Integer visitExtract(AST node) {
        return -1;
    }

    @Override
	protected Integer visitAssocRight(AST node) {
        return -1;
    }

    @Override
	protected Integer visitSign(AST node) {
        return -1;
    }

    @Override
	protected Integer visitNamespace(AST node) {
        return -1;
    }

    @Override
	protected Integer visitWrappedin(AST node) {
        return -1;
    }

    @Override
	protected Integer visitEq(AST node) {
        return -1;
    }

    @Override
	protected Integer visitLt(AST node) {
        return -1;
    }

    @Override
	protected Integer visitGt(AST node) {
        return -1;
    }

    @Override
	protected Integer visitPlus(AST node) {
        return -1;
    }

    @Override
	protected Integer visitMinus(AST node) {
        return -1;
    }

    @Override
	protected Integer visitTimes(AST node) {
        return -1;
    }

    @Override
	protected Integer visitOver(AST node) {
        return -1;
    }

    @Override
	protected Integer visitNot(AST node) {
        return -1;
    }

    @Override
	protected Integer visitAnd(AST node) {
        return -1;
    }

    @Override
	protected Integer visitOr(AST node) {
        return -1;
    }

    @Override
	protected Integer visitNotFormula(AST node) {
        return -1;
    }

    @Override
	protected Integer visitFormula(AST node) {
        return -1;
    }

    @Override
	protected Integer visitAssign(AST node) {
        return -1;
    }

    @Override
	protected Integer visitDefine(AST node) {
        return -1;
    }

    @Override
	protected Integer visitCall(AST node) {
        System.out.println("Call");

        AST symbol = node.getChild(0);
		AST args = node.getChild(1);
        
        String fun = vt.getName(symbol.intData);
        if (fun.equals("print")) {
            emit(LI, newValueReg(), "4");  // Code for syscall: print_string
        }
		int values = visit(args);
        emit(SYSCALL);

        return -1;
    }

    @Override
    protected Integer visitCompound(AST node) {
        return -1;
    }

    @Override
    protected Integer visitIf(AST node) {
        return -1;
    }

    @Override
    protected Integer visitIfElse(AST node) {
        return -1;
    }

    @Override
    protected Integer visitFor(AST node) {
        return -1;
    }

    @Override
    protected Integer visitWhile(AST node) {
        return -1;
    }

    @Override
    protected Integer visitRepeat(AST node) {
        return -1;
    }

    @Override
    protected Integer visitHelp(AST node) {
        return -1;
    }

    @Override
    protected Integer visitNext(AST node) {
        return -1;
    }

    @Override
    protected Integer visitBreak(AST node) {
        return -1;
    }

    @Override
    protected Integer visitPar(AST node) {
        return -1;
    }

    @Override
    protected Integer visitId(AST node) {
        System.out.println("ID");
        System.out.println(node.type);
        return -1;
    }

    @Override
    protected Integer visitNull(AST node) {
        return -1;
    }

    @Override
    protected Integer visitLogical(AST node) {
        return -1;
    }

    @Override
    protected Integer visitInteger(AST node) {
        return -1;
    }

    @Override
    protected Integer visitDouble(AST node) {
        return -1;
    }

    @Override
    protected Integer visitComplex(AST node) {
        return -1;
    }

    @Override
    protected Integer visitCharacter(AST node) {
        System.out.println("Character");

        int pt = pointer(ASCII, st.getName(node.intData));
	    emit(LA, newArgReg(), String.format("pt_%d", pt));

	    return argRegsCount-1;
    }

    @Override
    protected Integer visitVararg(AST node) {
        return -1;
    }

    @Override
    protected Integer visitPoint(AST node) {
        return -1;
    }

    @Override
    protected Integer visitEmpty(AST node) {
        return -1;
    }

    @Override
    protected Integer visitList(AST node) {
        return -1;
    }

    @Override
    protected Integer visitSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return -1;
    }

    @Override
    protected Integer visitExprList(AST node) {
        return -1;
    }

    @Override
    protected Integer visitFormList(AST node) {
        return -1;
    }

    @Override
    protected Integer visitFormAssign(AST node) {
        return -1;
    }

    @Override
    protected Integer visitSubExpr(AST node) {
        return -1;
    }

    @Override
    protected Integer visitSubAssign(AST node) {
        return -1;
    }

    @Override
    protected Integer visitSubAssignCharacter(AST node) {
        return -1;
    }

    @Override
    protected Integer visitSubAssignNull(AST node) {
        return -1;
    }

    @Override
    protected Integer visitL2I(AST node) {
        return -1;
    }

    @Override
    protected Integer visitL2D(AST node) {
        return -1;
    }

    @Override
    protected Integer visitI2D(AST node) {
        return -1;
    }

    @Override
    protected Integer visitI2L(AST node) {
        return -1;
    }

    @Override
    protected Integer visitD2L(AST node) {
        return -1;
    }

}
