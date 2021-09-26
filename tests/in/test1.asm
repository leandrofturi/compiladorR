# tests/in/test1.asm in MIPS assembly
.data
	array_1: .word 0

.text

.globl main

main:
	li $t0, 1
	li $t1, 2
	add $t2, $t0, $t1
	la $t3, array_1
	li $t4, 1
	li $t5, 2
	li $t6, 3
	li $t7, 4
	sw $t4, 0($t3)
	sw $t5, 4($t3)
	sw $t6, 8($t3)
	sw $t7, 12($t3)
	
	li $v0, 10
	syscall

