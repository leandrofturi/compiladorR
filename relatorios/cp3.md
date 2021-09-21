spim is a self-contained simulator that runs MIPS32 assembly language programs. spim also provides a simple debugger and minimal set of operating system services.

spim load "/mnt/c/Users/leand/Downloads/example2_hello_world.asm"

https://www2.engr.arizona.edu/~ece369/Resources/spim/QtSPIM_examples.pdf

https://ecs-network.serv.pacific.edu/ecpe-170/tutorials/mips-example-programs

http://www.cs.iit.edu/~virgil/cs470/Labs/Lab1.pdf

MARS does not appear to have any instructions/pseudo instructions that load floating point immediate values into floating registers. Instead, you need to put the floating point value in memory and load the register from memory: