package code;

import java.util.Formatter;

import static code.OpCode.LW3;
import static code.OpCode.SW3;

// Instruction quadruple.
public final class Instruction {

	// Público para não precisar de getter/setter.
	public final OpCode op;
	// Estes campos não podem ser final por causa do backpatching...
	public String label;
	public String o1;
	public String o2;
	public String o3;

	public Instruction(OpCode op, String o1, String o2, String o3) {
		this.label = null;
		this.op = op;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
	}

	public Instruction(String label, OpCode op, String o1, String o2, String o3) {
		this.label = label;
		this.op = op;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		if ((this.op == LW3) || (this.op == SW3)) {
			if (this.label != null) {
				f.format("%s: ", this.label);
			}
			f.format("%s", this.op.toString());
			if (this.op.opCount == 1) {
				f.format(" %s", this.o1);
			} else if (this.op.opCount == 2) {
				f.format(" %s, %s", this.o1, this.o2);
			} else if (this.op.opCount == 3) {
				f.format(" %s, %s(%s)", this.o1, this.o2, this.o3);
			}
		} else {
			if (this.label != null) {
				f.format("%s: ", this.label);
			}
			f.format("%s", this.op.toString());
			if (this.op.opCount == 1) {
				f.format(" %s", this.o1);
			} else if (this.op.opCount == 2) {
				f.format(" %s, %s", this.o1, this.o2);
			} else if (this.op.opCount == 3) {
				f.format(" %s, %s, %s", this.o1, this.o2, this.o3);
			}
		}
		f.close();
		return sb.toString();
	}
	
	// Constantes
	
	// Basic arch: 32 int registers and 32 float registers.
	public static final int INT_REGS_COUNT   = 32;  // i0 to i31: int registers.
	public static final int FLOAT_REGS_COUNT = 32;	// f0 to f31: float registers.
	// The machine also has a dedicated program counter (PC) register.

	// Memory is split between data and instruction memory.
	// This is called the Harvard architecture, in contrast to the von Neumann
	// (stored program) architecture.
	public static final int INSTR_MEM_SIZE = 1024;	// instr_mem[]
	public static final int DATA_MEM_SIZE  = 1024;  // data_mem[]
	// The machine also has a string table str_tab[] for storing strings with
	// the command SSTR. Maximum size for each string is 128 chars.

}
