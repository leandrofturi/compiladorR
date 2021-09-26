package code;

public enum OpCode {
	// Arithmetic
    ADD("add", 3),
	ADDI("addi", 3),
	ADDD("add.d", 3),
	SUB("sub", 3),
	SUBD("sub.d", 3),
	MUL("mult", 2),			// Upper 32 bits stored in special register hi
	MULD("mul.d", 3),		// Lower 32 bits stored in special register lo
	DIV("div", 2),			// Remainder stored in special register hi
	DIVD("div.d", 3),		// Quotient stored in special register lo

	// Logical
	AND("and", 3),
	OR("or", 3),
	NOT("not", 2),
	SEQ("seq", 3),
	SGE("sge", 3),
	SGT("sgt", 3),
	SLE("sle", 3),
	SLT("slt", 3),
	SNE("sne", 3),

	// Data Transfer
	LW("lw", 2),            // Copy from memory to register
	LW3("lw", 3),
	LD("l.d", 2),
	SW("sw", 2),            // Copy from register to memory
	SW3("sw", 3),            // Copy from register to memory
	SD("s.d", 2),
	LA("la", 2),            // (Pseudo-instruction) Loads computed address of label (not its contents) into register
	LI("li", 2),            // (Pseudo-instruction) Loads immediate value into register
	MFHI("mfhi", 1),		// Copy from special register hi to general register
	MFLO("mflo", 1),		// Copy from special register hi to general register
	MOVE("move", 2),		// Pseudo-instruction (provided by assembler, not processor!)
							// Copy from register to register.

	// Conditional Branch
	BEQ("beq", 3),			// Test if registers are equal
	BNE("bne", 3),			// Test if registers are not equal
	BGT("bgt", 3),			// Pseduo-instruction
	BGE("bge", 3),			// Pseduo-instruction
	BLT("blt", 3),			// Pseduo-instruction
	BLE("ble", 3),			// Pseduo-instruction

	// Unconditional Jump
	J("j", 1),				// Jump to target address
	JR("jr", 1),			// For switch, procedure return
	JAL("jal", 1),			// Use when making procedure call.
							// This saves the return address in $ra

	SYSCALL("syscall", 0),  // System calls are used for input and output, and to exit the program
	NL("", 0);				// Empty line
	
	public final String name;
	public final int opCount;
	
	private OpCode(String name, int opCount) {
		this.name = name;
		this.opCount = opCount;
	}
	
	public String toString() {
		return this.name;
	}
	
}


