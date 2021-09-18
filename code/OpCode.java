package code;


public enum OpCode {
	
    SYSCALL("syscall", 0),   // System calls are used for input and output, and to exit the program
	
    LI("li", 2),            // (Pseudo-instruction) Loads immediate value into register
    LA("la", 2),            // (Pseudo-instruction) Loads computed address of label (not its contents) into register
    
    ASCII(".asciiz", 1);
	
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


