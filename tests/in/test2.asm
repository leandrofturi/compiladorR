# tests/in/test2.asm in MIPS assembly
.data
	char_2: .asciiz "True\n"

.text

.globl main

main:
	li $t1, 1
	li $t2, 0
	seq $t0, $t1, $t2
	beq $t0, $0, else_1
	la $a0, char_2
	li $v0, 4
	syscall
	j end_if_3
	else_1: 
	li $t3, 1
	li $t4, 2
	add $t5, $t3, $t4
	end_if_3: 
	
	li $v0, 10
	syscall

