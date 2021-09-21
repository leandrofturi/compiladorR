# tests/in/HelloWord.asm in MIPS assembly
.data
	pt_0:	.asciiz "Hello World!\n"

.text

.globl main

main:
	li $v0, 4
	la $a0, pt_0
	syscall
	li $v0, 10
	syscall
