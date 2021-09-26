# tests/in/test4.asm in MIPS assembly
.data
	y: .word 0
	char_1: .asciiz "hello word!\n"

.text

.globl main

main:
	li $s2, 1
	move $a2, $s2
	jal x
	move $s2, $v0
	
	li $v0, 10
	syscall

# Functions
	x: 
	addi $sp, $sp, -4
	sw $s0, 0($sp)
	
	la $a0, char_1
	li $v0, 4
	syscall
	li $s1, 1
	move $v0, $s1
	
	
	jr $ra
