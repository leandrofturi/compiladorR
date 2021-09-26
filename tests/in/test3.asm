# tests/in/test3.asm in MIPS assembly
.data
	i: .word 0
	char_3: .asciiz "i\n"

.text

.globl main

main:
	li $t0, 0
	sw $t0, i
	loop_1: 
	li $t2, 5
	slt $t1, $t0, $t2
	beq $t1, $0, end_loop_2
	li $t3, 1
	add $t0, $t0, $t3
	la $a0, char_3
	li $v0, 4
	syscall
	j loop_1
	end_loop_2: 
	
	li $v0, 10
	syscall

