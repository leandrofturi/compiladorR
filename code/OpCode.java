package code;


public enum OpCode {
	
    SYSCALL("syscall", 0),   // System calls are used for input and output, and to exit the program
	
    LI("li", 2),            // (Pseudo-instruction) Loads immediate value into register
    LA("la", 2),            // (Pseudo-instruction) Loads computed address of label (not its contents) into register
    ADD("add", 3),
	SW("sw", 2),			// Copy from register to memory

    ASCII(".asciiz", 1),	// Store the ASCII string str in memory and null-terminate it
							// Strings are in double-quotes, i.e. "Computer Science"
	WORD(".word", 1);		// Store n 32-bit values in successive memory words
	
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


