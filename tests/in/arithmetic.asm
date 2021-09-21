# tests/in/arithmetic.asm in MIPS assembly
.data
	pt_0:	.double 1.0
	pt_1:	.double 2.0
	pt_2:	.word 0

.text
	l.d $f0, pt_0
	l.d $f2, pt_1

.globl main

main:
	div.d $f4, $f0, $f2
	s.d $f4, pt_2
	mfhi $t0
	mflo $t1
	li $v0, 10
	syscall
