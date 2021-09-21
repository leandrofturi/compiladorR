package code;

public enum OpCode {
	// Arithmetic
    ADD("add", 3),
	ADDD("add.d", 3),
	SUB("sub", 3),
	SUBD("sub.d", 3),
	MUL("mult", 2),			// Upper 32 bits stored in special register hi
	MULD("mul.d", 3),		// Lower 32 bits stored in special register lo
	DIV("div", 2),			// Remainder stored in special register hi
	DIVD("div.d", 3),			// Quotient stored in special register lo

	// Logical
	BIT_AND("and", 3),			// Bitwise AND
	BIT_OR("or", 3),			// Bitwise OR

	// Data Transfer
	LW("lw", 2),            // Copy from memory to register
	LD("l.d", 2),
	SW("sw", 2),            // Copy from register to memory
	SD("s.d", 2),
	LA("la", 2),            // (Pseudo-instruction) Loads computed address of label (not its contents) into register
	LI("li", 2),            // (Pseudo-instruction) Loads immediate value into register
	MFHI("mfhi", 1),		// Copy from special register hi to general register
	MFLO("mflo", 1),		// Copy from special register hi to general register
	MOVE("move", 2),		// Pseudo-instruction (provided by assembler, not processor!)
							// Copy from register to register.

	// Assembler Directives
    ASCII(".asciiz", 1),	// Store the ASCII string str in memory and null-terminate it
							// Strings are in double-quotes, i.e. "Computer Science"
	WORD(".word", 1),		// Store n 32-bit values in successive memory words
	DOUBLE(".double", 1),
	

	SYSCALL("syscall", 0);   // System calls are used for input and output, and to exit the program
	
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


