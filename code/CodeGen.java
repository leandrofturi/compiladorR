package code;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

import static code.Instruction.INSTR_MEM_SIZE;

import static code.OpCode.ADD;
import static code.OpCode.ADDI;
import static code.OpCode.ADDD;
import static code.OpCode.SUB;
import static code.OpCode.SUBD;
import static code.OpCode.MUL;
import static code.OpCode.MULD;
import static code.OpCode.DIV;
import static code.OpCode.DIVD;
import static code.OpCode.AND;
import static code.OpCode.OR;
import static code.OpCode.NOT;
import static code.OpCode.SEQ;
import static code.OpCode.SGE;
import static code.OpCode.SGT;
import static code.OpCode.SLE;
import static code.OpCode.SLT;
import static code.OpCode.SNE;
import static code.OpCode.LW;
import static code.OpCode.LW3;
import static code.OpCode.LD;
import static code.OpCode.SW;
import static code.OpCode.SW3;
import static code.OpCode.SD;
import static code.OpCode.LA;
import static code.OpCode.LI;
import static code.OpCode.LD;
import static code.OpCode.MFHI;
import static code.OpCode.MFLO;
import static code.OpCode.MOVE;
import static code.OpCode.BEQ;
import static code.OpCode.BNE;
import static code.OpCode.BGT;
import static code.OpCode.BGE;
import static code.OpCode.BLT;
import static code.OpCode.BLE;
import static code.OpCode.J;
import static code.OpCode.JR;
import static code.OpCode.JAL;
import static code.OpCode.SYSCALL;
import static code.OpCode.NL;

import static typing.Type.LOGICAL_TYPE;
import static typing.Type.INTEGER_TYPE;
import static typing.Type.DOUBLE_TYPE;
import static typing.Type.ARRAY_TYPE;

import ast.AST;
import ast.ASTBaseVisitor;
import ast.NodeKind;
import tables.StrTable;
import tables.VarTable;
import typing.Type;


public final class CodeGen extends ASTBaseVisitor<String> {

	private final Instruction code[]; // code section
    private final Instruction text[]; // text section
    private final Data data[]; // data section
    private final Instruction functions[]; // functions dclaration

    // variables in use
    private final HashMap<String, String> vars;

    // stack function
    private final Stack<String> fun;
    private final Stack<ArrayList<String>> params;

	private final StrTable st;
	private final VarTable vt;
	
	// Contadores para geração de código.
	// Próxima posição na memória de código para emit.
	private static int nextInstr;
    private static int nextText;
    private static int nextData;
    private static int nextFunc;
	// Número de registradores temporários já utilizados.
	private static int valueRegsCount;
	private static int argRegsCount;
    private static int tempRegsCount;
    private static int floatRegsCount;
    private static int SRegsCount;
    // labels
    private static int labelsCount;

    private static boolean isCode;
	
	public CodeGen(StrTable st, VarTable vt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
        this.text = new Instruction[INSTR_MEM_SIZE];
        this.data = new Data[INSTR_MEM_SIZE];
        this.vars = new HashMap<String, String>();
        this.functions = new Instruction[INSTR_MEM_SIZE];
        this.fun = new Stack<String>();
        this.params = new Stack<ArrayList<String>>();
		this.st = st;
		this.vt = vt;
	}
	
	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
        nextText = 0;
        nextData = 0;
        nextFunc = 0;
		valueRegsCount = 0;
		argRegsCount = 0;
        tempRegsCount = 0;
        floatRegsCount = 0;
        SRegsCount = 0;
        labelsCount = 0;
        isCode = true;
	    visit(root);
        dumpProgram();
	}

    private String str(int x) {
        return Integer.toString(x);
    }

    private String str(Double x) {
        return Double.toString(x);
    }


	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

    public void dump2File(String filename) {
        try
        {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");

            writer.println("# " + filename + " in MIPS assembly");
            writer.println(".data");
            for (int addr = 0; addr < nextData; addr++) {
                writer.println(String.format("\t%s", data[addr].toString()));
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
            writer.println();
            if (nextFunc > 0) {
                writer.println("# Functions");
                for (int addr = 0; addr < nextFunc; addr++) {
                    writer.println(String.format("\t%s", functions[addr].toString()));
                }
            }

            writer.close();
        }
        catch (IOException ex)  
        {
            System.out.printf("IO ERROR: file '%s' was wrong.\n", filename);
    		System.exit(1);
        }
    }

	void dumpProgram() {
        System.out.println("\ndumping Program...");
        System.out.println(".data");
        for (int addr = 0; addr < nextData; addr++) {
            System.out.println(String.format("\t%s", data[addr].toString()));
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
        if (nextFunc > 0) {
            System.out.println();
            System.out.println("# Functions");
            for (int addr = 0; addr < nextFunc; addr++) {
                System.out.println(String.format("\t%s", functions[addr].toString()));
            }
        }
        System.out.println();
    }

    // ----------------------------------------------------------------------------
	// Labels ---------------------------------------------------------------------

    private String generateLabel() {
        labelsCount++;
        return String.format("label_%d", labelsCount);
    }

    private String generateLabel(String label) {
        labelsCount++;
        return String.format("%s_%d", label, labelsCount);
    }

	// ----------------------------------------------------------------------------
	// Emits ----------------------------------------------------------------------

	private void emit(OpCode op, String o1, String o2, String o3) {
        Instruction instr = new Instruction(op, o1, o2, o3);
        if (isCode) {
	        code[nextInstr] = instr;
	        nextInstr++;
        } else {
	        functions[nextFunc] = instr;
	        nextFunc++;
        }
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

    private void emit(String label, OpCode op, String o1, String o2, String o3) {
		Instruction instr = new Instruction(label, op, o1, o2, o3);
        if (isCode) {
	        code[nextInstr] = instr;
	        nextInstr++;
        } else {
	        functions[nextFunc] = instr;
	        nextFunc++;
        }
	}

    private void emit(String label, OpCode op) {
		emit(label, op, null, null, null);
	}
	
	private void emit(String label, OpCode op, String o1) {
		emit(label, op, o1, null, null);
	}
	
	private void emit(String label, OpCode op, String o1, String o2) {
		emit(label, op, o1, o2, null);
    }

    // ----------------------------------------------------------------------------
	// Text -----------------------------------------------------------------------

	private void text(OpCode op, String o1, String o2) {
        Instruction instr = new Instruction(op, o1, o2, null);
	    text[nextText] = instr;
	    nextText++;
	}

    // ----------------------------------------------------------------------------
	// Data -----------------------------------------------------------------------
	
    private int data(String label, String directive, ArrayList<String> datum) {
		Data instr = new Data(label, directive, datum);
	    data[nextData] = instr;
	    nextData++;
        return nextData-1;
	}

    private int data(String label, String directive, String datum) {
		Data instr = new Data(label, directive, datum);
	    data[nextData] = instr;
	    nextData++;
        return nextData-1;
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
		floatRegsCount = floatRegsCount+2;
        return s;
	}

    private String newSReg() { // Float variables
        String s = String.format("$s%d", SRegsCount);
		SRegsCount++;
        return s;
	}

	// ----------------------------------------------------------------------------
	// AST Traversal --------------------------------------------------------------

    @Override
	protected String visitVarDecl(AST node) {
        String var_name = vt.getName(node.intData);
        if (vars.get(var_name) == null) {
            String reg = newSReg();
            vars.put(var_name, reg);
            data(var_name, ".word", "0");
        }
        return vars.get(var_name);
    }

    @Override
	protected String visitVarUse(AST node) {
        return vars.get(vt.getName(node.intData));
    }

    @Override
	protected String visitProg(AST node) {
        String r = newValueReg();
    	for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}
        emit(NL);
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
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SEQ, x, y, z);
        return x;
    }

    @Override
	protected String visitNeq(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SNE, x, y, z);
        return x;
    }

    @Override
	protected String visitLt(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SLT, x, y, z);
        return x;
    }

    @Override
	protected String visitLet(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SLE, x, y, z);
        return x;
    }

    @Override
	protected String visitGt(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SGT, x, y, z);
        return x;
    }

    @Override
	protected String visitGet(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(SGE, x, y, z);
        return x;
    }

    @Override
	protected String visitPlus(AST node) {
        String x = null;
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        if (node.getChild(0).type == INTEGER_TYPE) {
            x = newTempReg();
            emit(ADD, x, y, z);
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(ADDD, x, y, z);
        }
        else if (node.getChild(0).kind == NodeKind.VAR_DECL_NODE) {
            AST var = node.getChild(0);
            x = vars.get(vt.getName(var.intData));
            if (vt.getType(var.intData) == INTEGER_TYPE) {
                emit(ADD, x, y, z);
            } else if (vt.getType(var.intData) == DOUBLE_TYPE) {
                emit(ADDD, x, y, z);
            }
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
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(SUBD, x, y, z);
        }
        else if (node.getChild(0).kind == NodeKind.VAR_DECL_NODE) {
            AST var = node.getChild(0);
            x = vars.get(vt.getName(var.intData));
            if (vt.getType(var.intData) == INTEGER_TYPE) {
                emit(SUB, x, y, z);
            } else if (vt.getType(var.intData) == DOUBLE_TYPE) {
                emit(SUBD, x, y, z);
            }
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

            String hi = newTempReg();
            String lo = newTempReg();
            emit(MFHI, hi);
            emit(MFLO, lo);
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(MULD, x, y, z);
        }
        else if (node.getChild(0).kind == NodeKind.VAR_DECL_NODE) {
            AST var = node.getChild(0);
            x = vars.get(vt.getName(var.intData));
            if (vt.getType(var.intData) == INTEGER_TYPE) {
                emit(MUL, x, y, z);

                String hi = newTempReg();
                String lo = newTempReg();
                emit(MFHI, hi);
                emit(MFLO, lo);

            } else if (vt.getType(var.intData) == DOUBLE_TYPE) {
                emit(MULD, x, y, z);
            }
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

            String hi = newTempReg();
            String lo = newTempReg();
            emit(MFHI, hi);
            emit(MFLO, lo);
        }
	    else if (node.getChild(0).type == DOUBLE_TYPE) {
            x = newFloatReg();
            emit(DIVD, x, y, z);
        }
        else if (node.getChild(0).kind == NodeKind.VAR_DECL_NODE) {
            AST var = node.getChild(0);
            x = vars.get(vt.getName(var.intData));
            if (vt.getType(var.intData) == INTEGER_TYPE) {
                emit(DIV, x, y, z);

                String hi = newTempReg();
                String lo = newTempReg();
                emit(MFHI, hi);
                emit(MFLO, lo);

            } else if (vt.getType(var.intData) == DOUBLE_TYPE) {
                emit(DIVD, x, y, z);
            }
        }
        return x;
    }

    @Override
	protected String visitNot(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));

        emit(NOT, x, y);
        return x;
    }

    @Override
	protected String visitAnd(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(AND, x, y, z);
        return x;
    }

    @Override
	protected String visitOr(AST node) {
        String x = newTempReg();
	    String y = visit(node.getChild(0));
	    String z = visit(node.getChild(1));

        emit(OR, x, y, z);
        return x;
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
        AST var = node.getChild(0);
        AST val = node.getChild(1);
        String values;

        String var_name = vt.getName(var.intData);
        if (vars.containsKey(var_name)) {
            values = visit(val);
            return vars.get(var_name);
        } else {
            if (val.kind == NodeKind.DEFINE_NODE) {
                fun.push(var_name);
                values = visit(val);
                return var_name;
            } else {
                values = visit(val);
                vars.put(var_name, values);
                emit(SW, values, var_name);
                data(var_name, ".word", "0");
                return values;
            }
        }
    }

    @Override
	protected String visitDefine(AST node) {
        String param;

        isCode = false;

        String label = fun.peek();
        emit(label, NL);
        AST args = node.getChild(0);
        AST fun = node.getChild(1);

        // This function overwrites $s0 and $s1
	    // We should save those on the stack
	    // This is PUSH'ing onto the stack
        ArrayList<String> paramss = new ArrayList<String>();
        for (int i = 0; i < args.getChildSize(); i++) {
            param = visit(args.getChild(i));
    		paramss.add(param);
            emit(ADDI, "$sp", "$sp", str(-4)); // Adjust stack pointer
            emit(SW3, param, str(0), "$sp"); // Save
    	}
        params.push(paramss);
        emit(NL);
        String result = visit(fun);
        if (result != null) {
            emit(MOVE, "$v0", result); // Save the return value in $v0
        }
        emit(NL);
        // Restore saved register values from stack in opposite order
	    // This is POP'ing from the stack
        for (int i = args.getChildSize()-1; i > 0; i--) {
            param = paramss.get(i);
            emit(LW3, param, str(0), "$sp"); // Restore
            emit(ADDI, "$sp", "$sp", str(4)); // Adjust stack pointer
    	}
        emit(NL);
        emit(JR, "$ra");

        isCode = true;

        return null;
    }

    @Override
	protected String visitCall(AST node) {
        AST symbol = node.getChild(0);
		AST args = node.getChild(1);
        ArrayList<String> paramss;
        
        String func = vt.getName(symbol.intData);
        String values = visit(args);

        if (func.equals("print")) {
            emit(LI, getValueReg(0), "4");  // Code for syscall: print_string
            emit(SYSCALL);
        } else if (func.equals(fun.peek())) {
            paramss = params.pop();
            emit(JAL, fun.pop());
            emit(MOVE, values, "$v0");
        } else if (func.equals("return")) {
            nextFunc--;
            emit(MOVE, "$v0", values);
        }

        return values;
    }

    @Override
    protected String visitCompound(AST node) {
    	for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}
        return null;
    }

    @Override
    protected String visitIf(AST node) {
        String stm = visit(node.getChild(0));
        String end_if = generateLabel("end_if");
        emit(BEQ, stm, "$0", end_if);
        visit(node.getChild(1));
        emit(end_if, NL);

        return null;
    }

    @Override
    protected String visitIfElse(AST node) {
        String stm = visit(node.getChild(0));
        String else_ = generateLabel("else");
        emit(BEQ, stm, "$0", else_);
        visit(node.getChild(1));
        String end_if = generateLabel("end_if");
        emit(J, end_if);
        emit(else_, NL);
        visit(node.getChild(2));
        emit(end_if, NL);

        return null;
    }

    @Override
    protected String visitFor(AST node) {
        return null;
    }

    @Override
    protected String visitWhile(AST node) {
        String loop = generateLabel("loop");
        emit(loop, NL);

        String stm = visit(node.getChild(0));
        String end_loop = generateLabel("end_loop");
        emit(BEQ, stm, "$0", end_loop);
        visit(node.getChild(1));
        emit(J, loop);
        emit(end_loop, NL);

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
        return null;
    }

    @Override
    protected String visitNull(AST node) {
        node.intData = 0;
        return visitInteger(node);
    }

    @Override
    protected String visitLogical(AST node) {
        return visitInteger(node);
    }

    @Override
    protected String visitInteger(AST node) {
        if (node.type == ARRAY_TYPE) {

            if (node.getChildSize() == 0) {
                return null;
            }
            String head = newTempReg();
            String label = generateLabel("array");
            
            emit(LA, head, label);
            data(label, ".word", "0");

            ArrayList<String> values = new ArrayList<String>();
            AST sublist = node.getChild(0);
            for (int i = 0; i < sublist.getChildSize(); i++) {
                values.add(visit(sublist.getChild(i)));
            }
            for (int i = 0; i < values.size(); i++) {
                emit(SW3, values.get(i), str(4*i), head);
            }
            return head;
        } else {
            int c = node.intData;
            if (params.size() == 0) {
                String x = newTempReg();
	            emit(LI, x, str(c));
	            return x;
            } else {
                String x = newSReg();
	            emit(LI, x, str(c));
                emit(MOVE, newArgReg(), x);
	            return x;
            }
        }
    }

    @Override
    protected String visitDouble(AST node) {
        Double c = node.doubleData;
        String label = generateLabel("double");
        data(label, ".double", str(c));
        String x = newFloatReg();
	    text(LD, x, label);

	    return x;
    }

    @Override
    protected String visitComplex(AST node) {
        return null;
    }

    @Override
    protected String visitCharacter(AST node) {
        String label = generateLabel("char");
        data(label, ".asciiz", st.getName(node.intData));
        String x = newArgReg();
	    emit(LA, x, label);

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
        return visit(node.getChild(0));
    }

    @Override
    protected String visitExprList(AST node) {
        for (int i = 0; i < node.getChildSize(); i++) {
    		visit(node.getChild(i));
    	}
        return null;
    }

    @Override
    protected String visitFormList(AST node) {
        System.out.println("formlist");
        for (int i = 0; i < node.getChildSize(); i++) {
    		System.out.println(node.getChild(i).kind);
    	}
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
        return visitInteger(node);
    }

    @Override
    protected String visitL2D(AST node) {
        node.doubleData = Double.valueOf(node.intData);
        return visitDouble(node);
    }

    @Override
    protected String visitI2D(AST node) {
        node.doubleData = Double.valueOf(node.intData);
        return visitDouble(node);
    }

    @Override
    protected String visitI2L(AST node) {
        return visitInteger(node);
    }

    @Override
    protected String visitD2L(AST node) {
        node.intData = (int) node.doubleData;
        return visitInteger(node);
    }

}
