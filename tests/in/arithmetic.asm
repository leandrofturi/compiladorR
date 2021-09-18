# tests/in/arithmetic.asm in MIPS assembly
		.text

		.globl main

main:
		li $t0, 1
		li $t1, 2
		add $t2, $t0, $t1
		sw $t2, pt_0
		li $v0, 10
		syscall

		.data

pt_0:	.word 0
