	.text           # code section
                    # indicates that following items are stored in the user text segment, typically instructions

	.globl main     # starting point: must be global
                    # declare that symbol sym is global and can be referenced from other files

main:
	# user program code 

	.data           # data section
                    # indicates that following data items are stored in the data segment
	# user program data
