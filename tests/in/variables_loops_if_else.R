##################################################
# Variables, loops, if/else
##################################################

# A variable is like a box you store a value in for later use.
# We call this "assigning" the value to the variable.
# Having variables lets us write loops, functions, and if/else statements

# VARIABLES
# Lots of way to assign stuff:
x = 5 # this is possible
y <- "1" # this is preferred
TRUE -> z # this works but is weird

# LOOPS
# We've got for loops
for (i in 1:4) {
  print(i)
}
# We've got while loops
a <- 10
while (a > 4) {
	cat(a, "...", sep = "")
	a <- a - 1
}
# Keep in mind that for and while loops run slowly in R
# Operations on entire vectors (i.e. a whole row, a whole column)
# or apply()-type functions (we'll discuss later) are preferred

# IF/ELSE
# Again, pretty standard
if (4 > 3) {
	print("4 is greater than 3")
} else {
	print("4 is not greater than 3")
}
# =>
# [1] "4 is greater than 3"

# FUNCTIONS
# Defined like so:
jiggle <- function(x) {
	x = x + rnorm(1, sd=.1)	#add in a bit of (controlled) noise
	return(x)
}
# Called like any other R function:
jiggle(5)	# 5±ε. After set.seed(2716057), jiggle(5)==5.005043
