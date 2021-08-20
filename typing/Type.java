package typing;

import static typing.Conv.Unif;
import static typing.Conv.L2I;
import static typing.Conv.L2D;
import static typing.Conv.I2D;
import static typing.Conv.I2L;
import static typing.Conv.D2L;
import static typing.Conv.NONE;


// Enumeração dos tipos primitivos mapeados.
// https://cran.r-project.org/doc/manuals/r-release/R-lang.html
public enum Type {
	//"NULL"	NULL
	NULL_TYPE {
		public String toString() {
            return "NULL";
        }
	},

	//"symbol"	a variable name
	SYMBOL_TYPE {
		public String toString() {
            return "symbol";
        }
	},

	//"pairlist"	a pairlist object (mainly internal)

	//"closure"	a function
	CLOSURE_TYPE {
		public String toString() {
            return "closure";
        }
	},

	//"environment"	an environment

	//"promise"	an object used to implement lazy evaluation

	//"language"	an R language construct

	//"special"	an internal function that does not evaluate its arguments

	//"builtin"	an internal function that evaluates its arguments

	//"logical"	a vector containing logical values
	LOGICAL_TYPE {
		public String toString() {
            return "logical";
        }
	},

	//"integer"	a vector containing integer values
	INTEGER_TYPE {
		public String toString() {
            return "integer";
        }
	},

	//"double"	a vector containing real values
	DOUBLE_TYPE {
		public String toString() {
            return "double";
        }
	},

	//"complex"	a vector containing complex values
	COMPLEX_TYPE {
		public String toString() {
            return "complex";
        }
	},

	//"character"	a vector containing character values
	CHARACTER_TYPE {
		public String toString() {
            return "character";
        }
	},

	//"expression"	an expression object

	//"list"	a list
	LIST_TYPE {
		public String toString() {
            return "list";
        }
	},

	//"externalptr"	an external pointer object

	//"weakref"	a weak reference object

	//"raw"	a vector containing bytes

	//"S4"	an S4 object which is not a simple object

	// Indica um erro de tipos.
	NO_TYPE {
		public String toString() {
            return "no_type";
        }
	};
	
	public Unif unifyArithmetic(Type that) {
		if (this == LOGICAL_TYPE && that == LOGICAL_TYPE) {
			return new Unif(LOGICAL_TYPE, NONE, NONE);
		} else if (this == INTEGER_TYPE && that == INTEGER_TYPE) {
			return new Unif(INTEGER_TYPE, NONE, NONE);
		} else if (this == DOUBLE_TYPE && that == DOUBLE_TYPE) {
			return new Unif(DOUBLE_TYPE, NONE, NONE);
		} else if (this == LOGICAL_TYPE) {
			if (that == INTEGER_TYPE) {
				return new Unif(INTEGER_TYPE, L2I, NONE);
			} else if (that == DOUBLE_TYPE) {
				return new Unif(DOUBLE_TYPE, L2D, NONE);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else if (this == INTEGER_TYPE) {
			if (that == LOGICAL_TYPE) {
				return new Unif(INTEGER_TYPE, NONE, L2I);
			} else if (that == DOUBLE_TYPE) {
				return new Unif(DOUBLE_TYPE, I2D, NONE);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else if (this == DOUBLE_TYPE) {
			if (that == LOGICAL_TYPE) {
				return new Unif(DOUBLE_TYPE, NONE, L2D);
			} else if (that == INTEGER_TYPE) {
				return new Unif(DOUBLE_TYPE, NONE, I2D);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else {
			return new Unif(NO_TYPE, NONE, NONE);
		}
	}

	public Unif unifyLogic(Type that) {
		if (this == LOGICAL_TYPE && that == LOGICAL_TYPE) {
			return new Unif(LOGICAL_TYPE, NONE, NONE);
		} else if (this == INTEGER_TYPE && that == INTEGER_TYPE) {
			return new Unif(LOGICAL_TYPE, I2L, I2L);
		} else if (this == DOUBLE_TYPE && that == DOUBLE_TYPE) {
			return new Unif(LOGICAL_TYPE, D2L, D2L);
		} else if (this == LOGICAL_TYPE) {
			if (that == INTEGER_TYPE) {
				return new Unif(LOGICAL_TYPE, NONE, I2L);
			} else if (that == DOUBLE_TYPE) {
				return new Unif(LOGICAL_TYPE, NONE, D2L);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else if (this == INTEGER_TYPE) {
			if (that == LOGICAL_TYPE) {
				return new Unif(LOGICAL_TYPE, I2L, NONE);
			} else if (that == DOUBLE_TYPE) {
				return new Unif(LOGICAL_TYPE, I2L, D2L);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else if (this == DOUBLE_TYPE) {
			if (that == LOGICAL_TYPE) {
				return new Unif(LOGICAL_TYPE, D2L, NONE);
			} else if (that == INTEGER_TYPE) {
				return new Unif(LOGICAL_TYPE, D2L, I2L);
			} else {
				return new Unif(NO_TYPE, NONE, NONE);
			}
		} else {
			return new Unif(NO_TYPE, NONE, NONE);
		}
	}
/*
	import static ast.NodeKind.L2I_NODE;
import static ast.NodeKind.L2D_NODE;
import static ast.NodeKind.I2D_NODE;
import static typing.Conv.NONE;
*/
}