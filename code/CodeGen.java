package code;

import java.io.PrintWriter;
import java.io.IOException;

import static code.Instruction.INSTR_MEM_SIZE;

import static code.OpCode.ADD;
import static code.OpCode.ADDD;
import static code.OpCode.SUB;
import static code.OpCode.SUBD;
import static code.OpCode.MUL;
import static code.OpCode.MULD;
import static code.OpCode.DIV;
import static code.OpCode.DIVD;
import static code.OpCode.BIT_AND;
import static code.OpCode.BIT_OR;
import static code.OpCode.LW;
import static code.OpCode.LD;
import static code.OpCode.SW;
import static code.OpCode.SD;
import static code.OpCode.LA;
import static code.OpCode.LI;
import static code.OpCode.LD;
import static code.OpCode.MFHI;
import static code.OpCode.MFLO;
import static code.OpCode.MOVE;
import static code.OpCode.ASCII;
import static code.OpCode.WORD;
import static code.OpCode.DOUBLE;
import static code.OpCode.SYSCALL;

import static typing.Type.LOGICAL_TYPE;
import static typing.Type.INTEGER_TYPE;
import static typing.Type.DOUBLE_TYPE;

import ast.AST;
import ast.ASTBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;


public final class CodeGen extends ASTBaseVisitor<String> {

	private final Instruction code[]; // user program code
    private final Instruction text[]; // code section
    private final Instruction data[]; // data section

	private final StrTable st;
	private final VarTable vt;
	
	// Contadores para geração de código.
	// Próxima posição na memória de código para emit.
	private static int nextInstr;
    private static int nextText;
    private static int nextData;
	// Número de registradores temporários já utilizados.
	private static int valueRegsCount;
	private static int argRegsCount;
    private static int tempRegsCount;
    private static int floatRegsCount;
	
	public CodeGen(StrTable st, VarTable vt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
        this.text = new Instruction[INSTR_MEM_SIZE];
        this.data = new Instruction[INSTR_MEM_SIZE];
		this.st = st;
		this.vt = vt;
	}
	
	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
        nextText = 0;
        nextData = 0;
		valueRegsCount = 0;
		argRegsCount = 0;
        tempRegsCount = 0;
        floatRegsCount = 0;
	    visit(root);
        dumpProgram();
	}

    public void dump2File(String filename) {
        try
        {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");

            writer.println("# " + filename + " in MIPS assembly");
            writer.println(".data");
            for (int addr = 0; addr < nextData; addr++) {
                writer.println(String.format("\tpt_%d:\t%s", addr, data[addr].toString()));
            }
            writer.println();
            writer.println(".text");
            for (int addr = 0; addr < nextText; addr++) {
                writer.println(String.format("\t%s", text[addr].toString()));
            }
            writer.println();
            writer.println(".globl main");
            writer.println();
            writer.println("main:");
            for (int addr = 0; addr < nextInstr; addr++) {
                writer.println(String.format("\t%s", code[addr].toString()));
            }

            writer.close();
        }
        catch (IOException ex)  
        {
            System.out.printf("IO ERROR: file '%s' was wrong.\n", filename);
    		System.exit(1);
        }
    }

    private String str(int x) {
        return Integer.toString(x);
    }

    private String str(Double x) {
        return Double.toString(x);
    }


	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

	void dumpProgram() {
        System.out.println("\ndumping Program...");
        System.out.println(".data");
        for (int addr = 0; addr < nextData; addr++) {
            System.out.println(String.format("\tpt_%d:\t%s", addr, data[addr].toString()));
        }
        System.out.println();
        System.out.println(".text");
        for (int addr = 0; addr < nextText; addr++) {
            System.out.println(String.format("\t%s", text[addr].toString()));
        }
        System.out.println();
        System.out.println(".globl main");
        System.out.println();
        System.out.println("main:");
        for (int addr = 0; addr < nextInstr; addr++) {
            System.out.println(String.format("\t%s", code[addr].toString()));
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
		emit(op, null, null, null);
	}
	
	private void emit(OpCode op, String o1) {
		emit(op, o1, null, null);
	}
	
	private void emit(OpCode op, String o1, String o2) {
		emit(op, o1, o2, null);
    }

    // ----------------------------------------------------------------------------
	// Text -----------------------------------------------------------------------
	
	private void text(OpCode op, String o1, String o2, String o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    text[nextText] = instr;
	    nextText++;
	}

	private void text(OpCode op) {
		text(op, null, null, null);
	}

	private void text(OpCode op, String o1) {
		text(op, o1, null, null);
	}

	private void text(OpCode op, String o1, String o2) {
		text(op, o1, o2, null);
	}

    // ----------------------------------------------------------------------------
	// Data -----------------------------------------------------------------------
	
	private int data(OpCode op, String o1, String o2, String o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    data[nextData] = instr;
	    nextData++;
        return nextData-1;
	}

	private int data(OpCode op) {
		return data(op, null, null, null);
	}

	private int data(OpCode op, String o1) {
		return data(op, o1, null, null);
	}

	private int data(OpCode op, String o1, String o2) {
		return data(op, o1, o2, null);
	}

    // ----------------------------------------------------------------------------
	// Registers ------------------------------------------------------------------
	
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
        String s = String.format("$a%d", argRegsCount);
		argRegsCount++;
        return s;
	}

    private String newTempReg() { // Temporary variables
        String s = String.format("$t%d", tempRegsCount);
		tempRegsCount++;
        return s;
	}

    private String newFloatReg() { // Float variables
        String s = String.format("$f%d", floatRegsCount);
		floatRegsCount=floatRegsCount+2;
        return s;
	}

	// ----------------------------------------------------------------------------
	// AST Traversal --------------------------------------------------------------

    @Override
	protected String visitVarDecl(AST node) {
        return null;
    }

    @Override
	protected String visitVarUse(AST node) {
        return null;
    }

    @Override
	protected String visitProg(AST node) {
        System.out.println("Prog");

        String r = newValueReg();
    	for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}
        emit(LI, r, "10"); // Code for syscall: exit
        emit(SYSCALL);

        return null;
    }

    @Override
	protected String visitExprSubSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return null;
    }

    @Override
	protected String visitExprSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return null;
    }

    @Override
	protected String visitValuePkg(AST node) {
        return null;
    }

    @Override
	protected String visitExtract(AST node) {
        return null;
    }

    @Override
	protected String visitAssocRight(AST node) {
        return null;
    }

    @Override
	protected String visitSign(AST node) {
        return null;
    }

    @Override
	protected String visitNamespace(AST node) {
        return null;
    }

    @Override
	protected String visitWrappedin(AST node) {
        return null;
    }

    @Override
	protected String visitEq(AST node) {
        return null;
    }

    @Override
	protected String visitLt(AST node) {
        return null;
    }

    @Override
	protected String visitGt(AST node) {
        return null;
    }

    @Override
	protected String visitPlus(AST node) {
        String x = null;
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        if (node.getChild(0).type == INTEGER_TYPE) {
            x = newTempReg();
            emit(ADD, x, y, z);
            int pt = data(WORD, "0");
            emit(SW, x, String.format("pt_%d", pt));
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(ADDD, x, y, z);
            int pt = data(WORD, "0");
            emit(SD, x, String.format("pt_%d", pt));
        }

	    return x;
    }

    @Override
	protected String visitMinus(AST node) {
        String x = null;
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        if (node.getChild(0).type == INTEGER_TYPE) {
            x = newTempReg();
            emit(SUB, x, y, z);
            int pt = data(WORD, "0");
            emit(SW, x, String.format("pt_%d", pt));
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(SUBD, x, y, z);
            int pt = data(WORD, "0");
            emit(SD, x, String.format("pt_%d", pt));
        }

        return x;
    }

    @Override
	protected String visitTimes(AST node) {
        String x = null;
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        if (node.getChild(0).type == INTEGER_TYPE) {
            x = newTempReg();
            emit(MUL, y, z);
            int pt = data(WORD, "0");
            emit(SW, x, String.format("pt_%d", pt));

            String hi = newTempReg();
            String lo = newTempReg();
            emit(MFHI, hi);
            emit(MFLO, lo);
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(MULD, x, y, z);
            int pt = data(WORD, "0");
            emit(SD, x, String.format("pt_%d", pt));
        }

        return x;
    }

    @Override
	protected String visitOver(AST node) {
        String x = null;
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        if (node.getChild(0).type == INTEGER_TYPE) {
            x = newTempReg();
            emit(DIV, y, z);
            int pt = data(WORD, "0");
            //emit(SW, x, String.format("pt_%d", pt));

            String hi = newTempReg();
            String lo = newTempReg();
            emit(MFHI, hi);
            emit(MFLO, lo);
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(DIVD, x, y, z);
            int pt = data(WORD, "0");
            emit(SD, x, String.format("pt_%d", pt));
        }

        return x;
    }

    @Override
	protected String visitNot(AST node) {
        return null;
    }

    @Override
	protected String visitAnd(AST node) {
        return null;
    }

    @Override
	protected String visitOr(AST node) {
        return null;
    }

    @Override
	protected String visitNotFormula(AST node) {
        return null;
    }

    @Override
	protected String visitFormula(AST node) {
        return null;
    }

    @Override
	protected String visitAssign(AST node) {
        return null;
    }

    @Override
	protected String visitDefine(AST node) {
        return null;
    }

    @Override
	protected String visitCall(AST node) {
        System.out.println("Call");

        AST symbol = node.getChild(0);
		AST args = node.getChild(1);
        
        String fun = vt.getName(symbol.intData);
        if (fun.equals("print")) {
            emit(LI, getValueReg(0), "4");  // Code for syscall: print_string
        }
		String values = visit(args);
        emit(SYSCALL);

        return null;
    }

    @Override
    protected String visitCompound(AST node) {
        return null;
    }

    @Override
    protected String visitIf(AST node) {
        return null;
    }

    @Override
    protected String visitIfElse(AST node) {
        return null;
    }

    @Override
    protected String visitFor(AST node) {
        return null;
    }

    @Override
    protected String visitWhile(AST node) {
        return null;
    }

    @Override
    protected String visitRepeat(AST node) {
        return null;
    }

    @Override
    protected String visitHelp(AST node) {
        return null;
    }

    @Override
    protected String visitNext(AST node) {
        return null;
    }

    @Override
    protected String visitBreak(AST node) {
        return null;
    }

    @Override
    protected String visitPar(AST node) {
        return null;
    }

    @Override
    protected String visitId(AST node) {
        System.out.println("ID");
        System.out.println(node.type);
        return null;
    }

    @Override
    protected String visitNull(AST node) {
        return null;
    }

    @Override
    protected String visitLogical(AST node) {
        return null;
    }

    @Override
    protected String visitInteger(AST node) {
	    int c = node.intData;
        String x = newTempReg();
	    emit(LI, x, str(c));
	    return x;
    }

    @Override
    protected String visitDouble(AST node) {
        System.out.println("Double");

        Double c = node.doubleData;
        int pt = data(DOUBLE, str(c));
        String x = newFloatReg();
	    text(LD, x, String.format("pt_%d", pt));

	    return x;
    }

    @Override
    protected String visitComplex(AST node) {
        return null;
    }

    @Override
    protected String visitCharacter(AST node) {
        System.out.println("Character");

        int pt = data(ASCII, st.getName(node.intData));
        String x = newArgReg();
	    emit(LA, x, String.format("pt_%d", pt));

	    return x;
    }

    @Override
    protected String visitVararg(AST node) {
        return null;
    }

    @Override
    protected String visitPoint(AST node) {
        return null;
    }

    @Override
    protected String visitEmpty(AST node) {
        return null;
    }

    @Override
    protected String visitList(AST node) {
        return null;
    }

    @Override
    protected String visitSublist(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}

        return null;
    }

    @Override
    protected String visitExprList(AST node) {
        return null;
    }

    @Override
    protected String visitFormList(AST node) {
        return null;
    }

    @Override
    protected String visitFormAssign(AST node) {
        return null;
    }

    @Override
    protected String visitSubExpr(AST node) {
        return null;
    }

    @Override
    protected String visitSubAssign(AST node) {
        return null;
    }

    @Override
    protected String visitSubAssignCharacter(AST node) {
        return null;
    }

    @Override
    protected String visitSubAssignNull(AST node) {
        return null;
    }

    @Override
    protected String visitL2I(AST node) {
        return null;
    }

    @Override
    protected String visitL2D(AST node) {
        return null;
    }

    @Override
    protected String visitI2D(AST node) {
        return null;
    }

    @Override
    protected String visitI2L(AST node) {
        return null;
    }

    @Override
    protected String visitD2L(AST node) {
        return null;
    }

}
