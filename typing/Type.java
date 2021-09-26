package typing;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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

	ARRAY_TYPE {
		public String toString() {
            return "array";
        }
	},

	// Indica um erro de tipos.
	NO_TYPE {
		public String toString() {
            return "no_type";
        }
	};

	public Unif unifyArithmetic(Type... args) {
		List<Integer> thats = new ArrayList<>();
		thats.add(this.ordinal());
		for(Type a: args) thats.add(a.ordinal());

		return this.unifyArithmetic(thats);
	}

	public Unif unifyArithmetic(List<Integer> thats) {
		Type resultType = this.values()[Collections.max(thats)];
		List<Conv> resultConv = new ArrayList<>();

		// Em caso de tipos que não sejam numéricos
		if((resultType != LOGICAL_TYPE) && (resultType != INTEGER_TYPE) && (resultType != DOUBLE_TYPE)) {
			for(int that: thats) {
				resultConv.add(NONE);
			}
			return new Unif(resultType, resultConv);
		}

		if (this == SYMBOL_TYPE) {
			for(int that: thats) {
				resultConv.add(NONE);
			}
			return new Unif(resultType, resultConv);
		}

		if(resultType == LOGICAL_TYPE) {
			for(int that: thats) {
				if (this.values()[that] == LOGICAL_TYPE) {
					resultConv.add(NONE);
				} else {
					return new Unif(NO_TYPE);
				}
			}
		} else if(resultType == INTEGER_TYPE) {
			for(int that: thats) {
				if (this.values()[that] == LOGICAL_TYPE) {
					resultConv.add(L2I);
				} else if (this.values()[that] == INTEGER_TYPE) {
					resultConv.add(NONE);
				} else {
					return new Unif(NO_TYPE);
				}
			}
		} else if(resultType == DOUBLE_TYPE) {
			for(int that: thats) {
				if (this.values()[that] == LOGICAL_TYPE) {
					resultConv.add(L2D);
				} else if (this.values()[that] == INTEGER_TYPE) {
					resultConv.add(I2D);
				} else if (this.values()[that] == DOUBLE_TYPE) {
					resultConv.add(NONE);
				} else {
					return new Unif(NO_TYPE);
				}
			}
		} else {
			return new Unif(NO_TYPE);
		}
		
		return new Unif(resultType, resultConv);
	}


	public Unif unifyLogic(Type... args) {
		List<Integer> thats = new ArrayList<>();
		thats.add(this.ordinal());
		for(Type a: args) thats.add(a.ordinal());

		List<Conv> resultConv = new ArrayList<>();

		for(int that: thats) {
			if (this.values()[that] == LOGICAL_TYPE) {
				resultConv.add(NONE);
			} else if (this.values()[that] == INTEGER_TYPE) {
				resultConv.add(I2L);
			} else if (this.values()[that] == DOUBLE_TYPE) {
				resultConv.add(D2L);
			} else {
				return new Unif(NO_TYPE);
			}
		}
		
		return new Unif(LOGICAL_TYPE, resultConv);
	}

}